package de.richargh.sandbox.spring.multibuild

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.logging.Logging
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.register

open class ProjectPlugin: Plugin<Project> {

    var logger = Logging.getLogger(javaClass)

    override fun apply(project: Project) {
        logger.lifecycle("start")
        project.createTestset("mediumTest", "test")
        project.createTestset("largeTest", "mediumTest")
    }

    private fun Project.createTestset(testset: String, mustRunAfterTask: String) {
        val sourceSets = extensions.findByType(SourceSetContainer::class.java)
        if (sourceSets == null) {
            logger.lifecycle("Couldn't find source sets in $name")
        } else {
            logger.lifecycle("Found source sets in $displayName")
            sourceSets.create(testset) {
                compileClasspath += sourceSets["main"].output + configurations["testRuntimeClasspath"]
                runtimeClasspath += output + compileClasspath
            }

            tasks.register<Test>(testset) {
                description = "Runs the $testset tests."
                group = "verification"
                testClassesDirs = sourceSets[testset].output.classesDirs
                classpath = sourceSets[testset].runtimeClasspath
                mustRunAfter(tasks[mustRunAfterTask])
            }

            tasks.named("check") {
                dependsOn(testset)
            }
        }
    }
}

fun DependencyHandlerScope.mediumTestImplementation(dependencyNotation: Any) = "mediumTestImplementation"(dependencyNotation)

fun DependencyHandlerScope.largeTestImplementation(dependencyNotation: Any) = "largeTestImplementation"(dependencyNotation)
