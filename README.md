#  Farmer Registration App (Offline-First, Kotlin CLI)

This is a simple **offline-first Kotlin command-line app** built to help field officers at the Ministry of Agriculture **register farmers** in remote areas with no internet.

---

##  What I Built

A small command-line Kotlin app that allows a field officer to:
- Register a farmer's name, ID number, and crop type.
- Save the data **locally** in a text file (`farmers.txt`).
- View a list of all registered farmers.
- Work completely **offline**, no internet required.

---

## 🏗 Architecture Summary

The app follows a simple architecture with the following components:

| Component | Description |
|----------|-------------|
| `Main.kt` | Entry point of the app (user interface logic). |
| `Farmer.kt` | Data class for storing farmer details. |
| `FarmerRepository.kt` | Handles saving and loading data from local storage (`farmers.txt`). |
| `functions.kt` | Contains `registerFarmer()` and `listFarmers()` logic. |

---

##  Why Offline-First?

Most rural areas in the country have:
- Limited or **no internet access**
- Poor mobile network coverage

This app is **fully functional offline**, which makes it ideal for field officers visiting remote farms.

---

##  Future Sync Strategy (if internet becomes available)

In future, we can:
- Add a **sync button** to push saved farmers to a central server API.
- Use a background worker to **upload offline records** once internet is detected.
- Integrate a **remote database** with conflict resolution.

---

