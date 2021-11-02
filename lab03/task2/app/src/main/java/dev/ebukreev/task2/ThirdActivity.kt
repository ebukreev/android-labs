package dev.ebukreev.task2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.ebukreev.task2.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binging: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binging.root)
        binging.toFirst.setOnClickListener {
            this.setResult(Activity.RESULT_OK)
            finish()
        }
        binging.toSecond.setOnClickListener { finish() }
        binging.toAbout.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
    }
}