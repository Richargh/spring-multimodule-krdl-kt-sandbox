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

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
