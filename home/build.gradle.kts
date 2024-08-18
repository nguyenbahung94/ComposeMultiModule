plugins {
    alias(libs.plugins.composeln.feature)
}

android {
    namespace = libs.plugins.homeNameSpace.get().toString()
}

dependencies {
    // presentation dependencies
    libs.apply {
        implementation(bundles.compose)
        implementation(bundles.retrofit)
    }
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.hilt.navigation)
    implementation(libs.pager)
    implementation(libs.coil)
}
