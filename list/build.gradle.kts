plugins {
    alias(libs.plugins.composeln.library)
    alias(libs.plugins.composeln.kotlin.android)
    alias(libs.plugins.composeln.hilt)
}

android {
    namespace = libs.plugins.listNameSpace.get().toString()
}
dependencies {
    implementation(projects.core)
    implementation(projects.network)

    implementation(libs.retrofit.core)

    // Presentation dependencies
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.hilt.navigation)
    implementation(libs.compose.navigation)
    implementation(libs.compose.ui.graphics)
    implementation(libs.pager)
    implementation(libs.compose.ui.material)
    implementation(libs.compose.activity)
    implementation(libs.coil)
}