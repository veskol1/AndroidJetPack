package com.example.jetpack.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack.R
import com.example.jetpack.model.DogBreed
import com.example.jetpack.util.getProgressDrawable

import com.example.jetpack.util.loadImage
import kotlinx.android.synthetic.main.item_dog.view.*

class DogsListAdapter (val dogsList: ArrayList<DogBreed>): RecyclerView.Adapter<DogsListAdapter.DogViewHolder>() {

    fun updateDogList (newDogList : ArrayList<DogBreed>){
        dogsList.clear()
        dogsList.addAll(newDogList)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsListAdapter.DogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dog, parent, false) as View
        return DogViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dogsList.size
    }

    override fun onBindViewHolder(holder: DogsListAdapter.DogViewHolder, position: Int) {
        holder.view.nameItem.text = dogsList[position].dogBreed
        holder.view.lifespanItem.text = dogsList[position].lifeSpan
        holder.view.imageView.loadImage(dogsList[position].imageView, getProgressDrawable(holder.view.imageView.context))
        holder.view.setOnClickListener {
            Navigation.findNavController(it).navigate(ListFragmentDirections.actionListFragmentToDetailFrgament())
        }
    }


    class DogViewHolder (val view: View) :RecyclerView.ViewHolder(view)

}