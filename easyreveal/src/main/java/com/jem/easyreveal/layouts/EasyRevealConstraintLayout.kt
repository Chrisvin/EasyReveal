package com.jem.easyreveal.layouts

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.jem.easyreveal.ClipPathProvider
import com.jem.easyreveal.R
import com.jem.easyreveal.RevealAnimatorManager
import com.jem.easyreveal.RevealLayout
import com.jem.easyreveal.clippathproviders.*

/**
 * `EasyRevealinearLayout` is a custom [ConstraintLayout] that implements [RevealLayout].
 */
class EasyRevealConstraintLayout : ConstraintLayout, RevealLayout {
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

    override var clipPathProvider = _clipPathProvider
    override var revealAnimationDuration = _revealAnimationDuration
    override var hideAnimationDuration = _hideAnimationDuration
    override var currentRevealPercent: Float
        get() = _currentRevealPercent
        set(value) {
            updateView(value)
        }
    override var onUpdateListener = _onUpdateListener

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initialize(attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initialize(attrs)
    }

    private fun initialize(attrs: AttributeSet?) {
        attrs?.let {
            val typedArray =
                context.obtainStyledAttributes(it, R.styleable.EasyRevealConstraintLayout, 0, 0)
            typedArray.apply {
                revealAnimationDuration = getInt(
                    R.styleable.EasyRevealConstraintLayout_revealAnimationDuration,
                    1000
                ).toLong()
                hideAnimationDuration = getInt(
                    R.styleable.EasyRevealConstraintLayout_hideAnimationDuration,
                    1000
                ).toLong()
                currentRevealPercent = getFloat(
                    R.styleable.EasyRevealConstraintLayout_startRevealPercent,
                    100f
                )
                clipPathProvider =
                    when (getInt(
                        R.styleable.EasyRevealConstraintLayout_clipPathProvider,
                        1
                    )) {
                        0 -> CircularClipPathProvider()
                        1 -> LinearClipPathProvider()
                        2 -> RandomLineClipPathProvider()
                        3 -> StarClipPathProvider()
                        4 -> SweepClipPathProvider()
                        5 -> WaveClipPathProvider()
                        else -> LinearClipPathProvider()
                    }
            }
            typedArray.recycle()
        }
    }

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
        path = clipPathProvider.getPath(percent, this@EasyRevealConstraintLayout)
        invalidate()
        onUpdateListener?.onUpdate(percent)
    }
}