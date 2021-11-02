package dev.ebukreev.task2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.ebukreev.task2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binging: ActivitySecondBinding
    private val code = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binging.root)
        binging.toFirst.setOnClickListener { finish() }
        binging.toThird.setOnClickListener {
            startActivityForResult(Intent(this, ThirdActivity::class.java), code)
        }
        binging.toAbout.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == code && resultCode == Activity.RESULT_OK) {
            finish()
        }
    }
}