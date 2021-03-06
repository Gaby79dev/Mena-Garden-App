package com.garden.menagarden.ui.cocktails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.garden.menagarden.databinding.FragmentDetailsCocktailsBinding


class DetailsCocktailsFragment : Fragment() {

    private var _binding: FragmentDetailsCocktailsBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDetailsCocktailsBinding.inflate(inflater, container, false)


       // Bundle of cocktail image

        val imagecocktail = arguments?.getString("image")


        if (imagecocktail != null) {

            Glide.with(this).load(imagecocktail).into(binding.photoView)
        }





        return binding.root
    }


}


