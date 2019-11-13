package com.example.easyrevealdemo

import android.graphics.Path
import android.view.View
import com.jem.easyreveal.ClipPathProvider
import kotlin.math.sqrt

class CustomClipPathProvider : ClipPathProvider() {
    override fun getPath(percent: Float, view: View): Path {
        path.rewind()
        val radius = getDistance(0f,0f,view.width.toFloat() / 2, view.height.toFloat() / 2) * (percent/100)
        path.addCircle(0f, 0f, radius, Path.Direction.CW)
        path.addCircle(view.width.toFloat(), 0f, radius, Path.Direction.CW)
        path.addCircle(0f, view.height.toFloat(), radius, Path.Direction.CW)
        path.addCircle(view.width.toFloat(), view.height.toFloat(), radius, Path.Direction.CW)
        return path
    }

    private fun getDistance(startX: Float, startY: Float, endX: Float, endY: Float): Float {
        return sqrt(((startX - endX) * (startX - endX)) + ((startY - endY) * (startY - endY)))
    }
}