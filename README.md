# 📦 FancyViews – Custom Android UI Library

FancyViews is an open-source Android library developed as part of the Advanced Android course.  
It provides custom UI components designed to solve everyday development challenges, with a focus on design, usability, and simplicity.

---

## 🎯 Purpose

The library aims to simplify the implementation of interactive UI elements by providing ready-made, customizable views.  
It is especially useful in apps that require status feedback (loading, success, error) and dynamic visual elements.

---

## 🔧 Components

### 🔘 LoadingButton

A button with built-in support for multiple states:
- `IDLE` – regular state
- `LOADING` – shows a spinner
- `SUCCESS` – shows check icon
- `ERROR` – shows error icon
- `DISABLED` – grayed out

Each state supports:
- Custom text
- Custom icon
- Custom colors

### ⏳ FancyProgressBar

A circular progress view that:
- Animates color transitions in `LOADING` state
- Shows different icons for `SUCCESS`, `ERROR`, `IDLE`, and `DISABLED` states
- Reacts dynamically to user actions

---

## 🛠 Usage

### XML

```xml
<com.example.fancyviews.LoadingButton
    android:id="@+id/loadingButton"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />

<com.example.fancyviews.FancyProgressBar
    android:id="@+id/fancyProgressBar"
    android:layout_width="64dp"
    android:layout_height="64dp" />
```
### java

```java
loadingButton.setState(LoadingButton.ButtonState.LOADING);
fancyProgressBar.setState(FancyProgressBar.ProgressState.LOADING);
```

### Demo App
The sample app included demonstrates:
How to control the button and progress bar dynamically
How each component changes based on user interaction

<img src="demo.gif" width="400" alt="Demo of FancyViews" />


### Project Structure

fancyviews/         → The library module
app/                → Demo application
README.md           → Documentation

### Requirements
Min SDK: 21

Java 8 or Kotlin 1.8+

Android Studio Electric Eel or newer

### License
MIT License – free for public and academic use.


