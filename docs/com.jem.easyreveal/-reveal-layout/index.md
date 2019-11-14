[easyreveal](../../index.md) / [com.jem.easyreveal](../index.md) / [RevealLayout](./index.md)

# RevealLayout

`interface RevealLayout`

RevealLayout is the base interface for all the other EasyRevealLayouts

### Types

| Name | Summary |
|---|---|
| [OnUpdateListener](-on-update-listener/index.md) | `interface OnUpdateListener`<br>Interface definition for a callback to be invoked when current reveal percentage value is changed. |

### Properties

| Name | Summary |
|---|---|
| [clipPathProvider](clip-path-provider.md) | `abstract var clipPathProvider: `[`ClipPathProvider`](../-clip-path-provider/index.md)<br>ClipPathProvider provides the path used for clipping. |
| [currentRevealPercent](current-reveal-percent.md) | `abstract var currentRevealPercent: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>Percentage of the view currently revealed. |
| [hideAnimationDuration](hide-animation-duration.md) | `abstract var hideAnimationDuration: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Total duration of the hide animation. |
| [onUpdateListener](on-update-listener.md) | `abstract var onUpdateListener: `[`RevealLayout.OnUpdateListener`](-on-update-listener/index.md)`?`<br>Listener to get percent value updates when animating. |
| [revealAnimationDuration](reveal-animation-duration.md) | `abstract var revealAnimationDuration: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Total duration of the reveal animation. |

### Functions

| Name | Summary |
|---|---|
| [hide](hide.md) | `abstract fun hide(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Used to perform hide animation. |
| [reveal](reveal.md) | `abstract fun reveal(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Used to perform reveal animation. |
| [revealForPercentage](reveal-for-percentage.md) | `abstract fun revealForPercentage(percent: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, shouldAnimate: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Reveal view to specified reveal percentage. |

### Inheritors

| Name | Summary |
|---|---|
| [EasyRevealConstraintLayout](../../com.jem.easyreveal.layouts/-easy-reveal-constraint-layout/index.md) | `class EasyRevealConstraintLayout : ConstraintLayout, `[`RevealLayout`](./index.md)<br>`EasyRevealinearLayout` is a custom [ConstraintLayout](#) that implements [RevealLayout](./index.md). |
| [EasyRevealFrameLayout](../../com.jem.easyreveal.layouts/-easy-reveal-frame-layout/index.md) | `class EasyRevealFrameLayout : FrameLayout, `[`RevealLayout`](./index.md)<br>`EasyRevealinearLayout` is a custom [FrameLayout](#) that implements [RevealLayout](./index.md). |
| [EasyRevealLinearLayout](../../com.jem.easyreveal.layouts/-easy-reveal-linear-layout/index.md) | `class EasyRevealLinearLayout : LinearLayout, `[`RevealLayout`](./index.md)<br>`EasyRevealinearLayout` is a custom [LinearLayout](#) that implements [RevealLayout](./index.md). |
