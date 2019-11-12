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
    // RevealAnimator is used to perform reveal/hide animation
    private val revealAnimatorManager: RevealAnimatorManager = RevealAnimatorManager()

    // Backing fields for RevealLayout variables
    private var _clipPathProvider: ClipPathProvider = LinearClipPathProvider()
    private var _revealAnimationDuration: Long = 1000
    private var _hideAnimationDuration: Long = 1000

    override var clipPathProvider: ClipPathProvider
        get() = _clipPathProvider
        set(value) {
            _clipPathProvider = value
        }
    override var revealAnimationDuration: Long
        get() = _revealAnimationDuration
        set(value) {
            _revealAnimationDuration = value
        }
    override var hideAnimationDuration: Long
        get() = _hideAnimationDuration
        set(value) {
            _hideAnimationDuration = value
        }

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