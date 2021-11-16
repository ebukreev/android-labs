package dev.ebukreev.task2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.ebukreev.task2.databinding.ActivityFirstBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binging: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binging.root)
        binging.bnToSecond.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
        binging.aboutActivity.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp() = true.also { finish() }
}