package com.example.easyrevealdemo

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.jem.easyreveal.ClipPathProvider
import com.jem.easyreveal.clippathproviders.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ArrayAdapter.createFromResource(
            this,
            R.array.clipPathProviderArray,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            clipPathProvideSpinner.adapter = adapter
            clipPathProvideSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {}
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    revealLayout.clipPathProvider = clipPathProviderArrayList[position].apply {
                        when (this) {
                            is CircularClipPathProvider -> {
                                when (position) {
                                    4 -> setCircleCenter(revealLayout.width.toFloat()/2, revealLayout.height.toFloat()/2)
                                    5 -> setCircleCenter(revealLayout.width.toFloat()/2, 0f)
                                    6 -> setCircleCenter(0f, revealLayout.height.toFloat())
                                }
                            }
                            is SweepClipPathProvider -> {
                                when (position) {
                                    9 -> setCircleCenter(revealLayout.width.toFloat()/2, revealLayout.height.toFloat()/2)
                                    10 -> setCircleCenter(revealLayout.width.toFloat()/2, revealLayout.height.toFloat())
                                    11 -> setCircleCenter(0f, 0f)
                                }
                            }
                        }
                    }
                }
            }
        }

        revealLayout.setOnClickListener {
            if (flag) {
                revealLayout.hide()
//                revealLayout.revealForPercentage(50f)
            } else {
                revealLayout.reveal()
            }
            flag = !flag
        }
    }

    private var flag = true
    private val clipPathProviderArrayList = arrayListOf<ClipPathProvider>(
        LinearClipPathProvider(LinearClipPathProvider.Direction.LEFT_TO_RIGHT),
        LinearClipPathProvider(LinearClipPathProvider.Direction.RIGHT_TO_LEFT),
        LinearClipPathProvider(LinearClipPathProvider.Direction.TOP_TO_BOTTOM),
        LinearClipPathProvider(LinearClipPathProvider.Direction.BOTTOM_TO_TOP),
        CircularClipPathProvider(),
        CircularClipPathProvider(),
        CircularClipPathProvider(),
        StarClipPathProvider(),
        StarClipPathProvider(6),
        SweepClipPathProvider(),
        SweepClipPathProvider(),
        SweepClipPathProvider(),
        RandomLineClipPathProvider(RandomLineClipPathProvider.LineOrientation.VERTICAL),
        RandomLineClipPathProvider(lineOrientation = RandomLineClipPathProvider.LineOrientation.HORIZONTAL),
        CustomClipPathProvider()
    )
}
