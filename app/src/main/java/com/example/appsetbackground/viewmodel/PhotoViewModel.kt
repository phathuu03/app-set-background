package com.example.appsetbackground.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appsetbackground.network.Photo
import com.example.appsetbackground.network.Retrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PhotoViewModel : ViewModel() {

    fun searchPhotos(
        query: String,
        onResult: (List<Photo>) -> Unit,
        onError: (String) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = Retrofit.api.searchPhotos(query)
                withContext(Dispatchers.Main) {
                    onResult(response.photos)
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main){
                    onError("Error: ${e.message}\"")
                }
            }
        }

    }
}