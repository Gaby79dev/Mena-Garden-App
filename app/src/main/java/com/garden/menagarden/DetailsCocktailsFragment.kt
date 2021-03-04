package com.garden.menagarden

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.garden.menagarden.databinding.FragmentDetailsCocktailsBinding


class DetailsCocktailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsCocktailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsCocktailsBinding.inflate(inflater, container, false)


        val imagecocktail = arguments?.getString("image")


        if (imagecocktail != null) {

            Glide.with(this).load(imagecocktail).into(binding.photoView)
        }





        return binding.root
    }


}


