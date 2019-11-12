package com.jem.easyreveal.clippathproviders

import android.graphics.Path
import android.view.View
import com.jem.easyreveal.ClipPathProvider

class RandomLineClipPathProvider() : ClipPathProvider() {

    constructor(lineOrientation: LineOrientation = LineOrientation.HORIZONTAL) : this() {
        this.lineOrientation = lineOrientation
    }

    /**
     * Pseudo random lines, arraylist is directly used instead of getting true Random() values,
     * to prevent any delays during reveal/hide animation & also to enable smooth recovery during animation swapping.
     */
    var randomLineArray = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100).apply { shuffle() }
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