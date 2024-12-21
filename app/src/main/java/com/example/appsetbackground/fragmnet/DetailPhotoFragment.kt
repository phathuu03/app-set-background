package com.example.appsetbackground.fragmnet

import android.annotation.SuppressLint
import android.app.WallpaperManager
import android.content.Context
import android.graphics.Bitmap
import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.transition.Transition
import com.example.appsetbackground.R
import com.example.appsetbackground.databinding.FragmentDetailPhotoBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.net.URL


class DetailPhotoFragment : Fragment() {
    private val binding by lazy {
        FragmentDetailPhotoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    @SuppressLint("MissingPermission")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arg: DetailPhotoFragmentArgs by navArgs()
        val photo = arg.data

        val img = binding.photo
        val urlShow = photo.src.small
        val urlWallPaper = photo.src.medium
        Glide.with(this)
            .load(urlShow)
            .error(R.drawable.ic_launcher_background)
            .into(img)

        binding.btnSetBackground.setOnClickListener {

            lifecycleScope.launch {
                setWallPaper(requireContext(), urlWallPaper)
            }

        }



    }


}
private suspend fun setWallPaper(context: Context, url :String){
    try {
        withContext(Dispatchers.IO) {
            val inputStrem = URL(url).openStream()
            WallpaperManager.getInstance(context).setStream(inputStrem)
        }

        withContext(Dispatchers.Main) {
            Toast.makeText(
                context,
                "Set wall paper success",
                Toast.LENGTH_SHORT
            ).show()
        }

    } catch (e: Exception) {
        withContext(Dispatchers.Main) {
            Toast.makeText(
                context,
                "Set wall paper failed",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}


