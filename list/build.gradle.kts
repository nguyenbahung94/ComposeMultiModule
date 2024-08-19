plugins {
    alias(libs.plugins.composeln.feature)
}

android {
    namespace = libs.plugins.listNameSpace.get().toString()
}
dependencies {

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
