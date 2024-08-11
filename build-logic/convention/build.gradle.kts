plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}
dependencies {
    implementation(libs.build.gradle.plugin)
    implementation(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidApp") {
            id = "composeln.application"
            implementationClass = "plugins.AndroidApplicationComposeConventionPlugin"
        }
        register("androidHilt") {
            id = "composeln.hilt"
            implementationClass = "plugins.AndroidHiltConventionPlugin"
        }
        register("androidLibrary") {
            id = "composeln.library"
            implementationClass = "plugins.AndroidLibraryComposeConventionPlugin"
        }
        register("androidKotlin") {
            id = "composeln.kotlin.android"
            implementationClass = "plugins.AndroidKotlinConventionPlugin"
        }
    }
}
