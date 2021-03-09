package com.garden.menagarden.ui.ofertas

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.garden.menagarden.databinding.FragmentOfertasBinding
import com.google.firebase.firestore.FirebaseFirestore

class OfertasFragment : Fragment() {

    private lateinit var binding:FragmentOfertasBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val db = FirebaseFirestore.getInstance() // val to get CloudFirestoreData


        binding = FragmentOfertasBinding.inflate(inflater,container,false)


        //Load image Title "Eventos"
        Glide.with(requireContext()).load("https://firebasestorage.googleapis.com/v0/b/mena-garden-garden.appspot.com/o/Events.png?alt=media&token=19baae92-1149-4b5c-a89b-b34d55874ae3")
            .centerInside().into(binding.imageTitleEvent)


        val offer1 = db.collection("offers").document("offersData")
        offer1.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("exist", "DocumentSnapshot data: ${document.data}")


                   // CUPÓN 1 OFERTA

                    // Load from cloudFirebase and paint into the textViews
                    binding.textDescription.text = document.getString("description")
                    binding.cuponCode.text = document.getString("code")
                    binding.textPrice.text = document.getString("price")


                    // Recover de url from the cloudFirebase and load by Glide
                    val image = document.getString("image")
                    Glide.with(requireContext()).load(image).centerCrop().into(binding.imageOffer)

                } else {
                    Log.d("noexist", "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("errordb", "get failed with ", exception)
            }


        val offer2 = db.collection("offers").document("offersData2")
        offer2.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("exist", "DocumentSnapshot data: ${document.data}")


                    // CUPÓN 2 OFERTA

                    // Load from cloudFirebase and paint into the textViews
                    binding.textDescription2.text = document.getString("description")
                    binding.cuponCode2.text = document.getString("code")
                    binding.textPrice2.text = document.getString("price")


                    // Recover de url from the cloudFirebase and load by Glide
                    val image2 = document.getString("image")
                    Glide.with(requireContext()).load(image2).centerCrop().into(binding.imageOffer2)

                } else {
                    Log.d("noexist", "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("errordb", "get failed with ", exception)
            }

        val offer3 = db.collection("offers").document("offersData3")
        offer3.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("exist", "DocumentSnapshot data: ${document.data}")


                    // CUPÓN 3 OFERTA

                    // Load from cloudFirebase and paint into the textViews
                    binding.textDescription3.text = document.getString("description")
                    binding.cuponCode3.text = document.getString("code")
                    binding.textPrice3.text = document.getString("price")


                    // Recover de url from the cloudFirebase and load by Glide
                    val image3 = document.getString("image")
                    Glide.with(requireContext()).load(image3).centerCrop().into(binding.imageOffer3)

                } else {
                    Log.d("noexist", "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("errordb", "get failed with ", exception)
            }


        // EVENTS TAG

        val event1 = db.collection("events").document("event1")
        event1.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("exist", "DocumentSnapshot data: ${document.data}")


                   // Load from cloudFirebase and paint into the textViews
                    binding.textEvent.text = document.getString("description")


                    // Recover de url from the cloudFirebase and load by Glide
                    val imageEvent1 = document.getString("image")
                    Glide.with(requireContext()).load(imageEvent1).centerInside().into(binding.imageEvent)

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