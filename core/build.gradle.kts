plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.composeln.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = libs.plugins.coreNameSpace.get().toString()
}

dependencies {
    implementation(libs.retrofit.core)

    // Presentation Dependencies
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.hilt.navigation)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.navigation)
    implementation(libs.compose.ui.material)
    implementation(libs.compose.activity)
    implementation(libs.coil)
}
