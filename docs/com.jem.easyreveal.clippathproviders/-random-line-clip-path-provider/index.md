[easyreveal](../../index.md) / [com.jem.easyreveal.clippathproviders](../index.md) / [RandomLineClipPathProvider](./index.md)

# RandomLineClipPathProvider

`class RandomLineClipPathProvider : `[`ClipPathProvider`](../../com.jem.easyreveal/-clip-path-provider/index.md)

[ClipPathProvider](../../com.jem.easyreveal/-clip-path-provider/index.md) which provides path which consists of **random** strips of rectangles (AKA, `lines`).

### Types

| Name | Summary |
|---|---|
| [LineOrientation](-line-orientation/index.md) | `enum class LineOrientation`<br>Orientation of the rectangular strips. |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RandomLineClipPathProvider(lineOrientation: `[`RandomLineClipPathProvider.LineOrientation`](-line-orientation/index.md)` = LineOrientation.HORIZONTAL)``RandomLineClipPathProvider()`<br>[ClipPathProvider](../../com.jem.easyreveal/-clip-path-provider/index.md) which provides path which consists of **random** strips of rectangles (AKA, `lines`). |

### Properties

| Name | Summary |
|---|---|
| [lineOrientation](line-orientation.md) | `var lineOrientation: `[`RandomLineClipPathProvider.LineOrientation`](-line-orientation/index.md)<br>Orientation of the reveal animation lines. |
| [randomLineArrayList](random-line-array-list.md) | `var randomLineArrayList: `[`ArrayList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-array-list/index.html)`<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>`<br>[ArrayList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-array-list/index.html) of random integers in the range 1..100 |

### Inherited Properties

| Name | Summary |
|---|---|
| [op](../../com.jem.easyreveal/-clip-path-provider/op.md) | `var op: Op`<br>Region.Op variable that is used in [android.graphics.Canvas.clipPath](#) in the EasyRevealLayouts |
| [path](../../com.jem.easyreveal/-clip-path-provider/path.md) | `var path: Path`<br>Path variable that should be used to make the path to be returned in [getPath](../../com.jem.easyreveal/-clip-path-provider/get-path.md) function. |

### Functions

| Name | Summary |
|---|---|
| [getPath](get-path.md) | `fun getPath(percent: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, view: View): Path`<br>Generate the [Path](#) for the **percent** value to be applied in the **view**. |
