plugins {
    alias(libs.plugins.composeln.feature)
}

android {
    namespace = libs.plugins.detailNameSpace.get().toString()
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    // Presentation dependencies
    implementation(platform(libs.compose.bom))
    implementation(libs.pager)
    implementation(libs.coil)

    libs.apply {
        implementation(bundles.compose)
        implementation(bundles.navigation)
        implementation(bundles.retrofit)
    }
}
