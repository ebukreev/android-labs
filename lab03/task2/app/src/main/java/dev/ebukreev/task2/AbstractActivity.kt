package dev.ebukreev.task2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

abstract class AbstractActivity : AppCompatActivity() {
    override fun onSupportNavigateUp() = true.also { finish() }

    protected fun goToAbout() {
        startActivity(Intent(this, AboutActivity::class.java))
    }
}