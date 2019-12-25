package de.richargh.sandbox.spring.multibuild

import org.gradle.internal.impldep.com.amazonaws.util.ValidationUtils.assertNotNull
import org.gradle.internal.impldep.org.junit.Assert.assertFalse
import org.gradle.internal.impldep.org.junit.Assert.assertTrue
import org.gradle.internal.impldep.org.junit.Test
import org.gradle.testfixtures.ProjectBuilder

class ProjectPluginTest {
    @Test
    fun greetingTest() {
        val project = ProjectBuilder.builder().build()
        project.pluginManager.apply("com.baeldung.greeting")

        assertFalse(true)
        assertTrue(project.pluginManager
                           .hasPlugin("com.baeldung.greeting"))
    }
}