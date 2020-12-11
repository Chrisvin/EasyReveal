package com.jem.easyreveal

/**
 * RevealLayout is the base interface for all the other EasyRevealLayouts
 */
interface RevealLayout {
    /** ClipPathProvider provides the path used for clipping. */
    var clipPathProvider: ClipPathProvider
    /** Total duration of the reveal animation. */
    var revealAnimationDuration: Long
    /** Total duration of the hide animation. */
    var hideAnimationDuration: Long
    /** Percentage of the view currently revealed. */
    var currentRevealPercent: Float
    /** Listener to get percent value updates when animating. */
    var onUpdateListener: OnUpdateListener?

    /**
     * Used to perform reveal animation.
     */
    fun reveal()

    /**
     * Used to perform hide animation.
     */
    fun hide()

    /**
     * Reveal view to specified reveal percentage.
     * @param percent value should be between 0 and 100 (inclusive).
     * @param shouldAnimate if true, then reveal/hide animation will be performed (based on percent value).
     */
    fun revealForPercentage(percent: Float, shouldAnimate: Boolean)

    /**
     * Interface definition for a callback to be invoked when current reveal percentage value is changed.
     */
    interface OnUpdateListener {
        /**
         * Called when current reveal percentage value is changed.
         * @param percent Percentage of the view that is revealed, in the range 1-100
         */
        fun onUpdate(percent: Float)
    }
}