package ru.spbstu.icc.kspt.lab2.continuewatch

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var secondsElapsed: Int = 0
    private lateinit var textSecondsElapsed: TextView

    private lateinit var sharedPref: SharedPreferences

    companion object {
        const val SECONDS_ELAPSED = "secondsElapsed"

        private const val NAME = "Continuewatch.MainActivity"
    }

    @SuppressLint("SetTextI18n")
    var backgroundThread = Thread {
        while (true) {
            Thread.sleep(1000)
            textSecondsElapsed.post {
                textSecondsElapsed.text = "Seconds elapsed: " + secondsElapsed++
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPref = getSharedPreferences(NAME, MODE_PRIVATE)

        setSecondsIfExists()

        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
        backgroundThread.start()
    }

    override fun onStart() {
        setSecondsIfExists()
        super.onStart()
    }

    override fun onStop() {
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