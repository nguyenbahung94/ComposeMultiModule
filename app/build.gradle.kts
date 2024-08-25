plugins {
    alias(libs.plugins.composeln.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.composeln.hilt)
    alias(libs.plugins.composeln.detekt)
}

android {
    defaultConfig {
        applicationId = libs.plugins.mainNameSpace.get().toString()
        versionCode = libs.versions.application.version.code.get().toInt()
        versionName = libs.versions.application.version.name.get()

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

composeCompiler {
    enableStrongSkippingMode = true
    reportsDestination = layout.buildDirectory.dir("compose_compiler")
}

kotlin {
    jvmToolchain(libs.versions.jvmTarget.get().toInt())
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
    libs.apply {
        implementation(bundles.compose)
    }
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.material.icon.core)
    implementation(libs.compose.runtime)
    implementation(libs.compose.navigation)
    implementation(libs.compose.paging)

    // core Dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    // lifecycle Dependencies
    implementation(libs.lifecyle.ktx)

    implementation(libs.junit.ext)
    implementation(libs.espresso)
    // Testing
    testImplementation(libs.junit)
    testImplementation(libs.hilt.testing)
}
