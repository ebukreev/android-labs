package ru.spbstu.icc.kspt.lab2.continuewatch

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var secondsElapsed: Int = 0
    private var isTextViewVisible = false
    private lateinit var textSecondsElapsed: TextView

    private lateinit var sharedPref: SharedPreferences

    companion object {
        const val SECONDS_ELAPSED = "secondsElapsed"

        private const val NAME = "Continuewatch.MainActivity"
    }

    private var backgroundThread = Thread {
        while (true) {
            if (isTextViewVisible) {
                Thread.sleep(1000)
                textSecondsElapsed.post {
                    textSecondsElapsed.text = getString(R.string.seconds_elapsed, secondsElapsed++)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
        backgroundThread.start()
    }

    override fun onStart() {
        sharedPref = getSharedPreferences(NAME, MODE_PRIVATE)
        isTextViewVisible = true
        setSecondsIfExists()
        super.onStart()
    }

    override fun onStop() {
        isTextViewVisible = false
        sharedPref.edit().apply {
            putInt(SECONDS_ELAPSED, secondsElapsed)
            apply()
        }
        super.onStop()
    }

    private fun setSecondsIfExists() {
        if (sharedPref.contains(SECONDS_ELAPSED)) {
            secondsElapsed = sharedPref.getInt(SECONDS_ELAPSED, 0)
        }
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        outState.apply {
//            putInt(SECONDS_ELAPSED, secondsElapsed)
//        }
//
//        super.onSaveInstanceState(outState)
//    }

//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        secondsElapsed = savedInstanceState.getInt(SECONDS_ELAPSED)
//
//        super.onRestoreInstanceState(savedInstanceState)
//    }
}