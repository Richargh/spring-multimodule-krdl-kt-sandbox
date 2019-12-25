package de.richargh.sandbox.spring.multibuild

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.logging.Logging
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.register

open class ProjectPlugin: Plugin<Project> {

    var logger = Logging.getLogger(javaClass)

    override fun apply(project: Project) {
        logger.lifecycle("start")
        project.createTestType("mediumTest")
        project.createTestType("largeTest")
    }

    private fun Project.createTestType(testType: String) {
        val sourceSets = extensions.findByType(SourceSetContainer::class.java)
        if (sourceSets == null) {
            logger.lifecycle("Couldn't find source sets")
        } else {
            sourceSets.create(testType) {
                compileClasspath += sourceSets["main"].output + configurations["testRuntimeClasspath"]
                runtimeClasspath += output + compileClasspath
            }

            tasks.register<Test>(testType) {
                description = "Runs the integration tests."
                group = "verification"
                testClassesDirs = sourceSets[testType].output.classesDirs
                classpath = sourceSets[testType].runtimeClasspath
                mustRunAfter(tasks["test"])
            }

            tasks.named("check") {
                dependsOn(testType)
            }
        }
    }
}

enum class TestType(val prefix: String, val executers: List<String>, val libRepoRequired: Boolean) {
    INTEGRATION("integ", listOf("embedded", "forking", "noDaemon", "parallel", "instant", "vfsRetention"), false),
    CROSSVERSION("crossVersion", listOf("embedded", "forking"), true)
}