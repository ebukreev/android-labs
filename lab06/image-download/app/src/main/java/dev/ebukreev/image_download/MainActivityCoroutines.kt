package dev.ebukreev.image_download

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import java.net.URL

class MainActivityCoroutines : AppCompatActivity() {

    private val viewModel: ImageDownloadViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.img)

        viewModel.loadImage(imgUrl)

        viewModel.imageBitmap.observe(this) {
            image.setImageBitmap(it)
        }
    }
}