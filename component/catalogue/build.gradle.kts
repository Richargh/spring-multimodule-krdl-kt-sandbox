import de.richargh.sandbox.spring.multibuild.testArchive
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot")

    kotlin("jvm")

    // order is important, apply this buildSrc plugin last
    id("de.richargh.sandbox.spring.multibuild")
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

    runtimeOnly("com.h2database:h2:1.4.200") // See https://github.com/spring-projects/spring-boot/issues/18593 and https://github.com/h2database/h2database/issues/1841
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

