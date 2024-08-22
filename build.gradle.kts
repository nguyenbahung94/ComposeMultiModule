// Top-level build file where you can add configuration options common to all subprojects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.daggerHilt) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.org.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.android.detekt) apply false
    alias(libs.plugins.android.kotliner) apply false
}
allprojects {
    tasks.withType<JavaCompile> {
        options.compilerArgs.add("-parameters")
    }
}
task("clean") {
    delete("projectDir/build")
}
