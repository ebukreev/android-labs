package dev.ebukreev.image_download

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.graphics.BitmapFactory
import java.net.URL
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

const val imgUrl = "https://cs8.pikabu.ru/post_img/big/2016/02/04/7/145458292112119207.jpg"

class MainActivityExecutor : AppCompatActivity() {
    private lateinit var executor: ExecutorService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val image = findViewById<ImageView>(R.id.img)

        executor = Executors.newSingleThreadExecutor()
        val bitmapFuture = executor.submit<Bitmap>{
            BitmapFactory.decodeStream(URL(imgUrl).openConnection().inputStream)
        }

        image.setImageBitmap(bitmapFuture.get())
    }

    override fun onStop() {
        super.onStop()
        executor.shutdown()
    }
}