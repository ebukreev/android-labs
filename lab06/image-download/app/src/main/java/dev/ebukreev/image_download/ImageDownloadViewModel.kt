package dev.ebukreev.image_download

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class ImageDownloadViewModel : ViewModel() {
    private val _imageBitmap by lazy { MutableLiveData<Bitmap>() }
    val imageBitmap: LiveData<Bitmap> = _imageBitmap

    fun loadImage(url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val bitmap = BitmapFactory.decodeStream(URL(url).openConnection().inputStream)

            withContext(Dispatchers.Main) {
                _imageBitmap.value = bitmap
            }
        }
    }
}