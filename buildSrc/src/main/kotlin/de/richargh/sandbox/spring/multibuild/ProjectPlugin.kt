package de.richargh.sandbox.spring.multibuild

import javafx.beans.property.Property
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.logging.Logging
import org.gradle.api.plugins.JavaPluginConvention
import org.gradle.api.tasks.SourceSet
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.*

open class ProjectPlugin: Plugin<Project> {

    var logger = Logging.getLogger(javaClass)

    override fun apply(project: Project) {
//        project.getTasks().create("hello", HelloTask::class.java)
        logger.lifecycle("start")



//        val sourceSets = project.extensions.getByType(SourceSetContainer::class)
//        sourceSets.create("integTest") {
//                compileClasspath += sourceSets["main"].output
//                runtimeClasspath += sourceSets["main"].output
//        }
//
//        project.configurations.getting {
//            extendsFrom(project.configurations["implementation"])
//        }
//
//        project.configurations["intTestRuntimeOnly"].extendsFrom(project.configurations["runtimeOnly"])
//
//
//
//        project.configure<ProjectPlugin> {
//
//        }

////        val sourceSet = addSourceSet(TestType.INTEGRATION)
//        addDependenciesAndConfigurations(TestType.INTEGRATION)
//        createTasks(sourceSet, TestType.INTEGRATION)
    }

//    internal fun Project.addSourceSet(testType: TestType): SourceSet {
//        val prefix = testType.prefix
//        this.s
//
//        val main by kotlin.sourceSets.getting
//        return kotlin.sourceSets.create("${prefix}Test") {
//            compileClasspath += main.output
//            runtimeClasspath += main.output
//        }
//    }
}

enum class TestType(val prefix: String, val executers: List<String>, val libRepoRequired: Boolean) {
    INTEGRATION("integ", listOf("embedded", "forking", "noDaemon", "parallel", "instant", "vfsRetention"), false),
    CROSSVERSION("crossVersion", listOf("embedded", "forking"), true)
}