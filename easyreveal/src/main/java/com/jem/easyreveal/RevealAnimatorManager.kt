package com.jem.easyreveal

import android.animation.ValueAnimator

internal class RevealAnimatorManager {
    // Animator used for animating the reveal/hide animations
    private val revealAnimator: ValueAnimator = ValueAnimator()

    public fun reveal(duration: Long, onUpdate:((it:ValueAnimator) -> Unit)? = null) {
        if (revealAnimator.isRunning) {
            val temp = revealAnimator.animatedValue as Float
            revealAnimator.setFloatValues(temp, 100f)
            revealAnimator.duration = (duration * ((100f - temp)/100f)).toLong()
        } else {
            revealAnimator.setFloatValues(0f, 100f)
            revealAnimator.duration = duration
        }
        revealAnimator.addUpdateListener(onUpdate)
        revealAnimator.start()
    }

    public fun hide(duration: Long, onUpdate:((it:ValueAnimator) -> Unit)? = null) {
        if (revealAnimator.isRunning) {
            val temp = revealAnimator.animatedValue as Float
            revealAnimator.setFloatValues(temp, 0f)
            revealAnimator.duration = duration - (duration * ((100f - temp)/100f)).toLong()
        } else {
            revealAnimator.setFloatValues(100f, 0f)
            revealAnimator.duration = duration
        }
        revealAnimator.addUpdateListener(onUpdate)
        revealAnimator.start()
    }
}