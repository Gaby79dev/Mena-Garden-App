package com.garden.menagarden.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.garden.menagarden.databinding.FragmentNetBinding


class NetFragment : Fragment() {

    private var _binding: FragmentNetBinding?=null
    private val binding get() = _binding!!



    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {




        _binding= FragmentNetBinding.inflate(inflater,container,false)


        //Esta llamada cargar directamente el webView

        binding.netview.webViewClient = WebViewClient()
        binding.netview.loadUrl("https://www.facebook.com/Mena-Garden-115626356963260/")
        val webSettings = binding.netview.settings
        webSettings.javaScriptEnabled = true



        //boton de facebook para cargar el webView

        binding.facebook.setOnClickListener {


            binding.netview.webViewClient = WebViewClient()
            binding.netview.loadUrl("https://www.facebook.com/Mena-Garden-115626356963260")
            val settings = binding.netview.settings
            settings.javaScriptEnabled = true

        }

        //boton de facebook para cargar el webView


        binding.instagram.setOnClickListener {


            binding.netview.webViewClient = WebViewClient()
            binding.netview.loadUrl("https://www.instagram.com/gardenmena/?hl=es")
            val settings = binding.netview.settings
            settings.javaScriptEnabled = true

        }


        return binding.root
    }


}
