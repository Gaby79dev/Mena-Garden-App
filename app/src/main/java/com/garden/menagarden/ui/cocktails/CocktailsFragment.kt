package com.garden.menagarden.ui.cocktails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.garden.menagarden.MainActivity
import com.garden.menagarden.R
import com.garden.menagarden.RecyclerAdapter
import com.garden.menagarden.data.model.Cocktails
import com.garden.menagarden.databinding.FragmentCocktailsBinding


class CocktailsFragment : Fragment(), RecyclerAdapter.OnCocktailsClickListener {


    private lateinit var binding : FragmentCocktailsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        (activity as MainActivity).hideFloatingActionButton() // Call Main activity to hide the floating button


        binding = FragmentCocktailsBinding.inflate(inflater,container,false)




        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

    }


    private fun setupRecyclerView() {


        binding.rvCocktails.layoutManager = LinearLayoutManager(requireContext()) //RecyclerView from fragment_cocktails

        binding.rvCocktails.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL)) // line between items


            val listCocktails = listOf(

                Cocktails(
                    name= "MOJITO",
                    textES = "Ron blanco, azúcar, hojas de hierbabuena, agua con gas.",
                    textEN = "White rum, sugar, mint leaveslemon, sparkling water.",
                    image = "https://i.postimg.cc/0QdVcCcn/img8.jpg"
                ),
                Cocktails(
                    name = "FRUIT PASSION MOJITO",
                    textES = "Ron, fruta de la pasión, Passoa y refresco de lima",
                    textEN = "Rum, Passion fruit, Passoa and  lime soda.",
                    image = "https://i.postimg.cc/wj7bgLjx/img7.jpg"
                ),
                Cocktails(
                    name = "ESPRESSO MARTINI",
                    textES = "Kahlua, vodka y café.",
                    textEN = "Kahlua, vodka and coffe.",
                    image = "https://i.postimg.cc/qMmZPj0Z/img6.jpg"
                ),
                Cocktails(
                    name = "COSMOPOLITAN",
                    textES = "Vodka sabor limón, triple seco, lima y zumo de arándanos.",
                    textEN = "Citron Vodka, triple sec, lime and cranberry juice.",
                    image = "https://i.postimg.cc/qBxFLpFr/img2.jpg"
                ),
                Cocktails(
                    name = "MANGO DAIKIRI",
                    textES = "Ron blanco, mango natural y sirope.",
                    textEN = "White rum, natural mango and syrup.",
                    image = "https://i.postimg.cc/xdmxbQmW/img5.jpg"
                ),
                Cocktails(
                    name ="STRAWBERRY DAIKIRI" ,
                    textES ="Ron blanco, zumo de limón y fresas naturales.",
                    textEN = "White rum, lemon juice and natural Strawberry.",
                    image ="https://i.postimg.cc/mgJpDkPY/img4.jpg"
                ),
                Cocktails(
                    name = "CAIPIRINHA",
                    textES = "Cachaça, azúcar blanca y morena e hielo picado.",
                    textEN = "Cachaça, white and brown sugar and ice.",
                    image = "https://i.postimg.cc/nrF05QWJ/img10.jpg"
                ),
                Cocktails(
                    name = "WHISKY SOUR",
                    textES = "Jim Beam miel, sirope de azúcar, limón y clara de huevo.",
                    textEN = "Jim Beam honey, sugar syrup, lemon and egg white.",
                    image = "https://i.postimg.cc/2y02fSpB/img11.jpg"
                ),
                Cocktails(
                    name = "TIKI COCKTAILS",
                    textES = "Bebida al estilo polinesio con sabor a frutas.",
                    textEN = "Polynesian-style drink with fruity flavor.",
                    image = "https://i.postimg.cc/h4sCmpJP/img12.jpg"
                ),
                Cocktails(
                    name = "MOSCOW MULE",
                    textES = "Vodka, lima y ginger-beer.",
                    textEN = "Vodka, lime and ginger-beer.",
                    image = "https://i.postimg.cc/HxCSwN4j/img9.jpg"
                ),
                Cocktails(
                    name = "PORNSTAR MARTINI",
                    textES = "Vodka, passoa, zumo de piña, sirope y cava.",
                    textEN = "Vodka, passoa, pineapple juice, syrup and cava.",
                    image = "https://i.postimg.cc/xTd63MHG/img13.jpg"
                ),
                Cocktails(
                    name = "SEX ON THE BEACH",
                    textES= "Vodka, licor de melocotón, zumo de naranja y granadina",
                    textEN = "Vodka, peach liqueur, orange juice and grenadine.",
                    image = "https://i.postimg.cc/bwDLKPms/img15.jpg"
                ),
                Cocktails(
                    name = "PIÑA COLADA",
                    textES= "Ron, Mangaroca y zumo de piña.",
                    textEN = "Rum, coconut rum and pineapple juice.",
                    image = "https://i.postimg.cc/TYHC71qz/img14.jpg"
                ),
                Cocktails(
                    name = "MARGARITA",
                    textES = "Tequila, triple seco y zumo de limón.",
                    textEN = "Tequila, triple sec and lemon juice.",
                    image = "https://i.postimg.cc/52hpJrrp/img16.jpg"
                ),
                Cocktails(
                    name = "VIRGIN STRAWBERRY DAIQUIRI (NON ALCOHOLIC) ",
                    textES = "Fresas naturales, azúcar y lima.",
                    textEN = "Natural strawberry. sugar and lime.",
                    image = "https://i.postimg.cc/L64bQrd1/img3.jpg"
                ),
                Cocktails(
                    name = "SAN FRANCISCO  (NON ALCOHOLIC)",
                    textES= "Zumo de piña, zumo de naranja y granadina.",
                    textEN = "Pineapple juice, orange juice and granadine.",
                    image = "https://i.postimg.cc/D06YycG0/img1.jpg"
                ),
                Cocktails(
                    name = "MANGO GARDEN (NON ALCOHOLIC) ",
                    textES = "Sirope de violeta, zumo de mango y lima",
                    textEN = "Violet syrup. mango juice and lime.",
                    image = "https://i.postimg.cc/SKcdxrF4/img17.jpg"
                ),
                Cocktails(
                    name = "VIRGIN COLADA   (NON ALCOHOLIC)",
                    textES = "Piña natural y sirope de coco.",
                    textEN = "Natural pineapple and coconut syrup.",
                    image = "https://i.postimg.cc/qBxFLpFr/img2.jpg"
                ),


            )

            binding.rvCocktails.adapter = RecyclerAdapter(this, listCocktails, this) // implement in CocktailsFragment class the interface if not the this error.

    }



    override fun onImageClick(image: String) {



        val imagecocktail = Bundle()
        imagecocktail.putString("image",image)


        findNavController().navigate(R.id.action_nav_cocktails_to_detailsCocktailsFragment, imagecocktail)

    }


    override fun onItemClick(name: String) {

            Toast.makeText(requireContext(), "Cocktails List", Toast.LENGTH_SHORT).show()

    }



}


