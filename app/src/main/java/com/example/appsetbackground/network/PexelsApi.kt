package com.example.appsetbackground.network

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PexelsApi {
    @Headers("Authorization: lieYFaAO9LD1STNnzllDOwJ1urIqXhv8jfGlfPYRCY1fDt8LaZXE0K47") // Thay YOUR_API_KEY bằng key từ Pexels
    @GET("search")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("per_page") perPage: Int = 15,
        @Query("page") page: Int = 1
    ): PexelsResponse
}