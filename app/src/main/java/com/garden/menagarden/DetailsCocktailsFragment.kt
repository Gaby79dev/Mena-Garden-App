package com.garden.menagarden

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.garden.menagarden.databinding.FragmentDetailsCocktailsBinding


class DetailsCocktailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsCocktailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsCocktailsBinding.inflate(inflater, container, false)
        return binding.root



    }


}