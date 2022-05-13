# kotlin-native-framework-precursor

Here is a first approach of writing Kotlin Multiplatform project, with only Kotlin on iOS (except only for a small AppDelegate routine which also could have been written in Kotlin, this routine just calls the code written in Kotlin/Native to make the views).

## Running conditions

Run on a macOS machine of course, with Java 11 installed. Not Java 8. Or: Add the following line to the `gradle.properties`

```ini
org.gradle.java.home=
```

And put your Android Studio JDK path

## What is done??

Just a simple (framework) for writing applications that has stack views (`LinearLayout`s), and text fields (`EditText`), but this can be a precursor for a full framework that can be used without SwiftUI nor Android Jetpack Compose nor anything purely functional.

## Why?

Because not everything can be solved using SwiftUI, Android Jetpack Compose, Flutter and React Native, still imperative code is needed, this framework if done, would help when one really needs imperative UI to be used in a cross-platform environment.

## LICENSE

MIT LICENSE
