package com.jem.easyreveal

import android.animation.ValueAnimator
import kotlin.math.abs

internal class RevealAnimatorManager {
    /** Animator used for animating the reveal/hide animations. */
    private val revealAnimator = ValueAnimator()

    /**
     * Performs reveal/hide animation.
     */
    fun animate(startPercent: Float, endPercent: Float, duration: Long, onUpdate: ((it: ValueAnimator) -> Unit)? = null) {
        revealAnimator.apply {
            if (isRunning) {
                val temp = animatedValue as Float
                setFloatValues(temp, endPercent)
                this.duration = (duration * (abs(endPercent - temp) / 100f)).toLong()
            } else {
                setFloatValues(startPercent, endPercent)
                this.duration = (duration * (abs(endPercent - startPercent) / 100f)).toLong()
            }
            addUpdateListener(onUpdate)
            start()
        }
    }
}