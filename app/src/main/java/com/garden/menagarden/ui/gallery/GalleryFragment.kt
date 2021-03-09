package com.garden.menagarden.ui.gallery

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.garden.menagarden.MainActivity
import com.garden.menagarden.databinding.FragmentGalleryBinding
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_gallery.*

class GalleryFragment : Fragment() {


    private lateinit var binding: FragmentGalleryBinding

    val db = FirebaseFirestore.getInstance() // val to get CloudFirestoreData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentGalleryBinding.inflate(inflater, container, false)

        (activity as MainActivity).hideFloatingActionButton() // llamada al MainActivity para esconder el botón flotante

        val image = db.collection("galeríaFotos").document("galeria")
        image.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("exist", "DocumentSnapshot data: ${document.data}")


                    // Recover de url from the cloudFirebase and load the image by Glide

                    val firstImage = document.getString("img1")
                    Glide.with(requireContext()).load(firstImage)
                        .into(binding.imgPhotoView) // load the first image into the photoView


                    val image1 = document.getString("img1")
                    Glide.with(requireContext()).load(image1).centerCrop().into(binding.img1)
                    binding.img1.setOnClickListener {
                        Glide.with(it).load(image1).into(binding.imgPhotoView)
                    }

                    val image2 = document.getString("img2")
                    Glide.with(requireContext()).load(image2).centerCrop().into(binding.img2)
                    binding.img2.setOnClickListener {
                        Glide.with(it).load(image2).centerInside().into(binding.imgPhotoView)
                    }

                    val image3 = document.getString("img3")
                    Glide.with(requireContext()).load(image3).centerCrop().into(binding.img3)
                    binding.img3.setOnClickListener {
                        Glide.with(it).load(image3).centerCrop().into(binding.imgPhotoView)
                    }

                    val image4 = document.getString("img4")
                    Glide.with(requireContext()).load(image4).centerCrop().into(binding.img4)
                    binding.img4.setOnClickListener {
                        Glide.with(it).load(image4).centerCrop().into(binding.imgPhotoView)
                    }

                    val image5 = document.getString("img5")
                    Glide.with(requireContext()).load(image5).centerCrop().into(binding.img5)
                    binding.img5.setOnClickListener {
                        Glide.with(it).load(image5).centerCrop().into(binding.imgPhotoView)
                    }

                    val image6 = document.getString("img6")
                    Glide.with(requireContext()).load(image6).centerCrop().into(binding.img6)
                    binding.img6.setOnClickListener {
                        Glide.with(it).load(image6).centerCrop().into(binding.imgPhotoView)
                    }

                    val image7 = document.getString("img7")
                    Glide.with(requireContext()).load(image7).centerCrop().into(binding.img7)
                    binding.img7.setOnClickListener {
                        Glide.with(it).load(image7).centerCrop().into(binding.imgPhotoView)
                    }

                    val image8 = document.getString("img8")
                    Glide.with(requireContext()).load(image8).centerCrop().into(binding.img8)
                    binding.img8.setOnClickListener {
                        Glide.with(it).load(image8).centerCrop().into(binding.imgPhotoView)
                    }

                    val image9 = document.getString("img9")
                    Glide.with(requireContext()).load(image9).centerCrop().into(binding.img9)
                    binding.img9.setOnClickListener {
                        Glide.with(it).load(image9).centerCrop().into(binding.imgPhotoView)
                    }

                    val image10 = document.getString("img10")
                    Glide.with(requireContext()).load(image10).centerCrop().into(binding.img10)
                    binding.img10.setOnClickListener {
                        Glide.with(it).load(image10).centerCrop().into(binding.imgPhotoView)
                    }


                    val image11 = document.getString("img11")
                    Glide.with(requireContext()).load(image11).centerCrop().into(binding.img11)
                    binding.img11.setOnClickListener {
                        Glide.with(it).load(image11).centerCrop().into(binding.imgPhotoView)
                    }

                    val image12 = document.getString("img12")
                    Glide.with(requireContext()).load(image12).centerCrop().into(binding.img12)
                    binding.img12.setOnClickListener {
                        Glide.with(it).load(image12).centerCrop().into(binding.imgPhotoView)
                    }

                    val image13 = document.getString("img13")
                    Glide.with(requireContext()).load(image13).centerCrop().into(binding.img13)
                    binding.img13.setOnClickListener {
                        Glide.with(it).load(image13).centerCrop().into(binding.imgPhotoView)
                    }

                    val image14 = document.getString("img14")
                    Glide.with(requireContext()).load(image14).centerCrop().into(binding.img14)
                    binding.img14.setOnClickListener {
                        Glide.with(it).load(image14).centerCrop().into(binding.imgPhotoView)
                    }


                } else {
                    Log.d("noexist", "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("errordb", "get failed with ", exception)
            }


        return binding.root
    }


}


