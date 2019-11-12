package com.jem.easyreveal.clippathproviders

import android.graphics.Path
import android.view.View
import com.jem.easyreveal.ClipPathProvider
import kotlin.math.abs
import kotlin.math.sin

class WaveClipPathProvider() : ClipPathProvider() {
    // Maximum height of waves
    var amplitude: Int = 30
    // Frequency of waves, higher frequency == more waves
    var frequency: Int = 45
    // Speed at which waves 'move'
    var speed: Int = 20
    // Wave fill direction
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

    enum class Direction {
        TOP_TO_BOTTOM, BOTTOM_TO_TOP
    }

    override fun getPath(forPercentage: Float, inView: View): Path {
        path.rewind()
        when (direction) {
            Direction.TOP_TO_BOTTOM -> {
                path.moveTo(0f, 0f)
                for (i in 0..inView.width + 10 step 10) {
                    path.lineTo(
                        i.toFloat(),
                        (inView.height.toFloat() * (forPercentage / 100))
                                + (amplitude * ((abs(forPercentage - 50f) - 50f) / 100))
                                * sin((i + 10) * Math.PI / frequency + speed * (forPercentage / 100)).toFloat()
                    )
                }
                path.lineTo(inView.width.toFloat(), 0f)
            }
            Direction.BOTTOM_TO_TOP -> {
                path.moveTo(0f, inView.height.toFloat())
                for (i in 0..inView.width + 10 step 10) {
                    path.lineTo(
                        i.toFloat(),
                        (inView.height.toFloat() * (abs(forPercentage - 100f) / 100))
                                + (amplitude * ((abs(forPercentage - 50f) - 50f) / 100))
                                * sin((i + 10) * Math.PI / frequency + speed * (forPercentage / 100)).toFloat()
                    )
                }
                path.lineTo(inView.width.toFloat(), inView.height.toFloat())
            }
        }
        path.close()
        return path
    }
}