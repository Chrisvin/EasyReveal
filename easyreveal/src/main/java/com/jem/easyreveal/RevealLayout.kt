package com.jem.easyreveal

import android.animation.ValueAnimator

internal interface RevealLayout {
    // Used to perform reveal animation
    public fun reveal(onUpdate: ((it: ValueAnimator) -> Unit)? = null): Unit

    // Used to perform hide animation
    public fun hide(onUpdate: ((it: ValueAnimator) -> Unit)? = null): Unit

    // Reveal view to specified reveal percentage
    public fun revealForPercentage(percent: Float): Unit
}