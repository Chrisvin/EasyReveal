[easyreveal](../../index.md) / [com.jem.easyreveal.clippathproviders](../index.md) / [LinearClipPathProvider](./index.md)

# LinearClipPathProvider

`class LinearClipPathProvider : `[`ClipPathProvider`](../../com.jem.easyreveal/-clip-path-provider/index.md)

[ClipPathProvider](../../com.jem.easyreveal/-clip-path-provider/index.md) which provides a Rectangular path used to clip the view in a singular direction.

### Types

| Name | Summary |
|---|---|
| [Direction](-direction/index.md) | `enum class Direction`<br>Direction of the reveal animation. |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `LinearClipPathProvider(direction: `[`LinearClipPathProvider.Direction`](-direction/index.md)`)``LinearClipPathProvider()`<br>[ClipPathProvider](../../com.jem.easyreveal/-clip-path-provider/index.md) which provides a Rectangular path used to clip the view in a singular direction. |

### Properties

| Name | Summary |
|---|---|
| [direction](direction.md) | `var direction: `[`LinearClipPathProvider.Direction`](-direction/index.md)<br>Direction of the linear reveal. |

### Inherited Properties

| Name | Summary |
|---|---|
| [op](../../com.jem.easyreveal/-clip-path-provider/op.md) | `var op: Op`<br>Region.Op variable that is used in [android.graphics.Canvas.clipPath](#) in the EasyRevealLayouts |
| [path](../../com.jem.easyreveal/-clip-path-provider/path.md) | `var path: Path`<br>Path variable that should be used to make the path to be returned in [getPath](../../com.jem.easyreveal/-clip-path-provider/get-path.md) function. |

### Functions

| Name | Summary |
|---|---|
| [getPath](get-path.md) | `fun getPath(percent: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, view: View): Path`<br>Generate the [Path](#) for the **percent** value to be applied in the **view**. |
