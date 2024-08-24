plugins {
    alias(libs.plugins.composeln.library)
    alias(libs.plugins.composeln.kotlin.android)
    alias(libs.plugins.composeln.hilt)
}

android {
    namespace = libs.plugins.navigationNameSpace.get().toString()
}
dependencies {
    implementation(projects.core)
    implementation(libs.compose.navigation)
}
