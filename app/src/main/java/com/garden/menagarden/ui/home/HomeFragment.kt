package com.garden.menagarden.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.garden.menagarden.MainActivity
import com.garden.menagarden.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private  var _binding: FragmentHomeBinding?=null
    private val binding get() = _binding!!



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {


       _binding= FragmentHomeBinding.inflate(inflater,container,false)



        //Muestra el FloatingButton después de esconderlo en el Reservas Fragment

        (activity as MainActivity).showFloatingActionButton()




        binding.menu.setOnClickListener {

        findNavController().navigate(HomeFragmentDirections.actionNavHomeToNavMenu())

        }

        binding.reserve.setOnClickListener {

            findNavController().navigate(HomeFragmentDirections.actionNavHomeToNavReservar())

        }

        binding.cocktails.setOnClickListener{

            findNavController().navigate((HomeFragmentDirections.actionNavHomeToCocktails()))

        }

        binding.gallery.setOnClickListener{

            findNavController().navigate(HomeFragmentDirections.actionNavHomeToNavGallery())
        }

        binding.offers.setOnClickListener{


            findNavController().navigate(HomeFragmentDirections.actionNavHomeToNavSpecialoffers())

        }


        binding.btnnet.setOnClickListener {


            findNavController().navigate((HomeFragmentDirections.actionNavHomeToNetFragment()))

        }

        binding.history.setOnClickListener{

            findNavController().navigate((HomeFragmentDirections.actionNavHomeToHistoriaFragment()))

        }




        return binding.root
    }

}