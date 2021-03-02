package com.garden.menagarden

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.garden.menagarden.databinding.FragmentHistoriaBinding


class HistoriaFragment : Fragment() {


    private var _binding: FragmentHistoriaBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHistoriaBinding.inflate(inflater, container, false)

        context?.let { it -> // If context is not null use it in the passed block as `it`

            Glide.with(it).load("https://i.postimg.cc/rynCcz7d/menagardentitulo.png").centerCrop().into(binding.imagTitulo) // carga el título Mena Garden

            Glide.with(it).load("https://i.postimg.cc/cJ2VVB25/entrada.jpg").centerInside().into(binding.imagehome1)
            Glide.with(it).load("https://i.postimg.cc/gJxpfSJy/weddings3.jpg").centerInside().into(binding.imagehome2)

        }

        binding.botonmap.setOnClickListener {

            findNavController().navigate(HistoriaFragmentDirections.actionNavHistoriaFragmentToMapFragment())
        }


        return binding.root

    }


}