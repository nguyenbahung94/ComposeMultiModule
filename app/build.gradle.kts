plugins {
    alias(libs.plugins.composeln.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.composeln.hilt)
}

android {
    defaultConfig {
        applicationId = libs.plugins.mainNameSpace.get().toString()
        versionCode = 1
        versionName = "1.0"
        vectorDrawables {
            useSupportLibrary = true
        }

        buildFeatures {
            buildConfig = true
        }
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    namespace = libs.plugins.mainNameSpace.get().toString()

    hilt {
        enableAggregatingTask = true
    }
}

kotlin {
    jvmToolchain(17)
}
dependencies {
    implementation(projects.navigation)
    implementation(projects.core)
    implementation(projects.home)
    implementation(projects.detail)
    implementation(projects.list)
    implementation(projects.network)

    // kotlin Coroutines Dependencies
    implementation(libs.coroutines.android)
    implementation(libs.coroutines.core)

    // androidX dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.lifecyle.ktx)
    implementation(libs.lifecycle.viewmodel)

    // Compose Dependencies
    implementation(libs.compose.activity)
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.ui.material)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material.icon.core)
    implementation(libs.compose.runtime)
    implementation(libs.compose.navigation)
    implementation(libs.compose.paging)

    // core Dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    // lifecycle Dependencies
    implementation(libs.lifecyle.ktx)

    // Testing
    testImplementation(libs.junit)
    testImplementation(libs.hilt.testing)
    implementation(libs.junit.ext)
    implementation(libs.espresso)
}
