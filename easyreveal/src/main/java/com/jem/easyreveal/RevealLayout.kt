package com.jem.easyreveal

internal interface RevealLayout {
    // Used to perform reveal animation
    public fun reveal(onUpdate: ((percent: Float) -> Unit)? = null): Unit

    // Used to perform hide animation
    public fun hide(onUpdate: ((percent: Float) -> Unit)? = null): Unit

    // Reveal view to specified reveal percentage
    public fun revealForPercentage(percent: Float): Unit
}