package com.example.appsetbackground.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class PexelsResponse(
    val photos: List<Photo>
): Parcelable

@Parcelize
data class Photo(
    val id: Int,
    val width: Int,
    val height: Int,
    val url: String,
    val photographer: String,
    val src: Src
): Parcelable

@Parcelize
data class Src(
    val original: String,
    val medium: String,
    val small: String
) : Parcelable