[easyreveal](../../index.md) / [com.jem.easyreveal.clippathproviders](../index.md) / [StarClipPathProvider](./index.md)

# StarClipPathProvider

`class StarClipPathProvider : `[`ClipPathProvider`](../../com.jem.easyreveal/-clip-path-provider/index.md)

[ClipPathProvider](../../com.jem.easyreveal/-clip-path-provider/index.md) which provides a Star shaped path.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `StarClipPathProvider(numberOfPoints: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)``StarClipPathProvider()`<br>[ClipPathProvider](../../com.jem.easyreveal/-clip-path-provider/index.md) which provides a Star shaped path. |

### Inherited Properties

| Name | Summary |
|---|---|
| [op](../../com.jem.easyreveal/-clip-path-provider/op.md) | `var op: Op`<br>Region.Op variable that is used in [android.graphics.Canvas.clipPath](#) in the EasyRevealLayouts |
| [path](../../com.jem.easyreveal/-clip-path-provider/path.md) | `var path: Path`<br>Path variable that should be used to make the path to be returned in [getPath](../../com.jem.easyreveal/-clip-path-provider/get-path.md) function. |

### Functions

| Name | Summary |
|---|---|
| [getPath](get-path.md) | `fun getPath(percent: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, view: View): Path`<br>Generate the [Path](#) for the **percent** value to be applied in the **view**. |
| [setNumberOfPoints](set-number-of-points.md) | `fun setNumberOfPoints(numberOfPoints: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Set the number of points in the star. |
