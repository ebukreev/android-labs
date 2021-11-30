package dev.ebukreev.task2

import android.app.Activity
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.R
import androidx.navigation.ui.navigateUp
import dev.ebukreev.task2.databinding.ActivityThirdBinding

class ThirdActivity : AbstractActivity() {
    private lateinit var binging: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binging.root)
        binging.bnToFirst.setOnClickListener {
//            startActivity(Intent(this, MainActivity::class.java)
//                .addFlags(FLAG_ACTIVITY_CLEAR_TOP))
            this.setResult(Activity.RESULT_OK)
            finish()
        }
        binging.bnToSecond.setOnClickListener { finish() }
        binging.aboutActivity.setOnClickListener { goToAbout() }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}