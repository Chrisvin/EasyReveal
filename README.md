# EasyReveal
 Android EasyReveal Library

 [![License: MIT](https://img.shields.io/badge/License-MIT-silver.svg)](https://opensource.org/licenses/MIT) [![](https://jitpack.io/v/Chrisvin/EasyReveal.svg)](https://jitpack.io/#Chrisvin/EasyReveal) [![API](https://img.shields.io/badge/API-19%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=19)

<table>
<tr>
	<td><img src="./demo%20screenshots/star_reveal.gif"/></td>
	<td><img src="./demo%20screenshots/linear_reveal.gif"/></td>
	<td><img src="./demo%20screenshots/circular_reveal.gif"/></td>
</tr>
<tr>
	<td><img src="./demo%20screenshots/random_line_reveal.gif"/></td>
	<td><img src="./demo%20screenshots/wave_reveal.gif"/></td>
	<td><img src="./demo%20screenshots/sweep_reveal.gif"/></td>
</tr>
</table>

EasyReveal is an extensible reveal library that contains various reveal animations. ([Demo apk](https://github.com/Chrisvin/EasyReveal/releases/download/1.2/EasyRevealDemo.apk))

## Getting started
### Setting up the dependency
1. Add the JitPack repository to your root build.gradle at the end of repositories:
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
2. Add the EasyReveal dependency in the build.gradle:
```
implementation 'com.github.Chrisvin:EasyReveal:1.2'
```

### Demo app
To run the demo project, clone the repository and run it via Android Studio.
</br>(OR)
</br>Download the latest demo apk from [releases](https://github.com/Chrisvin/EasyReveal/releases).

## Usage
### Add RevealLayout in layout.xml
The views that need to be revealed/hidden should be put inside the EasyReveal layouts.

```
<com.jem.easyreveal.layouts.EasyRevealLinearLayout
    ...
    app:clipPathProvider="star" // possible values: circular, linear, random_line, star, sweep & wave
    app:revealAnimationDuration="2000"
    app:hideAnimationDuration="1500" >

    <!-- The views to be revealed/hidden go here -->

</com.jem.easyreveal.layouts.EasyRevealLinearLayout>
<!-- Similarly for com.jem.easyreveal.layouts.EasyRevealConstraintLayout & com.jem.easyreveal.layouts.EasyRevealFrameLayout -->
```
### Adding/Modifying programmatically
```kotlin
val revealLayout = EasyRevealLinearLayout(this)
// Set the ClipPathProvider that is used to clip the view for reveal animation
revealLayout.clipPathProvider = StarClipPathProvider(numberOfPoints = 6)
// Set the duration taken for reveal animation
revealLayout.revealAnimationDuration = 1500
// Set the duration taken for hide animation
revealLayout.hideAnimationDuration = 2000
// Set listener to get updates during reveal/hide animation
revealLayout.onUpdateListener = object: RevealLayout.OnUpdateListener {
    override fun onUpdate(percent: Float) {
        Toast.makeText(this@MainActivity, "Revealed percent: $percent", Toast.LENGTH_SHORT).show()
    }
}
// Start reveal animation
revealLayout.reveal()
// Start hide animation
revealLayout.hide()
```

Note : [Dokka generated documentation on ClipPathProviders](https://chrisvin.github.io/EasyReveal/com.jem.easyreveal.clippathproviders/)

## Creating custom reveals
One of the core focuses of this library was extensibility. Creating your own reveal animation is as simple as extending [ClipPathProvider](https://chrisvin.github.io/EasyReveal/com.jem.easyreveal/-clip-path-provider/) and implementing the `getPath()` method. `getPath()` provides the [Path](https://developer.android.com/reference/android/graphics/Path) for a given *percent* value on the provided *view*.  The path gotten from `getPath()` is then used to clip the view using `canvas.clipPath(path, op)` (The `op` value is provided by the `ClipPathProvider` as well).

For example, A simulataneous 4 corner circular reveal animation can be achieved as follows.

```kotlin
class CustomClipPathProvider : ClipPathProvider() {
    override fun getPath(percent: Float, view: View): Path {
        path.rewind()
        val radius = getDistance(0f,0f,view.width.toFloat() / 2, view.height.toFloat() / 2) * (percent/100)
        path.addCircle(0f, 0f, radius, Path.Direction.CW)
        path.addCircle(view.width.toFloat(), 0f, radius, Path.Direction.CW)
        path.addCircle(0f, view.height.toFloat(), radius, Path.Direction.CW)
        path.addCircle(view.width.toFloat(), view.height.toFloat(), radius, Path.Direction.CW)
        return path
    }

    private fun getDistance(startX: Float, startY: Float, endX: Float, endY: Float): Float {
        return sqrt(((startX - endX) * (startX - endX)) + ((startY - endY) * (startY - endY)))
    }
}
```

<img src="./demo%20screenshots/custom_reveal.gif"/>

## API Documentation

Documentation generated using Dokka : [chrisvin.github.io/EasyReveal](https://chrisvin.github.io/EasyReveal/)

## The End?
**No**, infact, EasyReveal was a library that I created since I needed (but was unable to find) an extensible library for view clipping.
Hence, the true form of EasyReveal is infact a view clipping library, who's most obvious usecase is designing customizable reveal animations.

The first version of [LiquidSwipe](https://github.com/Chrisvin/LiquidSwipe) used EasyReveal as a dependency. If you like this library, you will probably love [LiquidSwipe](https://github.com/Chrisvin/LiquidSwipe) and [ConcentricOnboarding](https://github.com/Chrisvin/ConcentricOnboarding).

## Bugs and Feedback
For bugs, questions and discussions please use the [Github Issues](https://github.com/Chrisvin/EasyReveal/issues).

## License
```
MIT License

Copyright (c) 2019 Jem

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
