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
        implementation(bundles.navigation)
    }
    implementation(platform(libs.compose.bom))
    implementation(libs.pager)
    implementation(libs.coil)
}
