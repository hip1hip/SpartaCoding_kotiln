package com.example.lovecat

import com.example.lovecat.data.CatModel
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "live_htAK7owueXTeU51lfx0Q2hUsBWUN5FzEpdgcZfoDGB6tIBLt9RWSENLVL0UlKst1"

interface CatService {
    @GET("v1/images/search?api_key=$API_KEY")
    suspend fun getImages(
        @Query("limit") num: Int = 1
    ): CatModel
}