/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

object Deps {
    object Plugins {
        const val android =
            "com.android.tools.build:gradle:${Versions.Plugins.android}"
        const val kotlin =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Plugins.kotlin}"
        const val androidExtensions =
            "org.jetbrains.kotlin:kotlin-android-extensions:${Versions.Plugins.androidExtensions}"
        const val mokoResources =
            "dev.icerock.moko:resources-generator:${Versions.Plugins.mokoResources}"
    }

    object Libs {
        object Android {
            val kotlinStdLib = AndroidLibrary(
                name = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
            )
            val appCompat = AndroidLibrary(
                name = "androidx.appcompat:appcompat:${Versions.Libs.Android.appCompat}"
            )
            val lifecycle = AndroidLibrary(
                name = "androidx.lifecycle:lifecycle-extensions:${Versions.Libs.Android.lifecycle}"
            )
            val material = AndroidLibrary(
                name = "com.google.android.material:material:${Versions.Libs.Android.material}"
            )
        }

        object MultiPlatform {
            val kotlinStdLib = MultiPlatformLibrary(
                android = Android.kotlinStdLib.name,
                common = "org.jetbrains.kotlin:kotlin-stdlib-common:${Versions.kotlin}"
            )
            val mokoResources = MultiPlatformLibrary(
                common = "dev.icerock.moko:resources:${Versions.Libs.MultiPlatform.mokoResources}",
                iosX64 = "dev.icerock.moko:resources-iosx64:${Versions.Libs.MultiPlatform.mokoResources}",
                iosArm64 = "dev.icerock.moko:resources-iosarm64:${Versions.Libs.MultiPlatform.mokoResources}"
            )
            val mokoMvvm = MultiPlatformLibrary(
                common = "dev.icerock.moko:mvvm:${Versions.Libs.MultiPlatform.mokoMvvm}",
                iosX64 = "dev.icerock.moko:mvvm-iosx64:${Versions.Libs.MultiPlatform.mokoMvvm}",
                iosArm64 = "dev.icerock.moko:mvvm-iosarm64:${Versions.Libs.MultiPlatform.mokoMvvm}"
            )
            val mokoFields = MultiPlatformLibrary(
                common = "dev.icerock.moko:fields:${Versions.Libs.MultiPlatform.mokoFields}",
                iosX64 = "dev.icerock.moko:fields-iosx64:${Versions.Libs.MultiPlatform.mokoFields}",
                iosArm64 = "dev.icerock.moko:fields-iosarm64:${Versions.Libs.MultiPlatform.mokoFields}"
            )
        }

        object Jvm {
            const val kotlinPoet = "com.squareup:kotlinpoet:${Versions.Libs.Jvm.kotlinPoet}"
        }
    }

    val plugins: Map<String, String> = mapOf(
        "com.android.application" to Plugins.android,
        "com.android.library" to Plugins.android,
        "org.jetbrains.kotlin.multiplatform" to Plugins.kotlin,
        "kotlin-kapt" to Plugins.kotlin,
        "kotlin-android" to Plugins.kotlin,
        "kotlin-android-extensions" to Plugins.androidExtensions,
        "dev.icerock.mobile.multiplatform-resources" to Plugins.mokoResources
    )
}