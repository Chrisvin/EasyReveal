package com.jem.easyreveal.clippathproviders

import android.graphics.Path
import android.view.View
import com.jem.easyreveal.ClipPathProvider
import kotlin.math.sqrt

/**
 * Used for Circular Reveal, x & y mark the circle center
 */
class CircularClipPathProvider() : ClipPathProvider() {
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

    override fun getPath(forPercentage: Float, inView: View): Path {
        path.rewind()
        // Determine circle radius by checking which corner is furthest from circle center
        val radius = maxOf(
            getDistanceTo(0f, 0f),
            getDistanceTo(0f, inView.height.toFloat()),
            maxOf(
                getDistanceTo(inView.width.toFloat(), 0f),
                getDistanceTo(inView.width.toFloat(), inView.height.toFloat())
            )
        ) * (forPercentage / 100)
        path.addCircle(x, y, radius, Path.Direction.CW)
        return path
    }

    private fun getDistanceTo(pointX: Float, pointY: Float): Float {
        return sqrt(((x - pointX) * (x - pointX)) + ((y - pointY) * (y - pointY)))
    }
}