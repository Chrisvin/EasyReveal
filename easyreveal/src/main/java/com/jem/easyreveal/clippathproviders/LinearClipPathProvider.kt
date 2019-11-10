package com.jem.easyreveal.clippathproviders

import android.graphics.Path
import android.view.View
import com.jem.easyreveal.ClipPathProvider

class LinearClipPathProvider : ClipPathProvider() {
    enum class Direction {
        LEFT_TO_RIGHT, RIGHT_TO_LEFT, TOP_TO_BOTTOM, BOTTOM_TO_TOP
    }

    var direction: Direction = Direction.LEFT_TO_RIGHT

    override fun getPath(forPercentage: Float, inView: View): Path {
        path.rewind()
        when (direction) {
            Direction.LEFT_TO_RIGHT -> path.addRect(
                0f,
                0f,
                inView.width.toFloat() * (forPercentage / 100),
                inView.height.toFloat(),
                Path.Direction.CW
            )
            Direction.RIGHT_TO_LEFT -> path.addRect(
                inView.width.toFloat() - (inView.width.toFloat() * (forPercentage / 100)),
                0f,
                inView.width.toFloat(),
                inView.height.toFloat(),
                Path.Direction.CW
            )
            Direction.TOP_TO_BOTTOM -> path.addRect(
                0f,
                0f,
                inView.width.toFloat(),
                inView.height.toFloat() * (forPercentage / 100),
                Path.Direction.CW
            )
            Direction.BOTTOM_TO_TOP -> path.addRect(
                0f,
                inView.height.toFloat() - (inView.height.toFloat() * (forPercentage / 100)),
                inView.width.toFloat(),
                inView.height.toFloat(),
                Path.Direction.CW
            )
        }
        return path
    }
}