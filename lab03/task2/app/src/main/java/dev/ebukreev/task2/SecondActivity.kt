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
        binging.bnToFirst.setOnClickListener { finish() }
        binging.bnToThird.setOnClickListener {
//            startActivity(Intent(this, ThirdActivity::class.java))
            startActivityForResult(Intent(this, ThirdActivity::class.java), code)
        }
        binging.aboutActivity.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == code && resultCode == Activity.RESULT_OK) {
            finish()
        }
    }

    override fun onSupportNavigateUp() = true.also { finish() }
}