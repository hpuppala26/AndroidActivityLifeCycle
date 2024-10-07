package com.example.activitylifecycleapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityB : AppCompatActivity() {
    private var onRestartCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        findViewById<Button>(R.id.btnFinishB).setOnClickListener {
            finish()
        }
    }

    override fun onRestart() {
        super.onRestart()
        onRestartCounter++
        Log.d("ActivityB", "onRestart called $onRestartCounter times")
    }
}
