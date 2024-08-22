plugins {
    alias(libs.plugins.composeln.feature)
}

android {
    namespace = libs.plugins.detailNameSpace.get().toString()
}
dependencies {

    implementation(libs.retrofit.core)

    // Presentation dependencies
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.hilt.navigation)
    implementation(libs.compose.navigation)
    implementation(libs.pager)
    implementation(libs.coil)

    libs.apply {
        implementation(bundles.compose)
    }
}
