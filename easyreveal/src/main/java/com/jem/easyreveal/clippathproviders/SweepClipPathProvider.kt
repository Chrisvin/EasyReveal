package com.jem.easyreveal.clippathproviders

import android.graphics.Path
import android.view.View
import com.jem.easyreveal.ClipPathProvider
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

class SweepClipPathProvider() : ClipPathProvider() {
    private var x: Float = 0f
    private var y: Float = 0f

    constructor(x: Float, y: Float) : this() {
        this.x = x
        this.y = y
    }

    public fun setCircleCenter(x: Float, y: Float) {
        this.x = x
        this.y = y
    }

    override fun getPath(percent: Float, view: View): Path {
        path.reset()
        path.moveTo(x, y)

        // Determine circle radius by checking which corner is furthest from circle center
        val radius = maxOf(
            getDistanceTo(0f, 0f),
            getDistanceTo(0f, view.height.toFloat()),
            maxOf(
                getDistanceTo(view.width.toFloat(), 0f),
                getDistanceTo(view.width.toFloat(), view.height.toFloat())
            )
        )

        // Determine start and end angle , default is 0f & 360f respectively when center is somewhere inside the view
        // But if center is at edge/vertice of view, then start & end angle needs to be determined
        val startAngle = when {
            x == 0f && (y > 0f && y <= view.height.toFloat()) -> 270f
            (x > 0f && x <= view.width.toFloat()) && y == view.height.toFloat() -> 180f
            x == view.width.toFloat() && (y >= 0f && y < view.height.toFloat()) -> 90f
            else -> 0f
        }
        val endAngle = when {
            x == 0f && y == 0f -> 90f
            x == 0f && (y > 0f && y < view.height.toFloat()) -> 450f
            x == view.width.toFloat() && (y > 0f && y <= view.height.toFloat()) -> 270f
            (x > 0f && x <= view.width.toFloat()) && y == 0f -> 180f
            else -> 360f
        }

        for (i in 0..percent.toInt()) {
            path.lineTo(
                x + radius * cos((startAngle + (endAngle - startAngle) * (i.toFloat() / 100)) * (PI / 180).toFloat()),
                y + radius * sin((startAngle + (endAngle - startAngle) * (i.toFloat() / 100)) * (PI / 180).toFloat())
            )
        }

        path.close()
        return path
    }

    private fun getDistanceTo(pointX: Float, pointY: Float): Float {
        return sqrt(((x - pointX) * (x - pointX)) + ((y - pointY) * (y - pointY)))
    }
}