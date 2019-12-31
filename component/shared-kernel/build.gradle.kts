plugins {
    kotlin("jvm")

    // order is important, apply this buildSrc plugin last
    id("buildSrc.testsets")
}

dependencies {
    /** Language dependencies **/
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))

    /** Main dependencies **/
    // none

    /** Test dependencies **/
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}
