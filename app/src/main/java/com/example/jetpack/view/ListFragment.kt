package com.example.jetpack.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpack.R
import com.example.jetpack.viewmodel.MyListViewModel
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {
    private val dogsListAdapter = DogsListAdapter(arrayListOf())
    private val myListViewModel : MyListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myListViewModel.refresh()


        dogRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dogsListAdapter
        }

        observeViewModel()
    }

     private fun observeViewModel(){
         myListViewModel.dogs.observe(viewLifecycleOwner, Observer { dogs ->
            dogRecyclerView.visibility = View.VISIBLE
            dogsListAdapter.updateDogList(dogs)
        })

        myListViewModel.loading.observe(viewLifecycleOwner, Observer { progressBarStatus ->
            progressBarStatus?.let {
                if(progressBarStatus) loadingProgressBar.visibility = View.VISIBLE else loadingProgressBar.visibility = View.GONE
            }
        })

         myListViewModel.loadError.observe(viewLifecycleOwner, Observer { errorMessageStatus ->
             errorMessageStatus?.let {
                 if (errorMessageStatus)  listError.visibility = View.VISIBLE else listError.visibility = View.GONE
             }
         })


    }
}