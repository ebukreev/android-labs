package dev.ebukreev.task5

import android.app.Activity
import android.content.Intent

fun toAboutActivity(calling: Activity) {
    calling.startActivity(Intent(calling, AboutActivity::class.java))
}