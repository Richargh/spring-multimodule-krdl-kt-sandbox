import de.richargh.sandbox.spring.multibuild.Deps
import de.richargh.sandbox.spring.multibuild.testArchive

plugins {
    id("org.springframework.boot")

    kotlin("jvm")

    // order is important, apply this buildSrc plugin last
    id("de.richargh.sandbox.spring.multibuild")
}

dependencies {
    /** Project dependencies **/
    implementation(project(":component:shared-web"))
    implementation(project(":component:catalogue"))
    implementation(project(":component:factory"))
    testImplementation(project(":component:shared-kernel", testArchive))

    /** Language dependencies **/
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))

    /** Main dependencies **/
    implementation("org.springframework.fu:spring-fu-kofu:${Deps.Spring.kofuVersion}")
    implementation("org.springframework.boot:spring-boot-autoconfigure")
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

springBoot {
    mainClassName = "de.richargh.sandbox.spring.multibuild.rome.RomeKt"
}
