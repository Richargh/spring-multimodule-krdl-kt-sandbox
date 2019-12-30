plugins {
    kotlin("jvm")

    // order is important, apply this buildSrc plugin last
    id("de.richargh.sandbox.spring.multibuild")
}

dependencies {
    /** Language dependencies **/
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))

    /** Main dependencies **/
    // none

    /** Test dependencies **/
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.2")
    testImplementation("com.ninja-squad:springmockk:1.1.3")
}
