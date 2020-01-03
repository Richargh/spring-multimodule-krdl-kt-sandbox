import de.richargh.sandbox.spring.multibuild.testArchive
import de.richargh.sandbox.spring.multibuild.mediumTestImplementation
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot")

    kotlin("jvm")

    // order is important, apply these plugins last
    id("buildSrc.testsets")
    id("buildSrc.testarchive")
}

dependencies {
    /** Project dependencies **/
    implementation(project(":component:catalogue-api"))
    implementation(project(":component:shared-web"))
    implementation(project(":component:shared-kernel"))
    testImplementation(project(":component:shared-kernel", testArchive))
    mediumTestImplementation(project(":component:shared-kernel", testArchive))
    mediumTestImplementation(project(":component:catalogue", testArchive))

    /** Language dependencies **/
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))

    /** Main dependencies **/
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    runtimeOnly("org.springframework.boot:spring-boot-devtools")

    /** Test dependencies **/
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        exclude(module = "mockito-core")
    }
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

// do not build an executable jar, this is a library
tasks.getByName<BootJar>("bootJar") {
    enabled = false
}

val jar by tasks.getting(Jar::class) {
    enabled = true
}

