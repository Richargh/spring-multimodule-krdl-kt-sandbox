plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    kotlin("jvm") version "1.3.50"
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

repositories {
    mavenCentral()
}

dependencies {
    /** Main dependencies **/
    implementation(gradleApi())

    /** Test dependencies **/
    // none
}
