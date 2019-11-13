package com.jem.easyreveal

interface RevealLayout {
    // ClipPathProvider provides the path used for clipping
    var clipPathProvider: ClipPathProvider
    // Reveal animation duration
    var revealAnimationDuration: Long
    // Hide animation duration
    var hideAnimationDuration: Long
    // Percentage of the view currently revealed
    var currentRevealPercent: Float
    // Listener to get percent value updates when animating
    var onUpdateListener: RevealLayout.OnUpdateListener?

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