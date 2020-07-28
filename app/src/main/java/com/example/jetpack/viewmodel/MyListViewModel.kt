package com.example.jetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpack.model.DogBreed

class MyListViewModel : ViewModel() {
    val dogs = MutableLiveData<ArrayList<DogBreed>>()
    val loadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh(){
        val dog1 = DogBreed("1","corgi", "10 years", "")
        val dog2 = DogBreed("2","corgi2", "15 years", "")
        val dog3 = DogBreed("3","corgi3", "20 years", "")

        val dogsList = arrayListOf<DogBreed>(dog1,dog2,dog3)
        dogs.value = dogsList
        loadError.value = false
        loading.value = false
    }



}