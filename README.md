# KAnimationEngine

[![](https://jitpack.io/v/Quantamyt/KAnimationEngine.svg)](https://jitpack.io/#Quantamyt/KAnimationEngine)

*powered by JitPack!*

A simple Kotlin animation library that provides utilities for managing animations with customizable easing functions.

**Go to the [Java Version.](https://github.com/Quantamyt/AnimationEngine)**

## Installation

You can include this library in your project using JitPack.

### Step 1: Add the JitPack repository to your build file

Add the following repository to your `pom.xml` if you are using Maven, or to your `build.gradle` if you are using Gradle:

#### Maven

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

#### Gradle

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
```

### Step 2: Add the dependency

Add the dependency to your `pom.xml` or `build.gradle`:

#### Maven

```xml
<dependency>
    <groupId>com.github.Quantamyt</groupId>
    <artifactId>KAnimationEngine</artifactId>
    <version>master-SNAPSHOT</version>
</dependency>
```

You can replace `master-SNAPSHOT` with the version tag you want to use (e.g., `fff5884c33`).

#### Gradle

```groovy
dependencies {
    implementation 'com.github.Quantamyt:KAnimationEngine:master-SNAPSHOT'
}
```

You can replace `master-SNAPSHOT` with the version tag you want to use (e.g., `fff5884c33`).

## Usage

### AnimationEngine

```kotlin
import dev.quantam.kanimation.AnimationEngine
import dev.quantam.kanimation.easings.EaseFunctions
import java.util.function.Consumer
import java.util.function.Function

// Create an animation engine with a callback and easing function
val engine = AnimationEngine(2.0f, Consumer { progress ->
    // Update UI or perform action based on animation progress
    println("Animation progress: $progress")
}, Function { EaseFunctions.easeInOutQuad(it) })

// Start the animation
engine.start()

// Update the animation engine in your game loop or update method
val deltaTime = 0.016f // Example time between updates in seconds
engine.update(deltaTime)

// Check if animation is still running
if (engine.isRunning) {
    // Animation is still in progress
} else {
    // Animation has completed
}
```

### AnimationManager

```kotlin
import dev.quantam.kanimation.AnimationEngine
import dev.quantam.kanimation.AnimationManager
import dev.quantam.kanimation.easings.EaseFunctions
import java.util.function.Consumer
import java.util.function.Function

// Create an AnimationManager
val manager = AnimationManager()

// Add animations to the manager
val animation1 = AnimationEngine(1.5f, Consumer { progress ->
    // Update UI or perform action based on animation progress
}, Function { EaseFunctions.easeInOutCubic(it) })
manager.addAnimation(animation1)

val animation2 = AnimationEngine(3.0f, Consumer { progress ->
    // Update UI or perform action based on animation progress
}, Function { EaseFunctions.easeInOutExpo(it) })
manager.addAnimation(animation2)

// Update all animations managed by the manager
val deltaTime = 0.016f // Example time between updates in seconds
manager.update(deltaTime)
```

### EaseFunctions

```kotlin
import dev.quantam.kanimation.easings.EaseFunctions

// Example usage of easing functions
val linearValue = EaseFunctions.linear(0.5f)
val easeInOutQuadValue = EaseFunctions.easeInOutQuad(0.3f)

println("Linear value: $linearValue")
println("EaseInOutQuad value: $easeInOutQuadValue")
```

**Feel Free to check out [AnimationApp](https://github.com/Quantamyt/KAnimationEngine/blob/main/src/main/kotlin/dev/quantam/kanimation/demo/AnimationApp.kt) for more detailed help.**

## Contributing

Contributions are welcome! If you have improvements or additional features to suggest, please create a pull request. (this is very dirty code :P )

## License

This project is licensed under [CC 4.0](https://creativecommons.org/licenses/by/4.0/?ref=chooser-v1) to [Quantam](https://github.com/Quantamyt/)

---

This README provides the necessary information for installing, using, and contributing to the Kotlin version of the Animation Engine library.