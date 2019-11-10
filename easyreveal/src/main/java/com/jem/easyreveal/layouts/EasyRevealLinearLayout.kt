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
        val valueAnimator = ValueAnimator.ofFloat(0f, 100f)
        valueAnimator.addUpdateListener {
            path = clipPathProvider.getPath(it.animatedValue as Float, this@EasyRevealLinearLayout)
            invalidate()
        }
        valueAnimator.duration = 2000
        valueAnimator.start()
    }

    override fun hide() {
        val valueAnimator = ValueAnimator.ofFloat(100f, 0f)
        valueAnimator.addUpdateListener {
            path = clipPathProvider.getPath(it.animatedValue as Float, this@EasyRevealLinearLayout)
            invalidate()
        }
        valueAnimator.duration = 2000
        valueAnimator.start()
    }

    override fun revealForPercentage(percent: Float) {
        path = clipPathProvider.getPath(percent, this@EasyRevealLinearLayout)
        invalidate()
    }
}