package com.jem.easyreveal.layouts

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.os.Build
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import com.jem.easyreveal.ClipPathProvider
import com.jem.easyreveal.RevealLayout
import com.jem.easyreveal.clippathproviders.CircularClipPathProvider

class EasyRevealLinearLayout: LinearLayout, RevealLayout {
    // Path that is used to clip the view
    private var path: Path? = null
    // ClipPathProvider provides the aforementioned path used for clipping
    var clipPathProvider: ClipPathProvider = CircularClipPathProvider()
    // Animator used for animating the reveal/hide animations
    private val revealAnimator: ValueAnimator = ValueAnimator()
    // Reveal animation duration
    var revealAnimationDuration: Long = 1000
    // Hide animation duration
    var hideAnimationDuration: Long = 1000

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    override fun draw(canvas: Canvas?) {
        try {
            canvas?.save()
            path?.let {
                canvas?.clipPath(it, clipPathProvider.op)
            }
            super.draw(canvas)
        } finally {
            canvas?.restore()
        }
    }

    override fun reveal() {
        if (revealAnimator.isRunning) {
            val temp = revealAnimator.animatedValue as Float
            revealAnimator.setFloatValues(temp, 100f)
        } else {
            revealAnimator.setFloatValues(0f, 100f)
        }
        revealAnimator.addUpdateListener {
            path = clipPathProvider.getPath(it.animatedValue as Float, this@EasyRevealLinearLayout)
            invalidate()
        }
        revealAnimator.duration = revealAnimationDuration
        revealAnimator.start()
    }

    override fun hide() {
        if (revealAnimator.isRunning) {
            val temp = revealAnimator.animatedValue as Float
            revealAnimator.setFloatValues(temp, 0f)
        } else {
            revealAnimator.setFloatValues(100f, 0f)
        }
        revealAnimator.addUpdateListener {
            path = clipPathProvider.getPath(it.animatedValue as Float, this@EasyRevealLinearLayout)
            invalidate()
        }
        revealAnimator.duration = hideAnimationDuration
        revealAnimator.start()
    }

    override fun revealForPercentage(percent: Float) {
        path = clipPathProvider.getPath(percent, this@EasyRevealLinearLayout)
        invalidate()
    }
}