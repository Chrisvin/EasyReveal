package com.jem.easyreveal

import android.animation.ValueAnimator
import kotlin.math.abs

internal class RevealAnimatorManager {
    // Animator used for animating the reveal/hide animations
    private val revealAnimator: ValueAnimator = ValueAnimator()

    public fun animate(startPercent: Float, endPercent: Float, duration: Long, onUpdate: ((it: ValueAnimator) -> Unit)? = null) {
        if (revealAnimator.isRunning) {
            val temp = revealAnimator.animatedValue as Float
            revealAnimator.setFloatValues(temp, endPercent)
            revealAnimator.duration = (duration * (abs(endPercent - temp) / 100f)).toLong()
        } else {
            revealAnimator.setFloatValues(startPercent, endPercent)
            revealAnimator.duration = (duration * (abs(endPercent - startPercent) / 100f)).toLong()
        }
        revealAnimator.addUpdateListener(onUpdate)
        revealAnimator.start()
    }
}