package com.jem.easyreveal.clippathproviders

import android.graphics.Path
import android.view.View
import com.jem.easyreveal.ClipPathProvider

/**
 * [ClipPathProvider] which provides a Rectangular path used to clip the view in a singular direction.
 */
class LinearClipPathProvider() : ClipPathProvider() {
    /**
     * Direction of the reveal animation.
     */
    enum class Direction {
        /**
         * Starts from the Left and proceeds to the Right of the view.
         */
        LEFT_TO_RIGHT,
        /**
         * Starts from the Right and proceeds to the Left of the view.
         */
        RIGHT_TO_LEFT,
        /**
         * Starts from the Top and proceeds to the Bottom of the view.
         */
        TOP_TO_BOTTOM,
        /**
         * Starts from the Bottom and proceeds to the Top of the view.
         */
        BOTTOM_TO_TOP
    }

    /**
     * Direction of the linear reveal.
     */
    var direction: Direction = Direction.LEFT_TO_RIGHT

    constructor(direction: Direction) : this() {
        this.direction = direction
    }

    override fun getPath(percent: Float, view: View): Path {
        path.rewind()
        when (direction) {
            Direction.LEFT_TO_RIGHT -> path.addRect(
                0f,
                0f,
                view.width.toFloat() * (percent / 100),
                view.height.toFloat(),
                Path.Direction.CW
            )
            Direction.RIGHT_TO_LEFT -> path.addRect(
                view.width.toFloat() - (view.width.toFloat() * (percent / 100)),
                0f,
                view.width.toFloat(),
                view.height.toFloat(),
                Path.Direction.CW
            )
            Direction.TOP_TO_BOTTOM -> path.addRect(
                0f,
                0f,
                view.width.toFloat(),
                view.height.toFloat() * (percent / 100),
                Path.Direction.CW
            )
            Direction.BOTTOM_TO_TOP -> path.addRect(
                0f,
                view.height.toFloat() - (view.height.toFloat() * (percent / 100)),
                view.width.toFloat(),
                view.height.toFloat(),
                Path.Direction.CW
            )
        }
        return path
    }
}