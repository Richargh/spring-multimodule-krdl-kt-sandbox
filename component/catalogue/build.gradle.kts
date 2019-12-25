import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot")

    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    /** Project dependencies **/
    implementation(project(":component:catalogue-api"))
    implementation(project(":component:shared-web"))
    implementation(project(":component:shared-kernel"))
    testImplementation(project(":component:shared-kernel", "testArchive"))

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

val sourceSets = project.extensions.findByType(SourceSetContainer::class.java)
if(sourceSets != null) {
    sourceSets.create("integTest") {
        compileClasspath += sourceSets["main"].output + configurations["testRuntimeClasspath"]
        runtimeClasspath += output + compileClasspath
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