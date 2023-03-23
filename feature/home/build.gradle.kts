plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp") version ("1.7.10-1.0.6")
}

apply {
    from("$rootDir/shared_dependencies.gradle")
}

android {
    namespace = "com.brandyodhiambo.home"
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose_version
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":designsystem"))
    implementation(project(":core:common"))
    implementation(project(":core:database"))

    // RamCosta Navigation
    implementation("io.github.raamcosta.compose-destinations:core:1.5.20-beta")
    ksp("io.github.raamcosta.compose-destinations:ksp:1.5.15-beta")

    // Navigation animation
    implementation("com.google.accompanist:accompanist-navigation-animation:0.24.7-alpha")
}

kotlin {
    sourceSets {
        debug {
            kotlin.srcDir("build/generated/ksp/debug/kotlin")
        }
        release {
            kotlin.srcDir("build/generated/ksp/release/kotlin")
        }
    }
}

ksp {
    arg("compose-destinations.mode", "destinations")
    arg("compose-destinations.moduleName", "home")
}
