package com.garden.menagarden.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.garden.menagarden.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {


        private var _binding: FragmentGalleryBinding?=null
        private val binding get() = _binding!!

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {

            _binding= FragmentGalleryBinding.inflate(inflater,container,false)

            context?.let { it -> // If context is not null use it in the passed block as `it`

                Glide.with(it).load("https://i.postimg.cc/nr9W1NL5/christmas.jpg").into(binding.imgPhotoView)
                Glide.with(it).load("https://i.postimg.cc/nr9W1NL5/christmas.jpg").into(binding.img1)
                Glide.with(it).load("https://i.postimg.cc/FF2FQ40Y/dulces.jpg").into(binding.img2)
                Glide.with(it).load("https://i.postimg.cc/Dz5RfqDC/ensalada.jpg").into(binding.img3)
                Glide.with(it).load("https://i.postimg.cc/855977gT/garden.jpg").into(binding.img4)
                Glide.with(it).load("https://i.postimg.cc/MXkF3tMG/garden2.jpg").into(binding.img5)
                Glide.with(it).load("https://i.postimg.cc/FRBq3hh3/garden3.jpg").into(binding.img6)
                Glide.with(it).load("https://i.postimg.cc/xd9WSssJ/mojito.jpg").into(binding.img7)
                Glide.with(it).load("https://i.postimg.cc/dtrssx94/roscos.jpg").into(binding.img8)
                Glide.with(it).load("https://i.postimg.cc/0yv8b0Wx/tropical.jpg").into(binding.img9)
                Glide.with(it).load("https://i.postimg.cc/QMxhqxZy/weddings2.jpg").into(binding.img10)
                Glide.with(it).load("https://i.postimg.cc/gJxpfSJy/weddings3.jpg").into(binding.img11)
                Glide.with(it).load("https://i.postimg.cc/cHPWZRgp/vitrina.jpg").into(binding.img12)
                Glide.with(it).load("https://i.postimg.cc/h4J4wjQF/vending.jpg").into(binding.img13)
                Glide.with(it).load("https://i.postimg.cc/8CKDXQ1P/weddings5.jpg").into(binding.img14)



                binding.img1.setOnClickListener{

                    Glide.with(it).load("https://i.postimg.cc/nr9W1NL5/christmas.jpg").into(binding.imgPhotoView)
                }

                binding.img2.setOnClickListener{

                    Glide.with(it).load("https://i.postimg.cc/FF2FQ40Y/dulces.jpg").into(binding.imgPhotoView)

                }

                binding.img3.setOnClickListener{

                    Glide.with(it).load("https://i.postimg.cc/Dz5RfqDC/ensalada.jpg").into(binding.imgPhotoView)

                }

                binding.img4.setOnClickListener{

                    Glide.with(it).load("https://i.postimg.cc/855977gT/garden.jpg").into(binding.imgPhotoView)

                }

                binding.img5.setOnClickListener{

                    Glide.with(it).load("https://i.postimg.cc/MXkF3tMG/garden2.jpg").into(binding.imgPhotoView)

                }

                binding.img6.setOnClickListener{

                    Glide.with(it).load("https://i.postimg.cc/FRBq3hh3/garden3.jpg").into(binding.imgPhotoView)

                }

                binding.img7.setOnClickListener{

                    Glide.with(it).load("https://i.postimg.cc/xd9WSssJ/mojito.jpg").into(binding.imgPhotoView)

                }

                binding.img8.setOnClickListener{

                    Glide.with(it).load("https://i.postimg.cc/dtrssx94/roscos.jpg").into(binding.imgPhotoView)

                }

                binding.img9.setOnClickListener{

                    Glide.with(it).load("https://i.postimg.cc/0yv8b0Wx/tropical.jpg").into(binding.imgPhotoView)

                }

                binding.img10.setOnClickListener {

                    Glide.with(it).load("https://i.postimg.cc/QMxhqxZy/weddings2.jpg").into(binding.imgPhotoView)
                }

                binding.img11.setOnClickListener {

                    Glide.with(it).load("https://i.postimg.cc/gJxpfSJy/weddings3.jpg").into(binding.imgPhotoView)
                }

                binding.img12.setOnClickListener {

                    Glide.with(it).load("https://i.postimg.cc/cHPWZRgp/vitrina.jpg").into(binding.imgPhotoView)
                }

                binding.img13.setOnClickListener {

                    Glide.with(it).load("https://i.postimg.cc/h4J4wjQF/vending.jpg").into(binding.imgPhotoView)
                }

                binding.img14.setOnClickListener {

                    Glide.with(it).load("https://i.postimg.cc/8CKDXQ1P/weddings5.jpg").into(binding.imgPhotoView)
                }




            }


            return binding.root
        }

}
