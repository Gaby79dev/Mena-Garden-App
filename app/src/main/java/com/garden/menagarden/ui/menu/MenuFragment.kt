package com.garden.menagarden.ui.menu

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.garden.menagarden.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View {




        _binding = FragmentMenuBinding.inflate(inflater, container, false)


        binding.menuView.loadUrl("https://online.fliphtml5.com/kseay/rvzk/#p=1")
        binding.menuView.settings.javaScriptEnabled =
            true // javascript para cargar la pagina del menú


        return binding.root

    }




}
















