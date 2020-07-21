package com.example.jetpack.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.jetpack.R
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFrgament : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //sdfsafsdfsdadsfsadf
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailButton.setOnClickListener {
            Navigation.findNavController(it).navigate(DetailFrgamentDirections.actionDetailFrgamentToListFragment())
        }
    }
}