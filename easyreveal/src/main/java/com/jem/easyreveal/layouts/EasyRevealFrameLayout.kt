package com.jem.easyreveal.layouts

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.os.Build
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import com.jem.easyreveal.ClipPathProvider
import com.jem.easyreveal.RevealAnimatorManager
import com.jem.easyreveal.RevealLayout
import com.jem.easyreveal.clippathproviders.LinearClipPathProvider

/**
 * `EasyRevealinearLayout` is a custom [FrameLayout] that implements [RevealLayout].
 */
class EasyRevealFrameLayout : FrameLayout, RevealLayout {
    // Store path in local variable rather then getting it from ClipPathProvider each time
    private var path: Path? = null
    // RevealAnimator is used to perform reveal/hide animation
    private val revealAnimatorManager: RevealAnimatorManager = RevealAnimatorManager()

    // Backing fields for RevealLayout variables
    private var _clipPathProvider: ClipPathProvider = LinearClipPathProvider()
    private var _revealAnimationDuration: Long = 1000
    private var _hideAnimationDuration: Long = 1000
    private var _currentRevealPercent: Float = 100f
    private var _onUpdateListener: RevealLayout.OnUpdateListener? = null

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
    override var currentRevealPercent: Float
        get() = _currentRevealPercent
        set(value) {
            updateView(value)
        }
    override var onUpdateListener: RevealLayout.OnUpdateListener?
        get() = _onUpdateListener
        set(value) {
            _onUpdateListener = value
        }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    /**
     * Overriden from View
     */
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
        revealAnimatorManager.animate(currentRevealPercent, 100f, revealAnimationDuration) {
            updateView(it.animatedValue as Float)
        }
    }

    override fun hide() {
        revealAnimatorManager.animate(currentRevealPercent, 0f, hideAnimationDuration) {
            updateView(it.animatedValue as Float)
        }
    }

    override fun revealForPercentage(percent: Float, shouldAnimate: Boolean) {
        if (shouldAnimate) {
            revealAnimatorManager.animate(currentRevealPercent, percent, revealAnimationDuration) {
                updateView(it.animatedValue as Float)
            }
        } else {
            updateView(percent)
        }
    }

    private fun updateView(percent: Float) {
        _currentRevealPercent = percent
        path = clipPathProvider.getPath(percent, this@EasyRevealFrameLayout)
        invalidate()
        onUpdateListener?.onUpdate(percent)
    }
}