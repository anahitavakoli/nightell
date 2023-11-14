package com.anahitavakoli.apps.nightell.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.anahitavakoli.apps.nightell.R
import com.anahitavakoli.apps.nightell.model.Category
import com.bumptech.glide.Glide

class CategoryAdapter(mContext : Context , list : List<Category>): RecyclerView.Adapter<CategoryAdapter.CategoryVH>() {

    val context = mContext
    val catList = list

    class CategoryVH(itemView: View) : RecyclerView.ViewHolder(itemView){

        val imgCat = itemView.findViewById<AppCompatImageView>(R.id.img_category)
        val txtCat = itemView.findViewById<AppCompatTextView>(R.id.txt_category_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryVH {
        val view : View = LayoutInflater.from(context).inflate(R.layout.category_item, null)
        return CategoryVH(view)

    }

    override fun getItemCount(): Int {
        return catList.size
    }

    override fun onBindViewHolder(holder: CategoryVH, position: Int) {
        val cat = catList[position]
        holder.txtCat.text = cat.categoryName
        Glide
            .with(context)
            .load(cat.categoryImage)
            .centerCrop()
            .placeholder(R.drawable.baseline_category_24)
            .into(holder.imgCat);
    }
}