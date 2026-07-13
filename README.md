# ⚽ Sport Info

**Sport Info** is a [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html) football companion app built with [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/). It lets you browse competitions, follow today's fixtures, dive into match days and explore teams from Europe's top leagues — with full **light & dark mode** support.

Data is powered by the [football-data.org](https://www.football-data.org/) API.

---

## ✨ Features

- 🏆 **Competitions** — browse available football competitions
- 📅 **Today** — see all the matches scheduled for today at a glance
- 🗓️ **Match days** — swipe through a competition's fixtures matchday by matchday
- 🛡️ **Teams** — explore squads from the Premier League, La Liga, Ligue 1, Serie A, Bundesliga and Primeira Liga
- 🌗 **Light & dark theme** — a polished UI that adapts to the system theme

---

## 📱 Screenshots

### ☀️ Light mode

| Competitions | Match day | Today | Teams |
|:---:|:---:|:---:|:---:|
| ![Competitions – light](https://github.com/user-attachments/assets/9fa53708-89f8-4b32-932b-f21bfabafd23) | ![Match day – light](https://github.com/user-attachments/assets/8420a785-3418-4362-9b65-4dd64890460d) | ![Today – light](https://github.com/user-attachments/assets/d4e59805-0875-42e7-8ad8-dc20d842d7f2) | ![Teams – light](https://github.com/user-attachments/assets/7c9c801d-24b5-4a99-bae3-71953b81a812) |

### 🌙 Dark mode

| Competitions | Match day | Teams |
|:---:|:---:|:---:|
| ![Competitions – dark](https://github.com/user-attachments/assets/8334e2e5-3cfb-4bca-94de-e1d542af7d52) | ![Match day – dark](https://github.com/user-attachments/assets/6f2c400e-3622-44ae-8450-e23705f252a6) | ![Teams – dark](https://github.com/user-attachments/assets/cc05f7ab-8d73-444b-bc91-31bf41b6e721) |

---

## 🛠️ Tech stack

| Area | Library |
|---|---|
| UI | [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/) (Material 3) |
| Navigation | [Compose Navigation](https://developer.android.com/jetpack/compose/navigation) |
| Networking | [Ktor Client](https://ktor.io/) |
| Serialization | [kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization) |
| Dependency injection | [Koin](https://insert-koin.io/) |
| Image loading | [Coil 3](https://coil-kt.github.io/coil/) |
| Local storage | [DataStore](https://developer.android.com/topic/libraries/architecture/datastore) |
| Date/time | [kotlinx-datetime](https://github.com/Kotlin/kotlinx-datetime) |

The app follows a clean, layered architecture (`data` / `domain` / `ui`) with `ViewModel`-driven screens.

---

## 🚀 Getting started

### Prerequisites

- [Android Studio](https://developer.android.com/studio) (latest stable)
- JDK 11+
- A free API key from [football-data.org](https://www.football-data.org/client/register)

### Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/<your-username>/SportInfoKmp.git
   cd SportInfoKmp
   ```

2. **Add your API key**

   The app authenticates against football-data.org with an `X-Auth-Token` header
   (see `shared/src/commonMain/kotlin/com/example/sportinfokmp/data/remote/api/HttpClientFactory.kt`).
   Replace the placeholder value with your own key:

   ```kotlin
   const val API_KEY_VALUE = "<your-api-key>"
   ```

   > 💡 For a real deployment, prefer storing the key outside of source control
   > (e.g. `local.properties` / environment variable) rather than committing it.

3. **Run the app**

   Open the project in Android Studio and run the `androidApp` configuration on an
   emulator or device.

---

## 📂 Project structure

```
SportInfoKmp/
├── androidApp/          # Android application entry point
└── shared/              # Shared Kotlin Multiplatform module
    └── src/
        ├── commonMain/  # Shared code (UI, data, domain, DI, navigation)
        ├── androidMain/ # Android-specific implementations
        └── nativeMain/  # iOS-specific implementations
```

---

## 🎯 Platforms

- ✅ **Android**
- 🧩 **iOS** — targets are configured (`iosX64`, `iosArm64`, `iosSimulatorArm64`) and the shared module is iOS-ready

---

## 📄 License

This project is available under the terms described in the repository. Feel free to
open an issue or a pull request if you'd like to contribute.
