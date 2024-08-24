plugins {
    alias(libs.plugins.composeln.library)
    alias(libs.plugins.composeln.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = libs.plugins.coreNameSpace.get().toString()
    buildFeatures {
        buildConfig = true
    }
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation(libs.retrofit.core)

    // Presentation Dependencies
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.runtime)
    implementation(libs.coil)

    libs.apply {
        implementation(bundles.compose)
        implementation(bundles.navigation)
    }
}
