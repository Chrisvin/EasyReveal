package com.jem.easyreveal.clippathproviders

import android.graphics.Path
import android.view.View
import com.jem.easyreveal.ClipPathProvider

/**
 * [ClipPathProvider] which provides path which consists of **random** strips of rectangles (AKA, `lines`).
 */
class RandomLineClipPathProvider() : ClipPathProvider() {

    constructor(lineOrientation: LineOrientation = LineOrientation.HORIZONTAL) : this() {
        this.lineOrientation = lineOrientation
    }

    /**
     * [ArrayList] of random integers in the range 1..100
     *
     * The idea is to have pseudo random lines, [Arraylist] is directly used instead of getting true Random() values,
     * to prevent any delays during reveal/hide animation & also to enable smooth recovery during animation swapping.
     *
     * @exception IllegalArgumentException thrown when arrayList size is not 100 or when values are not in the range 1..100
     */
    var randomLineArrayList = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100).apply { shuffle() }
        set(value) {
            require(value.count() == 100 && value.all { it in 1..100 }) {"randomLineArray should be an Integer ArrayList of size 100 with values in the range [1,100]"}
            field = value
        }

    /**
     * Orientation of the reveal animation lines.
     */
    var lineOrientation: LineOrientation = LineOrientation.VERTICAL

    /**
     * Orientation of the rectangular strips.
     */
    enum class LineOrientation {
        /**
         * Horizontal rectangular strips.
         */
        HORIZONTAL,
        /**
         * Vertical rectangular strips.
         */
        VERTICAL
    }

    override fun getPath(percent: Float, view: View): Path {
        path.reset()
        var pos: Float
        when (lineOrientation) {
            LineOrientation.VERTICAL -> {
                for(i in 0 until percent.toInt()) {
                    pos = randomLineArrayList[i].toFloat() / 100
                    path.addRect(view.width.toFloat() * (pos - 0.01f), 0f, view.width.toFloat() * pos, view.height.toFloat(), Path.Direction.CW)
                }
            }
            LineOrientation.HORIZONTAL -> {
                for(i in 0 until percent.toInt()) {
                    pos = randomLineArrayList[i].toFloat() / 100
                    path.addRect(0f, view.height.toFloat() * (pos - 0.01f), view.width.toFloat(), view.height.toFloat() * pos, Path.Direction.CW)
                }
            }
        }
        return path
    }
}