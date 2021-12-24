package dev.ebukreev.image_download

import android.app.Application
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ImageDownloadApplication : Application() {
    val executorService: ExecutorService = Executors.newSingleThreadExecutor()
}