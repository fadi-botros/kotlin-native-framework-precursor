//import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework
//
//plugins {
//    kotlin("multiplatform") version "1.6.21"
//    id("maven-publish")
////    id("native.cocoapods") version "1.6.21"
//}
//
//group = "org.example"
//version = "1.0-SNAPSHOT"
//
////repositories {
////    mavenCentral()
////}
//
//kotlin {
//    jvm {
////        android {
////            compileSdk(31)
////        }
//        compilations.all {
//            kotlinOptions.jvmTarget = "1.8"
//        }
//        withJava()
//        testRuns["test"].executionTask.configure {
//            useJUnitPlatform()
//        }
//    }
////    js(BOTH) {
////        browser {
////            commonWebpackConfig {
////                cssSupport.enabled = true
////            }
////        }
////    }
////    macosArm64("native") {
////        iosArm32() { binaries { framework { baseName = "DemoiOS32" } } }
////        iosArm64() { binaries { framework { baseName = "DemoiOS64" } } }
////        iosSimulatorArm64() { binaries { framework { baseName = "DemoiOS64" } } }
////        binaries { framework { baseName = "DemoMacos" } }
////    }
////    ios("native") {
////        targets.add(iosArm32 { binaries { framework { baseName = "DemoSimulator" } } })
////        targets.add(iosArm64 { binaries { framework { baseName = "DemoSimulator" } } })
////        targets.add(iosSimulatorArm64 { binaries { framework { baseName = "DemoSimulator" } } })
////
//////        iosSimulatorArm64() { binaries { framework { baseName = "DemoiOS64" } } }
//////        iosArm32() { binaries { framework { baseName = "DemoiOS32" } } }
////    }
//
////    targets {
////        iosArm32("ios32")
////        iosArm64("ios64")
////        configure([ios32, ios64]) {
////            binaries.framework {
////                baseName = "my_framework"
////            }
////        }
////    }
////    // Create a task building a fat framework.
////    tasks.register("debugFatFramework", FatFrameworkTask) {
////        // The fat framework must have the same base name as the initial frameworks.
////        baseName = "my_framework"
////        // The default destination directory is "<build directory>/fat-framework".
////        destinationDir = file("$buildDir/fat-framework/debug")
////        // Specify the frameworks to be merged.
////        from(
////            targets.ios32.binaries.getFramework("DEBUG"),
////            targets.ios64.binaries.getFramework("DEBUG")
////        )
////    }
//
////    val xcf = XCFramework()
////    macosArm64 {
////        binaries.framework {
////            baseName = "native"
////            xcf.add(this)
////        }
////    }
////    macosX64 {
////        binaries.framework {
////            baseName = "native"
////            xcf.add(this)
////        }
////    }
////    iosSimulatorArm64 {
////        binaries.framework {
////            baseName = "native"
////            xcf.add(this)
////        }
////    }
////    iosArm32 {
////        binaries.framework {
////            baseName = "native"
////            xcf.add(this)
////        }
////    }
////    iosArm64 {
////        binaries.framework {
////            baseName = "native"
////            xcf.add(this)
////        }
////    }
//
//    val ios32 = iosArm32("ios32")
//    val ios64 = iosArm64("ios64")
//    configure(listOf(ios32, ios64)) {
//        binaries.framework {
//            baseName = "Demo"
//            embedBitcode(org.jetbrains.kotlin.gradle.plugin.mpp.BitcodeEmbeddingMode.BITCODE)
//        }
//    }
//    // Create a task to build a fat framework.
//    tasks.register<org.jetbrains.kotlin.gradle.tasks.FatFrameworkTask>("debugFatFramework") {
//        // The fat framework must have the same base name as the initial frameworks.
//        baseName = "Demo"
//        // The default destination directory is "<build directory>/fat-framework".
//        destinationDir = buildDir.resolve("fat-framework/debug")
//        // Specify the frameworks to be merged.
//        from(
//            ios32.binaries.getFramework("DEBUG"),
//            ios64.binaries.getFramework("DEBUG"),
////            iosSimulator.binaries.getFramework("DEBUG")
//        )
//    }
//    // Create a task to build a fat framework.
//    tasks.register<org.jetbrains.kotlin.gradle.tasks.FatFrameworkTask>("releaseFatFramework") {
//        // The fat framework must have the same base name as the initial frameworks.
//        baseName = "Demo"
//        // The default destination directory is "<build directory>/fat-framework".
//        destinationDir = buildDir.resolve("fat-framework/release")
//        // Specify the frameworks to be merged.
//        from(
//            ios32.binaries.getFramework("RELEASE"),
//            ios64.binaries.getFramework("RELEASE"),
////            iosSimulator.binaries.getFramework("DEBUG")
//        )
//    }
//
////    sourceSets {
////        val commonMain by getting
////        val commonTest by getting {
////            dependencies {
////                implementation(kotlin("test"))
////            }
////        }
////        val jvmMain by getting
////        val jvmTest by getting
//////        val jsMain by getting
//////        val jsTest by getting
////        val nativeMain by getting
//////        val nativeTest by getting
////    }
//}
//

