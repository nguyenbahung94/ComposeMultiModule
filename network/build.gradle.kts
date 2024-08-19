plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.composeln.kotlin.android)
    alias(libs.plugins.composeln.hilt)
}

android {
    namespace = libs.plugins.networkNameSpace.get().toString()
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(projects.core)

    // Data dependencies
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.gson.converter)
}
