package com.garden.menagarden.ui.ofertas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.garden.menagarden.databinding.FragmentOfertasBinding

class OfertasFragment : Fragment() {

    private var _binding: FragmentOfertasBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding= FragmentOfertasBinding.inflate(inflater,container,false)




        return binding.root
    }
}