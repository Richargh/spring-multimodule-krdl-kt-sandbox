package de.richargh.sandbox.spring.multibuild

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.logging.Logging
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.register

open class TestsetPlugin: Plugin<Project> {

    private val log = Logging.getLogger(javaClass)

    override fun apply(project: Project) {
        project.createTestset("mediumTest", mustRunAfter = "test")
        project.createTestset("largeTest", mustRunAfter = "mediumTest")
    }

    private fun Project.createTestset(testset: String, mustRunAfter: String) {
        val sourceSets = extensions.findByType(SourceSetContainer::class.java)
        if (sourceSets == null) {
            log.error("Couldn't find source sets in $name")
        } else {
            sourceSets.create(testset) {
                compileClasspath += sourceSets["main"].output + configurations["testRuntimeClasspath"]
                runtimeClasspath += output + compileClasspath
            }

            tasks.register<Test>(testset) {
                description = "Runs the $testset tests."
                group = "verification"
                testClassesDirs = sourceSets[testset].output.classesDirs
                classpath = sourceSets[testset].runtimeClasspath
                mustRunAfter(tasks[mustRunAfter])
            }

            tasks.named("check") {
                dependsOn(testset)
            }
        }
    }
}

fun DependencyHandlerScope.mediumTestImplementation(dependencyNotation: Any) =
        "mediumTestImplementation"(dependencyNotation)

fun DependencyHandlerScope.largeTestImplementation(dependencyNotation: Any) =
        "largeTestImplementation"(dependencyNotation)