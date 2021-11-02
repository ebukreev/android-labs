package dev.ebukreev.task2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.ebukreev.task2.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    private lateinit var binging: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binging.root)
        binging.toSecond.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
        binging.toAbout.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
    }
}