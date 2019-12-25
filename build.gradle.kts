import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.2.2.RELEASE" apply false
    id("io.spring.dependency-management") version "1.0.8.RELEASE" apply false
    kotlin("jvm") version "1.3.50" apply false
    kotlin("plugin.spring") version "1.3.50" apply false
}

allprojects {
    group = "de.richargh.sandbox.spring.multibuild"
    version = "1.0.0"

    repositories {
        mavenCentral()
        maven("https://repo.spring.io/milestone")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }

}

subprojects {

    apply {
        plugin("io.spring.dependency-management")
    }
    the<DependencyManagementExtension>().apply {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
        testLogging {
            showExceptions = true
            showStandardStreams = true
//            events(PASSED, SKIPPED, FAILED)
        }
    }

    val sourceSets = project.extensions.findByType(SourceSetContainer::class.java)
    if(sourceSets != null) {
        sourceSets.create("integTest") {
            compileClasspath += sourceSets["main"].output
            runtimeClasspath += sourceSets["main"].output
        }

        tasks.register<Test>("integTest") {
            description = "Runs the integration tests."
            group = "verification"
            testClassesDirs = sourceSets["integTest"].output.classesDirs
            classpath = sourceSets["integTest"].runtimeClasspath
            mustRunAfter(tasks["test"])
        }

        tasks.named("check") {
            dependsOn("integTest")
        }
    }








    //    val sourceSets = the<SourceSetContainer>()
//
//    sourceSets {
//    }
//
//    val intTestImplementation by configurations.getting {
//        extendsFrom(configurations.implementation.get())
//    }
//
//    configurations["intTestRuntimeOnly"].extendsFrom(configurations.runtimeOnly.get())

}

tasks.wrapper {
    gradleVersion = "6.0.1"
}
