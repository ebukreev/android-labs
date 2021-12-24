package ru.spbstu.icc.kspt.lab2.continuewatch

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger

class MainActivity : AppCompatActivity() {
    private var secondsElapsed = AtomicInteger()
    private lateinit var textSecondsElapsed: TextView

    private lateinit var sharedPref: SharedPreferences

    companion object {
        const val SECONDS_ELAPSED = "secondsElapsed"

        private const val NAME = "Continuewatch.MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
        lifecycleScope.launchWhenStarted {
            while (isActive) {
                delay(1000)
                    textSecondsElapsed.text =
                        getString(R.string.seconds_elapsed, secondsElapsed.incrementAndGet())
            }
        }
    }

    override fun onStart() {
        super.onStart()
        sharedPref = getSharedPreferences(NAME, MODE_PRIVATE)
        setSecondsIfExists()
    }

    override fun onStop() {
        super.onStop()
        sharedPref.edit().apply {
            putInt(SECONDS_ELAPSED, secondsElapsed.get())
            apply()
        }
    }

    private fun setSecondsIfExists() {
        if (sharedPref.contains(SECONDS_ELAPSED)) {
            secondsElapsed.set(sharedPref.getInt(SECONDS_ELAPSED, 0))
        }
    }
}