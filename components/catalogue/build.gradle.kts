import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot")

    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    /** Project dependencies **/
    implementation(project(":components:catalogue_api"))
    implementation(project(":components:shared_kernel"))
    testImplementation(project(":components:shared_kernel", "testArchive"))

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
    testImplementation("com.ninja-squad:springmockk:1.1.3")
}

// do not build an executable jar, this is a library
tasks.getByName<BootJar>("bootJar") {
    enabled = false
}

val jar by tasks.getting(Jar::class) {
    enabled = true
}
