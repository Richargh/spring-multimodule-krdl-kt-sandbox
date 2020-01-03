import de.richargh.sandbox.spring.multibuild.Deps
import de.richargh.sandbox.spring.multibuild.testArchive

plugins {
    id("org.springframework.boot")

    kotlin("jvm")

    // order is important, apply these plugins last
    id("buildSrc.testsets")
    id("buildSrc.testarchive")
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
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    runtimeOnly("org.springframework.boot:spring-boot-devtools")

    /** Test dependencies **/
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        exclude(module = "mockito-core")
    }
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.assertj:assertj-core")
}

springBoot {
    mainClassName = "de.richargh.sandbox.spring.multibuild.rome.RomeKt"
}
