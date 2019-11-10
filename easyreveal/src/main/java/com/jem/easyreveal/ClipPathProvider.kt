package com.jem.easyreveal

import android.graphics.Path
import android.graphics.Region
import android.graphics.Region.Op
import android.os.Build
import android.view.View

// Abstract class that should be extended by other ClipPathProvider classes
abstract class ClipPathProvider {
    protected var path: Path = Path()
    var op: Region.Op = Region.Op.INTERSECT
        set(value) {
            require(!(Build.VERSION.SDK_INT >= Build.VERSION_CODES.P && op != Op.INTERSECT && op != Op.DIFFERENCE)) { "Invalid Region.Op - only INTERSECT and DIFFERENCE are allowed" }
            field = value
        }

    abstract fun getPath(forPercentage: Float, inView: View): Path
}