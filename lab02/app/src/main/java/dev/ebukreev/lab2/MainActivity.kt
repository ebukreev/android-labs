package dev.ebukreev.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val logTag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(logTag, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        Log.i(logTag, "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.i(logTag, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.i(logTag, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i(logTag, "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i(logTag, "onDestroy")
        super.onDestroy()
    }

    override fun onRestart() {
        Log.i(logTag, "onRestart")
        super.onRestart()
    }
}