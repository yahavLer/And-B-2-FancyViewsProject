# ✨ FancyViews – Beautiful Custom UI Components for Android

**FancyViews** is a lightweight and flexible Android UI library that provides interactive and animated custom views to enhance the user experience in your app.

Designed for simplicity, customization, and visual appeal – perfect for modern Android apps!

---

## 🚀 Components Included

### 🔘 LoadingButton – Smart Loading Button

A custom button that supports multiple states:

- `IDLE` – default clickable state
- `LOADING` – shows spinner and disables interaction
- `SUCCESS` – changes to success icon and message
- `ERROR` – shows error message and icon
- `DISABLED` – visually disabled and inactive

**Features:**
- Set custom text and icon for each state
- Customize background and text colors per state
- Smooth animations: fade + bounce
- Listener support: `OnStateChangeListener`

---

### ⏳ FancyProgressBar – Animated Colorful Progress Indicator

A spinning indeterminate progress bar with animated color cycling.

**Features:**
- Automatically transitions between custom color sequence
- Configurable speed (interval in milliseconds)
- Start / stop / restart at runtime
- Fully compatible with ConstraintLayout and XML

---

## 🔧 Installation

Add the library module to your project and reference it in `settings.gradle`:

```groovy
include ':fancyviews'
