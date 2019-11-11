package com.jem.easyreveal.layouts

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.jem.easyreveal.ClipPathProvider
import com.jem.easyreveal.RevealAnimatorManager
import com.jem.easyreveal.RevealLayout
import com.jem.easyreveal.clippathproviders.LinearClipPathProvider

class EasyRevealConstraintLayout : ConstraintLayout, RevealLayout {
    // Store path in local variable rather then getting it from ClipPathProvider each time
    private var path: Path? = null
    // ClipPathProvider provides the aforementioned path used for clipping
    var clipPathProvider: ClipPathProvider = LinearClipPathProvider()
    // RevealAnimator is used to perform reveal/hide animation
    private val revealAnimatorManager: RevealAnimatorManager = RevealAnimatorManager()
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

    override fun reveal(onUpdate: ((percent: Float) -> Unit)?) {
        revealAnimatorManager.reveal(revealAnimationDuration) {
            path =
                clipPathProvider.getPath(it.animatedValue as Float, this@EasyRevealConstraintLayout)
            invalidate()
            onUpdate?.invoke(it.animatedValue as Float)
        }
    }

    override fun hide(onUpdate: ((percent: Float) -> Unit)?) {
        revealAnimatorManager.hide(hideAnimationDuration) {
            path =
                clipPathProvider.getPath(it.animatedValue as Float, this@EasyRevealConstraintLayout)
            invalidate()
            onUpdate?.invoke(it.animatedValue as Float)
        }
    }

    override fun revealForPercentage(percent: Float) {
        path = clipPathProvider.getPath(percent, this@EasyRevealConstraintLayout)
        invalidate()
    }
}