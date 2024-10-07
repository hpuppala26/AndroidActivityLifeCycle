package com.example.activitylifecycleapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityC : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        // Handle Finish C Button
        findViewById<Button>(R.id.btnFinishC).setOnClickListener {
            // Finish Activity C and return to Activity A
            finish()
        }
    }
}
