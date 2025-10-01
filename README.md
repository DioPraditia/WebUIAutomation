# WebUIAutomation
HOMEWORK MODULE 14 JAYJAY

# Web UI Automation Framework (Selenium + Cucumber + JUnit 4 + Gradle)

Framework otomatisasi pengujian Web UI menggunakan:
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **JUnit 4**
- **Gradle** sebagai build tool

---

## Fitur
- Mendukung **BDD** dengan Gherkin
- Struktur folder rapi: `features`, `step definitions`, dan `page objects`
- **Gradle Task** khusus untuk menjalankan Cucumber
- Mendukung **HTML dan JSON reports**

---

## Struktur Project

```text
webUIAutomation14/
│
├── build.gradle          # File konfigurasi Gradle
├── settings.gradle
├── README.md             # Dokumentasi project
├── .gitignore            # Ignore file & folder yang tidak perlu
│
├── src
│   └── test
│       ├── java
│   │       └── com/dio/page/        # Page Object
│   │           └── LoginPage.java
    |           └── HomePage.java
│   │       └── locatorTest.java        # Locator
│   │       └── Selenium           
│   │       └── seleniumMethod        # Selenium Method

│       │   └── com/dio/stepdef/    # Step Definition
│       │       └── LoginStepDef.java
        |       └── HomeStepDef.java
        |       └── CucumberHooks.java
│       │
│       │   └── com/dio/     # Cucumber Runner
│       │       └── CucumberTest.java
        |       └── BaseTest.java
│       │
        |  └── src/test/junitTest/    # JUnit 4
        |       └── LoginTest.java

│       |  └── resources
│           └── features/            # Gherkin
│               └── login.feature

