package com.garden.menagarden

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.garden.menagarden.databinding.FragmentMapBinding


class MapFragment : Fragment() {

    private var _binding:FragmentMapBinding?=null
    private val binding get() = _binding!!


    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentMapBinding.inflate(inflater, container, false)

        binding.webMap.webChromeClient=object : WebChromeClient(){

        }


        binding.webMap.webViewClient = WebViewClient()
        binding.webMap.loadUrl("https://www.google.com/maps/place/Mena+Garden+Nerja/@36.744872,-3.8803793,17z/data=!3m1!4b1!4m8!3m7!1s0x0:0x4721ef80dc2e424!5m2!4m1!1i2!8m2!3d36.744872!4d-3.8781906")
        val webSettings = binding.webMap.settings
        webSettings.javaScriptEnabled = true


        return binding.root
    }


}