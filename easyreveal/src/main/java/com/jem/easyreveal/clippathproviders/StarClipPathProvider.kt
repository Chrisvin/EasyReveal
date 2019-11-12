package com.jem.easyreveal.clippathproviders

import android.graphics.Path
import android.view.View
import com.jem.easyreveal.ClipPathProvider
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

class StarClipPathProvider() : ClipPathProvider() {
    private var numberOfPoints: Int = 5

    constructor(numberOfPoints: Int) : this() {
        this.numberOfPoints = numberOfPoints
    }

    public fun setNumberOfPoints(numberOfPoints: Int) {
        this.numberOfPoints = numberOfPoints
    }

    override fun getPath(forPercentage: Float, inView: View): Path {
        path.rewind()
        // Determine inner circle radius by checking which corner is furthest from circle center
        val radius = maxOf(
            getDistance(inView.width.toFloat() / 2, inView.height.toFloat() / 2, 0f, 0f),
            getDistance(
                inView.width.toFloat() / 2,
                inView.height.toFloat() / 2,
                0f,
                inView.height.toFloat()
            ),
            maxOf(
                getDistance(
                    inView.width.toFloat() / 2,
                    inView.height.toFloat() / 2,
                    inView.width.toFloat(),
                    0f
                ),
                getDistance(
                    inView.width.toFloat() / 2,
                    inView.height.toFloat() / 2,
                    inView.width.toFloat(),
                    inView.height.toFloat()
                )
            )
        ) * (forPercentage / 100)

        path.moveTo(inView.width.toFloat() / 2, inView.height.toFloat() / 2)

        for (step in 0..numberOfPoints) {
            path.lineTo(
                inView.width.toFloat() / 2 + 2 * radius * cos(((360.toFloat() / numberOfPoints) * step - 90) * (PI / 180).toFloat()),
                inView.height.toFloat() / 2 + 2 * radius * sin(((360.toFloat() / numberOfPoints) * step - 90) * (PI / 180).toFloat())
            )

            path.lineTo(
                inView.width.toFloat() / 2 + radius * cos(((360.toFloat() / numberOfPoints) * step + ((360.toFloat() / numberOfPoints) / 2) - 90) * (PI / 180).toFloat()),
                inView.height.toFloat() / 2 + radius * sin(((360.toFloat() / numberOfPoints) * step + ((360.toFloat() / numberOfPoints) / 2) - 90) * (PI / 180).toFloat())
            )
        }

        path.close()

        return path
    }

    private fun getDistance(startX: Float, startY: Float, endX: Float, endY: Float): Float {
        return sqrt(((startX - endX) * (startX - endX)) + ((startY - endY) * (startY - endY)))
    }
}