import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    id("org.springframework.boot")

    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    /** Project dependencies **/
    implementation(project(":component:catalogue"))
    implementation(project(":component:factory"))

    /** Language dependencies **/
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))

    /** Main dependencies **/
    implementation("org.springframework.boot:spring-boot-autoconfigure")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
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

springBoot {
    mainClassName = "de.richargh.sandbox.spring.multibuild.margarita.MargaritaKt"
}
