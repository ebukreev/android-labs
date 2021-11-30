package dev.ebukreev.task2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.ebukreev.task2.databinding.ActivityFirstBinding

class MainActivity : AbstractActivity() {
    private lateinit var binging: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binging.root)
        binging.bnToSecond.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
        binging.aboutActivity.setOnClickListener { goToAbout() }
    }
}