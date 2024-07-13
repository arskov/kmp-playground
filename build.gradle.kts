import org.gradle.api.tasks.testing.logging.*

buildscript {
  repositories {
      mavenLocal()
      google()
      mavenCentral()
  }
}

plugins {
    kotlin("multiplatform") version "1.9.23"
}

allprojects {

  repositories {
      mavenLocal()
      google()
      mavenCentral()
  }

  tasks.withType<AbstractTestTask>().configureEach {
    testLogging.lifecycle {
      events =
          setOf(
              TestLogEvent.FAILED,
              TestLogEvent.PASSED,
              TestLogEvent.SKIPPED,
              TestLogEvent.STANDARD_OUT)
      exceptionFormat = TestExceptionFormat.FULL
      showStandardStreams = true
      showCauses = true
      showExceptions = true
      showStackTraces = true
    }
  }
}

tasks.wrapper {
    gradleVersion = "8.5"
}

val libraryName = "exports"

kotlin {
    mingwX64 {
        binaries {
            sharedLib {
                baseName = libraryName
            }
        }
    }
    
    sourceSets {
        all {
            languageSettings.apply {
                optIn("kotlin.RequiresOptIn")
                optIn("kotlin.js.ExperimentalJsExport")
            }
        }

        val commonMain by getting {
            dependencies {
                api(kotlin("stdlib"))
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val mingwX64Main by getting {
            dependencies {
                api(kotlin("stdlib"))
            }
        }
    }

}