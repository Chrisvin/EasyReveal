[easyreveal](../../index.md) / [com.jem.easyreveal.clippathproviders](../index.md) / [WaveClipPathProvider](./index.md)

# WaveClipPathProvider

`class WaveClipPathProvider : `[`ClipPathProvider`](../../com.jem.easyreveal/-clip-path-provider/index.md)

[ClipPathProvider](../../com.jem.easyreveal/-clip-path-provider/index.md) which provides Wave shaped paths which are flatter when **percent** is closer to 0 or 100,
and are at max height when closer to 50.

### Types

| Name | Summary |
|---|---|
| [Direction](-direction/index.md) | `enum class Direction`<br>Direction in which reveal animation is performed. |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `WaveClipPathProvider(direction: `[`WaveClipPathProvider.Direction`](-direction/index.md)` = Direction.BOTTOM_TO_TOP, amplitude: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 30, frequency: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 45, speed: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 20)``WaveClipPathProvider()`<br>[ClipPathProvider](../../com.jem.easyreveal/-clip-path-provider/index.md) which provides Wave shaped paths which are flatter when **percent** is closer to 0 or 100, and are at max height when closer to 50. |

### Properties

| Name | Summary |
|---|---|
| [amplitude](amplitude.md) | `var amplitude: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Maximum height of waves. |
| [direction](direction.md) | `var direction: `[`WaveClipPathProvider.Direction`](-direction/index.md)<br>Wave reveal direction. |
| [frequency](frequency.md) | `var frequency: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Frequency of waves, higher frequency == more waves |
| [speed](speed.md) | `var speed: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Speed at which waves 'move'. |

### Inherited Properties

| Name | Summary |
|---|---|
| [op](../../com.jem.easyreveal/-clip-path-provider/op.md) | `var op: Op`<br>Region.Op variable that is used in [android.graphics.Canvas.clipPath](#) in the EasyRevealLayouts |
| [path](../../com.jem.easyreveal/-clip-path-provider/path.md) | `var path: Path`<br>Path variable that should be used to make the path to be returned in [getPath](../../com.jem.easyreveal/-clip-path-provider/get-path.md) function. |

### Functions

| Name | Summary |
|---|---|
| [getPath](get-path.md) | `fun getPath(percent: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, view: View): Path`<br>Generate the [Path](#) for the **percent** value to be applied in the **view**. |
