package com.jem.easyreveal.clippathproviders

import android.graphics.Path
import android.view.View
import com.jem.easyreveal.ClipPathProvider

class RandomLineClipPathProvider : ClipPathProvider() {

    /**
     * Pseudo random lines, arraylist is directly used instead of getting true Random() values,
     * to prevent any delays during reveal/hide animation & also to enable smooth recovery during animation swapping.
     */
    var randomLineArray = arrayListOf(56, 10, 11, 85, 46, 5, 94, 48, 55, 98, 73, 36, 30, 80, 78, 22, 47, 13, 68, 7, 50, 54, 67, 1, 42, 39, 40, 24, 61, 76, 53, 62, 82, 60, 97, 51, 92, 34, 29, 21, 100, 58, 69, 14, 4, 18, 19, 31, 8, 6, 23, 96, 9, 12, 70, 3, 17, 66, 28, 99, 89, 81, 91, 65, 32, 15, 63, 84, 72, 44, 77, 86, 26, 33, 41, 79, 88, 43, 74, 20, 90, 64, 49, 83, 27, 95, 93, 52, 75, 16, 37, 45, 25, 2, 59, 71, 57, 35, 87, 38)
        set(value) {
            require(value.distinct().count() == 100 && value.all { it in 1..100 }) {"randomLineArray should be an Integer ArrayList of size 100 with values in the range [1,100]"}
            field = value
        }

    var lineOrientation: LineOrientation = LineOrientation.VERTICAL

    enum class LineOrientation {
        HORIZONTAL, VERTICAL
    }

    override fun getPath(forPercentage: Float, inView: View): Path {
        path.reset()
        var pos: Float
        when (lineOrientation) {
            LineOrientation.VERTICAL -> {
                for(i in 0 until forPercentage.toInt()) {
                    pos = randomLineArray[i].toFloat() / 100
                    path.addRect(inView.width.toFloat() * (pos - 0.01f), 0f, inView.width.toFloat() * pos, inView.height.toFloat(), Path.Direction.CW)
                }
            }
            LineOrientation.HORIZONTAL -> {
                for(i in 0 until forPercentage.toInt()) {
                    pos = randomLineArray[i].toFloat() / 100
                    path.addRect(0f, inView.height.toFloat() * (pos - 0.01f), inView.width.toFloat(), inView.height.toFloat() * pos, Path.Direction.CW)
                }
            }
        }
        return path
    }
}