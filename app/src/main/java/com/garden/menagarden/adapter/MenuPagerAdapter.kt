package com.garden.menagarden.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.garden.menagarden.R
import kotlinx.android.synthetic.main.item_view_menupager.view.*

class MenuPagerAdapter(private val context : Context, private val image: List<String>):RecyclerView.Adapter<MenuPagerAdapter.MenuPagerViewHolder>() {

    inner class MenuPagerViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_menupager, parent,false)
        return MenuPagerViewHolder(view)
    }


    override fun getItemCount(): Int {
        return image.size
    }


    override fun onBindViewHolder(holder: MenuPagerViewHolder, position: Int) {

        Glide.with(context).load(image[position]).optionalCenterCrop().into(holder.itemView.pv_menu)

    }

}


