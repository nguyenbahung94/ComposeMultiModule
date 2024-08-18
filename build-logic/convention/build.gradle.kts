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
    compileOnly(libs.build.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.detekt.gradlePlugin)
    compileOnly(libs.ktlint.kotlinter)
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
        register("androidDetekt") {
            id = "composeln.detekt"
            implementationClass = "plugins.AndroidDetektConventionPlugin"
        }
        register("androidKtlint") {
            id = "composeln.ktlint"
            implementationClass = "plugins.AndroidKotlinterConventionPlugin"
        }
        register("androiFeature") {
            id = "composeln.feature"
            implementationClass = "plugins.AndroidFeatureConventionPlugin"
        }
    }
}
