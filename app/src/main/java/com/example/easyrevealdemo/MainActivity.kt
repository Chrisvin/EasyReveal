package com.example.easyrevealdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        revealLayout.setOnClickListener {
            if (flag) {
//                revealLayout.hide()
                revealLayout.revealForPercentage(50f)
            } else {
                revealLayout.reveal()
            }
            flag = !flag
        }
    }

    private var flag = true
}
