import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.2.2.RELEASE" apply false
    id("io.spring.dependency-management") version "1.0.8.RELEASE" apply false
    id("de.richargh.sandbox.spring.multibuild")
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

//    val sourceSets = the<SourceSetContainer>()
//
//    sourceSets {
//        create("integTest") {
//            java.srcDir(file("src/integTest/java"))
//            resources.srcDir(file("src/integTest/resources"))
//            compileClasspath += sourceSets["main"].output + configurations["testRuntimeClasspath"]
//            runtimeClasspath += output + compileClasspath
//        }
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