import org.jetbrains.kotlin.gradle.tasks.*

val ideaActive = System.getProperty("idea.active") == "true"

//val kotlin_version: String by extra
//val ktor_version: String by extra
//val coroutines_version: String by extra
//val serialization_version: String by extra
//val android_mapbox: String by project
//
//plugins {
//    //id("com.android.library")
//    kotlin("multiplatform") version "1.6.21"
//}

//android {
//    compileSdkVersion(31)
//    buildToolsVersion = "29.0.2"
//    defaultConfig {
//        minSdkVersion(16)
//        targetSdkVersion(31)
//    }
//}

//kotlin {
//    jvm()
////    android()
//
//    val iosArm32 = iosArm32("iosArm32")
//    val iosArm64 = iosArm64("iosArm64")
//    val iosX64 = iosX64("iosX64")
//
//    if (ideaActive) {
//        iosX64("ios")
//    }
//
//    sourceSets {
//        val commonMain by getting {
//            dependencies {
//                implementation("org.jetbrains.kotlin:kotlin-stdlib")
////                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common")
//            }
//        }
//
//        val jvmMain by getting {
//            dependencies {
//                api("org.jetbrains.kotlin:kotlin-stdlib")
//            }
//        }
//
////        val androidMain by getting {
////            dependsOn(mobileMain)
////            dependsOn(jvmMain)
////
////            dependencies {
////                api("com.android.support:support-compat:28.0.0")
////                api("com.mapbox.mapboxsdk:mapbox-android-sdk:$android_mapbox")
////            }
////        }
//
//        val iosMain = if (ideaActive) {
//            getByName("iosMain")
//        } else {
//            create("iosMain")
//        }
//
//        iosMain.apply {
////            dependsOn(mobileMain)
//
////            dependencies {
////                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native")
////                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-native")
//
////                implementation("io.ktor:ktor-client-ios:$ktor_version")
////                implementation("io.ktor:ktor-client-serialization-native:$ktor_version")
////            }
//        }
//
//        val iosArm32Main by getting
//        val iosArm64Main by getting
//        val iosX64Main by getting
//
//        configure(listOf(iosArm32Main, iosArm64Main, iosX64Main)) {
//            dependsOn(iosMain)
//        }
//    }
//
//    val frameworkName = "KotlinConfAPI"
//
//    configure(listOf(iosArm32, iosArm64, iosX64)) {
//        compilations {
//            val main by getting {
////                extraOpts("-Xobjc-generics")
//            }
//        }
//
//        binaries.framework {
////            export("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:$coroutines_version")
//            baseName = frameworkName
//        }
//    }
//
//    tasks.register<FatFrameworkTask>("debugFatFramework") {
//        baseName = frameworkName
//        group = "Universal framework"
//        description = "Builds a universal (fat) debug framework"
//
//        from(iosSimulatorArm64().binaries.getFramework("DEBUG"))
//    }
//
//    tasks.register<FatFrameworkTask>("releaseFatFramework") {
//        baseName = frameworkName
//        group = "Universal framework"
//        description = "Builds a universal (release) debug framework"
//
//        from(iosArm64.binaries.getFramework("RELEASE"), iosArm32.binaries.getFramework("RELEASE"))
//    }
//}

plugins {
    kotlin("multiplatform") version "1.6.21"
//    id("com.android.library")
}

kotlin {
//    android()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
//        val androidMain by getting
//        val androidTest by getting {
//            dependencies {
//                implementation(kotlin("test-junit"))
//                implementation("junit:junit:4.13.2")
//            }
//        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val nativeMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val nativeTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

//android {
//    compileSdk = 31
//    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
//    defaultConfig {
//        minSdk = 21
//        targetSdk = 31
//    }
//}