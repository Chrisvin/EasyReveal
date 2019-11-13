package com.jem.easyreveal.clippathproviders

import android.graphics.Path
import android.view.View
import com.jem.easyreveal.ClipPathProvider
import kotlin.math.abs
import kotlin.math.sin

/**
 * [ClipPathProvider] which provides Wave shaped paths which are flatter when **percent** is closer to 0 or 100,
 * and are at max height when closer to 50.
 */
class WaveClipPathProvider() : ClipPathProvider() {
    /** Maximum height of waves.*/
    var amplitude: Int = 30
    /** Frequency of waves, higher frequency == more waves */
    var frequency: Int = 45
    /** Speed at which waves 'move'. */
    var speed: Int = 20
    /** Wave reveal direction. */
    var direction: Direction = Direction.BOTTOM_TO_TOP

    constructor(
        direction: Direction = Direction.BOTTOM_TO_TOP,
        amplitude: Int = 30,
        frequency: Int = 45,
        speed: Int = 20
    ) : this() {
        this.direction = direction
        this.amplitude = amplitude
        this.frequency = frequency
        this.speed = speed
    }

    /**
     * Direction in which reveal animation is performed.
     */
    enum class Direction {
        /**
         * Reveal from the Top to the Bottom of the view.
         */
        TOP_TO_BOTTOM,
        /**
         * Reveal from the Bottom to the Top of the view.
         */
        BOTTOM_TO_TOP
    }

    override fun getPath(percent: Float, view: View): Path {
        path.rewind()
        when (direction) {
            Direction.TOP_TO_BOTTOM -> {
                path.moveTo(0f, 0f)
                for (i in 0..view.width + 10 step 10) {
                    path.lineTo(
                        i.toFloat(),
                        (view.height.toFloat() * (percent / 100))
                                + (amplitude * ((abs(percent - 50f) - 50f) / 100))
                                * sin((i + 10) * Math.PI / frequency + speed * (percent / 100)).toFloat()
                    )
                }
                path.lineTo(view.width.toFloat(), 0f)
            }
            Direction.BOTTOM_TO_TOP -> {
                path.moveTo(0f, view.height.toFloat())
                for (i in 0..view.width + 10 step 10) {
                    path.lineTo(
                        i.toFloat(),
                        (view.height.toFloat() * (abs(percent - 100f) / 100))
                                + (amplitude * ((abs(percent - 50f) - 50f) / 100))
                                * sin((i + 10) * Math.PI / frequency + speed * (percent / 100)).toFloat()
                    )
                }
                path.lineTo(view.width.toFloat(), view.height.toFloat())
            }
        }
        path.close()
        return path
    }
}