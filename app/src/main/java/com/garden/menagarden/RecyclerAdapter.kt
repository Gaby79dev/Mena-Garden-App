package com.garden.menagarden

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.garden.menagarden.base.BaseViewHolder
import com.garden.menagarden.data.model.Cocktails
import com.garden.menagarden.ui.cocktails.CocktailsFragment
import kotlinx.android.synthetic.main.cocktails_row.view.*

class RecyclerAdapter(

    private val context: CocktailsFragment,
    private val CocktailsList:List<Cocktails>,
    private val itemOnClickListener: OnCocktailsClickListener  // pass de interface for clicks (views and items)

    ):RecyclerView.Adapter<BaseViewHolder<*>>() {


    interface OnCocktailsClickListener {    // the interface for the onClick items and image



        fun onImageClick(image: String)

        fun onItemClick (name: String)

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {


        return CocktailsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cocktails_row,parent,false))

    }


    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {

        when(holder){

        is CocktailsViewHolder -> holder.bind(CocktailsList[position],position)

            else -> throw IllegalArgumentException("Te has olvidado de pasar el viewholder en el bind")

        }
    }


    override fun getItemCount(): Int = CocktailsList.size



    inner class CocktailsViewHolder(itemView: View):BaseViewHolder<Cocktails>(itemView){

        override fun bind(item: Cocktails, position: Int) {

            Glide.with(context).load(item.image).into(itemView.image_cocktail)


            itemView.setOnClickListener { itemOnClickListener.onItemClick(item.name)  } // onClick in item
            itemView.image_cocktail.setOnClickListener { itemOnClickListener.onImageClick(item.image)} // on click in image
            itemView.nombreCocktail.text=item.name
            itemView.cocktailDescripES.text=item.textES
            itemView.cocktailDescripEN.text=item.textEN
        }
    }
}