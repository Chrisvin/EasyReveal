[easyreveal](../../index.md) / [com.jem.easyreveal.layouts](../index.md) / [EasyRevealConstraintLayout](./index.md)

# EasyRevealConstraintLayout

`class EasyRevealConstraintLayout : ConstraintLayout, `[`RevealLayout`](../../com.jem.easyreveal/-reveal-layout/index.md)

`EasyRevealinearLayout` is a custom [ConstraintLayout](#) that implements [RevealLayout](../../com.jem.easyreveal/-reveal-layout/index.md).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `EasyRevealConstraintLayout(context: Context?)`<br>`EasyRevealConstraintLayout(context: Context?, attrs: AttributeSet?)`<br>`EasyRevealConstraintLayout(context: Context?, attrs: AttributeSet?, defStyleAttr: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [clipPathProvider](clip-path-provider.md) | `var clipPathProvider: `[`ClipPathProvider`](../../com.jem.easyreveal/-clip-path-provider/index.md)<br>ClipPathProvider provides the path used for clipping. |
| [currentRevealPercent](current-reveal-percent.md) | `var currentRevealPercent: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>Percentage of the view currently revealed. |
| [hideAnimationDuration](hide-animation-duration.md) | `var hideAnimationDuration: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Total duration of the hide animation. |
| [onUpdateListener](on-update-listener.md) | `var onUpdateListener: `[`RevealLayout.OnUpdateListener`](../../com.jem.easyreveal/-reveal-layout/-on-update-listener/index.md)`?`<br>Listener to get percent value updates when animating. |
| [revealAnimationDuration](reveal-animation-duration.md) | `var revealAnimationDuration: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Total duration of the reveal animation. |

### Functions

| Name | Summary |
|---|---|
| [draw](draw.md) | `fun draw(canvas: Canvas?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Overriden from View |
| [hide](hide.md) | `fun hide(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Used to perform hide animation. |
| [reveal](reveal.md) | `fun reveal(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Used to perform reveal animation. |
| [revealForPercentage](reveal-for-percentage.md) | `fun revealForPercentage(percent: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, shouldAnimate: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Reveal view to specified reveal percentage. |
