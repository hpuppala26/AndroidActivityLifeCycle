//package com.example.activitylifecycleapp
//
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Button
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//
//class MainActivity : AppCompatActivity() {
//
//    private var counter = 1
//    private lateinit var textViewCounter: TextView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        // Initialize the counter TextView
//        textViewCounter = findViewById(R.id.txtThreadCounter)
//
//        // Display the current counter value on the main page
//        updateCounter()
//
//        // Start Activity B and increment the counter by 5
//        findViewById<Button>(R.id.btnStartB).setOnClickListener {
//            val intent = Intent(this, ActivityB::class.java)
//            startActivityForResult(intent, 5)
//        }
//
//        // Start Activity C and increment the counter by 10
//        findViewById<Button>(R.id.btnStartC).setOnClickListener {
//            val intent = Intent(this, ActivityC::class.java)
//            startActivityForResult(intent, 10)
//        }
//
//        // Handle the "Close App" button
//        findViewById<Button>(R.id.btnCloseApp).setOnClickListener {
//            finishAffinity()  // This will close the app
//        }
//
//        // Show Dialog (Optional feature based on your previous request)
//        findViewById<Button>(R.id.btnDialog).setOnClickListener {
//            SimpleDialog().show(supportFragmentManager, "SimpleDialog")
//        }
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        // Increment the counter based on which activity was started
//        when (requestCode) {
//            5 -> counter += 5  // Activity B
//            10 -> counter += 10  // Activity C
//        }
//
//        // Update the counter display
//        updateCounter()
//    }
//
//    // Function to update the counter TextView
//    private fun updateCounter() {
//        textViewCounter.text = String.format("Thread Counter: %04d", counter)
//    }
//}

package com.example.activitylifecycleapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var counter = 1
    private var onRestartCounter = 0
    private lateinit var textViewCounter: TextView
    private lateinit var textViewRestartCounter: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the counter TextViews
        textViewCounter = findViewById(R.id.txtThreadCounter)
        textViewRestartCounter = findViewById(R.id.txtRestartCounter)

        // Display the current counters
        updateCounter()
        updateRestartCounter()

        // Start Activity B and increment the counter by 5
        findViewById<Button>(R.id.btnStartB).setOnClickListener {
            val intent = Intent(this, ActivityB::class.java)
            startActivityForResult(intent, 5)
        }

        // Start Activity C and increment the counter by 10
        findViewById<Button>(R.id.btnStartC).setOnClickListener {
            val intent = Intent(this, ActivityC::class.java)
            startActivityForResult(intent, 10)
        }

        // Handle the "Close App" button
        findViewById<Button>(R.id.btnCloseApp).setOnClickListener {
            finishAffinity()  // This will close the app
        }

        // Show Dialog (Optional feature based on your previous request)
        findViewById<Button>(R.id.btnDialog).setOnClickListener {
            SimpleDialog().show(supportFragmentManager, "SimpleDialog")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Increment the counter based on which activity was started
        when (requestCode) {
            5 -> counter += 5  // Activity B
            10 -> counter += 10  // Activity C
        }

        // Update the counter display
        updateCounter()
    }

    override fun onRestart() {
        super.onRestart()
        // Increment the onRestart counter and update the display
        onRestartCounter++
        updateRestartCounter()
    }

    // Function to update the thread counter TextView
    private fun updateCounter() {
        textViewCounter.text = String.format("Thread Counter: %04d", counter)
    }

    // Function to update the onRestart counter TextView
    private fun updateRestartCounter() {
        textViewRestartCounter.text = String.format("onRestart Counter: %d", onRestartCounter)
    }
}

