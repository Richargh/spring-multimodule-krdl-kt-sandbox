package de.richargh.sandbox.spring.multibuild

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.logging.Logging

open class ProjectPlugin: Plugin<Project> {

    var logger = Logging.getLogger(javaClass)

    override fun apply(project: Project) {
//        project.getTasks().create("hello", HelloTask::class.java)
        logger.lifecycle("start")
//        val sourceSets = the<SourceSetContainer>()
    }
}
