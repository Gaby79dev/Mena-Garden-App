package com.garden.menagarden.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.garden.menagarden.adapter.MenuPagerAdapter
import com.garden.menagarden.databinding.FragmentMenuBinding
import com.garden.menagarden.R


class MenuFragment : Fragment() {

    private  var _binding: FragmentMenuBinding?=null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        startToast()
        _binding = FragmentMenuBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val images = listOf(        //image load from Firestore.


            "https://firebasestorage.googleapis.com/v0/b/mena-garden-garden.appspot.com/o/fotos%20menu%2F1.jpg?alt=media&token=7b01b759-be28-4cc2-bceb-64eae6a05486",
            "https://firebasestorage.googleapis.com/v0/b/mena-garden-garden.appspot.com/o/fotos%20menu%2F2.jpg?alt=media&token=54f1c1eb-eeb7-4489-8328-5682feb7da83",
            "https://firebasestorage.googleapis.com/v0/b/mena-garden-garden.appspot.com/o/fotos%20menu%2F3.jpg?alt=media&token=c22fc0d8-b311-426e-aa6f-58498322bb5f",
            "https://firebasestorage.googleapis.com/v0/b/mena-garden-garden.appspot.com/o/fotos%20menu%2F4.jpg?alt=media&token=49b1b4de-2723-4af9-ad4a-46287ffc5287",
            "https://firebasestorage.googleapis.com/v0/b/mena-garden-garden.appspot.com/o/fotos%20menu%2F5.jpg?alt=media&token=ed71fd7a-f318-48bd-8845-6d0cca22ec11",
            "https://firebasestorage.googleapis.com/v0/b/mena-garden-garden.appspot.com/o/fotos%20menu%2F6.jpg?alt=media&token=2a3b0712-2650-410a-8018-c57b3154a12f",
            "https://firebasestorage.googleapis.com/v0/b/mena-garden-garden.appspot.com/o/fotos%20menu%2F7.jpg?alt=media&token=839899a1-8071-4b43-b0ae-3de7b33ee2a8",
            "https://firebasestorage.googleapis.com/v0/b/mena-garden-garden.appspot.com/o/fotos%20menu%2F8.jpg?alt=media&token=bb1d2def-8954-4ee1-86d9-8f6cd785379b",
            "https://firebasestorage.googleapis.com/v0/b/mena-garden-garden.appspot.com/o/fotos%20menu%2F13.jpg?alt=media&token=c212c66b-e04a-45c2-b65b-c93ad5c3e605",
            "https://firebasestorage.googleapis.com/v0/b/mena-garden-garden.appspot.com/o/fotos%20menu%2F9.jpg?alt=media&token=8c68aba0-a923-4ccd-8225-eb511056d8c2",
            "https://firebasestorage.googleapis.com/v0/b/mena-garden-garden.appspot.com/o/fotos%20menu%2F10.jpg?alt=media&token=a5701704-1168-44f3-8645-6e7da2723aee",
            "https://firebasestorage.googleapis.com/v0/b/mena-garden-garden.appspot.com/o/fotos%20menu%2F11.jpg?alt=media&token=c76e5838-a34e-4e52-a28a-73f341488493",
            "https://firebasestorage.googleapis.com/v0/b/mena-garden-garden.appspot.com/o/fotos%20menu%2F12.jpg?alt=media&token=e7b41ce8-7c91-44a5-b906-1eb0e5ed30e3",
            "https://firebasestorage.googleapis.com/v0/b/mena-garden-garden.appspot.com/o/fotos%20menu%2F14.jpg?alt=media&token=4ff39ee5-1e06-4cf8-a90e-feb47a09f335",
            "https://firebasestorage.googleapis.com/v0/b/mena-garden-garden.appspot.com/o/fotos%20menu%2F15.jpg?alt=media&token=1753d2f2-de4d-4a58-9ed2-3eef2fbb584b",
            "https://firebasestorage.googleapis.com/v0/b/mena-garden-garden.appspot.com/o/fotos%20menu%2F16.jpg?alt=media&token=63dee373-bfcf-4532-8517-bca93d479d19",
            "https://firebasestorage.googleapis.com/v0/b/mena-garden-garden.appspot.com/o/fotos%20menu%2Fbebidas.jpg?alt=media&token=62e20008-e897-46c2-902e-bcda80a1dbc1"



        )

        val adapter = context?.let { MenuPagerAdapter(it, images) }
        binding.viewPager.adapter = adapter

    }

    fun startToast() {

        Toast.makeText(requireContext(),resources.getString(R.string.slide_to_the_left),Toast.LENGTH_LONG).show()

    }

}
















