package com.jem.easyreveal

interface RevealLayout {
    // ClipPathProvider provides the path used for clipping
    var clipPathProvider: ClipPathProvider
    // Reveal animation duration
    var revealAnimationDuration: Long
    // Hide animation duration
    var hideAnimationDuration: Long

    // Used to perform reveal animation
    fun reveal(onUpdate: ((percent: Float) -> Unit)? = null): Unit
    // Used to perform hide animation
    fun hide(onUpdate: ((percent: Float) -> Unit)? = null): Unit
    // Reveal view to specified reveal percentage
    fun revealForPercentage(percent: Float): Unit

    interface OnUpdateListener {
        fun onUpdate(percent: Float)
    }
}