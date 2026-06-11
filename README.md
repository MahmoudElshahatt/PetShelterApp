# Pet Shelter App

A cross-platform mobile app (Android & iOS) built with **Kotlin Multiplatform** and **Compose Multiplatform**, helping users browse and adopt pets from shelters.

## Features

- **Splash Screen** — app entry point with branding
- **Home Screen** — browse pets by category with filterable cards
- **Details Screen** — full pet profile with image carousel, tags (type, gender, age), description, and an adoption sign-up button
- Favorite toggle on pet cards

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Kotlin Multiplatform (KMM) |
| UI | Compose Multiplatform (shared Android + iOS) |
| Design | Material Design 3 |
| Build | Gradle with version catalogs |
| Min Android | API 21 |
| iOS targets | arm64 + simulator (arm64/x64) |

## Project Structure

```
PetShelterApp/
├── androidApp/          # Android entry point (MainActivity)
├── iosApp/              # iOS entry point (SwiftUI wrapper)
└── shared/
    └── src/
        ├── commonMain/  # Shared Kotlin/Compose UI & logic
        ├── androidMain/ # Android-specific implementations
        └── iosMain/     # iOS-specific implementations
```

## Getting Started

### Prerequisites

- Android Studio Hedgehog or later (with KMM plugin)
- Xcode 15+ (for iOS builds)
- JDK 17+

### Run on Android

```bash
./gradlew :androidApp:assembleDebug
```

Or use the run configuration in Android Studio.

### Run on iOS

Open `iosApp/iosApp.xcodeproj` in Xcode and run the scheme.

### Run Tests

```bash
# Android unit tests
./gradlew :shared:testAndroidHostTest

# iOS simulator tests
./gradlew :shared:iosSimulatorArm64Test
```

