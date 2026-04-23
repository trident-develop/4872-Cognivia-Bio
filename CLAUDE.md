# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project

Android app "Cognivia Bio" — single-module Jetpack Compose application.

- **Package / applicationId:** `show.g` (note: differs from the display name)
- **Android:** `minSdk = 24`, `targetSdk = 36`, `compileSdk = 36.1`
- **Java / Kotlin:** JVM target 11, Kotlin `2.2.10` with the Compose compiler plugin (`org.jetbrains.kotlin.plugin.compose`)
- **AGP:** `9.1.1`, **Compose BOM:** `2026.02.01`

Dependencies are declared via the version catalog at `gradle/libs.versions.toml` — add new libraries there and reference them as `libs.xxx` in `app/build.gradle.kts`, rather than hard-coding versions in the module build file.

## Common commands

Run from the repo root. `./gradlew` expects a Java toolchain resolved via the foojay plugin (see `settings.gradle.kts`) and a daemon JVM configured in `gradle/gradle-daemon-jvm.properties`.

```sh
./gradlew assembleDebug              # build debug APK
./gradlew installDebug               # install on connected device/emulator
./gradlew lint                       # Android Lint
./gradlew test                       # JVM unit tests (app/src/test)
./gradlew connectedDebugAndroidTest  # instrumented tests (app/src/androidTest) — needs a device
./gradlew :app:testDebugUnitTest --tests "show.g.ExampleUnitTest.addition_isCorrect"  # single unit test
```

## Architecture notes

The app is currently the Android Studio Compose template — a single `MainActivity` (`app/src/main/java/com/takeonecompany/bp/MainActivity.kt`) that calls `enableEdgeToEdge()` and hosts Compose content inside `CogniviaBioTheme` (defined in `ui/theme/`). There is no navigation graph, DI, networking, or persistence layer yet; when adding these, establish the module/package conventions deliberately rather than assuming one already exists.
