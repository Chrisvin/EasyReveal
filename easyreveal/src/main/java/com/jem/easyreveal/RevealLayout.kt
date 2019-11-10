package com.jem.easyreveal

interface RevealLayout {
    // Used to perform reveal animation
    public fun reveal(): Unit
    // Used to perform hide animation
    public fun hide(): Unit

    // Reveal view to specified reveal percentage
    public fun revealForPercentage(percent: Float): Unit
}