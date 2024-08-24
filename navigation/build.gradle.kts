plugins {
    alias(libs.plugins.composeln.library)
    alias(libs.plugins.composeln.kotlin.android)
    alias(libs.plugins.composeln.hilt)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = libs.plugins.navigationNameSpace.get().toString()
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation(projects.core)
    implementation(libs.compose.navigation)
}
