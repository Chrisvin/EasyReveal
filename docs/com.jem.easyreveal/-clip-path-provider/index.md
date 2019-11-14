[easyreveal](../../index.md) / [com.jem.easyreveal](../index.md) / [ClipPathProvider](./index.md)

# ClipPathProvider

`abstract class ClipPathProvider`

Abstract class that should be extended by other ClipPathProvider classes.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ClipPathProvider()`<br>Abstract class that should be extended by other ClipPathProvider classes. |

### Properties

| Name | Summary |
|---|---|
| [op](op.md) | `var op: Op`<br>Region.Op variable that is used in [android.graphics.Canvas.clipPath](#) in the EasyRevealLayouts |
| [path](path.md) | `var path: Path`<br>Path variable that should be used to make the path to be returned in [getPath](get-path.md) function. |

### Functions

| Name | Summary |
|---|---|
| [getPath](get-path.md) | `abstract fun getPath(percent: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, view: View): Path`<br>Generate the [Path](#) for the **percent** value to be applied in the **view**. |

### Inheritors

| Name | Summary |
|---|---|
| [CircularClipPathProvider](../../com.jem.easyreveal.clippathproviders/-circular-clip-path-provider/index.md) | `class CircularClipPathProvider : `[`ClipPathProvider`](./index.md)<br>[ClipPathProvider](./index.md) which provides Circular path. |
| [LinearClipPathProvider](../../com.jem.easyreveal.clippathproviders/-linear-clip-path-provider/index.md) | `class LinearClipPathProvider : `[`ClipPathProvider`](./index.md)<br>[ClipPathProvider](./index.md) which provides a Rectangular path used to clip the view in a singular direction. |
| [RandomLineClipPathProvider](../../com.jem.easyreveal.clippathproviders/-random-line-clip-path-provider/index.md) | `class RandomLineClipPathProvider : `[`ClipPathProvider`](./index.md)<br>[ClipPathProvider](./index.md) which provides path which consists of **random** strips of rectangles (AKA, `lines`). |
| [StarClipPathProvider](../../com.jem.easyreveal.clippathproviders/-star-clip-path-provider/index.md) | `class StarClipPathProvider : `[`ClipPathProvider`](./index.md)<br>[ClipPathProvider](./index.md) which provides a Star shaped path. |
| [SweepClipPathProvider](../../com.jem.easyreveal.clippathproviders/-sweep-clip-path-provider/index.md) | `class SweepClipPathProvider : `[`ClipPathProvider`](./index.md)<br>[ClipPathProvider](./index.md) which provides a Sweep type path, which is basically a circular segment. |
| [WaveClipPathProvider](../../com.jem.easyreveal.clippathproviders/-wave-clip-path-provider/index.md) | `class WaveClipPathProvider : `[`ClipPathProvider`](./index.md)<br>[ClipPathProvider](./index.md) which provides Wave shaped paths which are flatter when **percent** is closer to 0 or 100, and are at max height when closer to 50. |
