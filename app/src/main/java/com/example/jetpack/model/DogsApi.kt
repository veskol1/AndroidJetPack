package com.example.jetpack.model

import io.reactivex.Single
import retrofit2.http.GET

interface DogsApi   {

///DevTides/DogsApi/master/dogs.json

    @GET("DevTides/DogsApi/master/dogs.json")
    fun getDogs(): Single<List<DogBreed>>
}