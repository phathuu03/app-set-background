package com.example.appsetbackground.fragmnet

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appsetbackground.R
import com.example.appsetbackground.adapter.PhotoAdapter
import com.example.appsetbackground.databinding.FragmentListPhotoBinding
import com.example.appsetbackground.viewmodel.PhotoViewModel


class ListPhotoFragment : Fragment() {
    private val binding by lazy{
        FragmentListPhotoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val photoViewModel = ViewModelProvider(requireActivity())[PhotoViewModel::class.java]
        val recyclerViewPhoto = binding.recyclerViewPhoto
        recyclerViewPhoto.layoutManager = LinearLayoutManager(context)
        photoViewModel.searchPhotos("nature",
            {photos ->
                recyclerViewPhoto.adapter = PhotoAdapter(
                    {photo ->
                        val action = ListPhotoFragmentDirections.actionListPhotoFragmentToDetailPhotoFragment(photo)
                       findNavController().navigate(action)
                    },
                    photos)

            },
            {msg ->
                Log.e("ERROR" , msg)

            }
        )
    }


}