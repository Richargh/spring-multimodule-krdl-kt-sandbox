package de.richargh.sandbox.spring.multibuild

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.logging.Logging
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.register

open class TestarchivePlugin: Plugin<Project> {

    private val log = Logging.getLogger(javaClass)

    override fun apply(project: Project) {
        project.registerTestArchive()
    }

    private fun Project.registerTestArchive() {
        val sourceSets = extensions.findByType(SourceSetContainer::class.java)
        if (sourceSets == null) {
            log.error("Couldn't find source sets in $name")
        } else {
            configurations.register(testArchive) {
                extendsFrom(configurations["testCompile"])
            }

            tasks.register<Jar>(name = "jarTest") {
                from(sourceSets["test"].output)
                description = "create a jar from the test source set"
                archiveClassifier.set("test")
            }

            artifacts {
                add(testArchive, tasks.getByName("jarTest"))
            }
        }
    }
}

const val testArchive = "testArchive"