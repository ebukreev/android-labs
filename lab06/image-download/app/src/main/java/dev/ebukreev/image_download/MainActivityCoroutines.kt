package dev.ebukreev.image_download

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import java.net.URL

class MainActivityCoroutines : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val image = findViewById<ImageView>(R.id.img)

        lifecycleScope.launchWhenStarted {
            withContext(Dispatchers.IO) {
                val bitmap = BitmapFactory.decodeStream(URL(imgUrl).openConnection().inputStream)

                runOnUiThread {
                    image.setImageBitmap(bitmap)
                }
            }
        }
    }
}