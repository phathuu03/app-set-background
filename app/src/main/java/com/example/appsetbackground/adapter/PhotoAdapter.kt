package com.example.appsetbackground.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.appsetbackground.databinding.ViewHolderPhotoBinding
import com.example.appsetbackground.network.Photo

class PhotoAdapter(
    private val onClickButon: (Photo) -> Unit,
    private val data: List<Photo>
) : RecyclerView.Adapter<PhotoAdapter.ViewHolderPhoto>() {
    inner class ViewHolderPhoto(private val binding: ViewHolderPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        // view holder
        val button = binding.btnDetailPhoto
        fun bind(photo: Photo) {
            binding.tvId.text = photo.id.toString()
            binding.tvUrlPhoto.text = photo.url
        }

        fun showDetail(photo: Photo) {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPhoto {
        val binding =
            ViewHolderPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderPhoto(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolderPhoto, position: Int) {
        holder.bind(data[position])
        holder.button.setOnClickListener {
            onClickButon(data[position])
        }
    }


}