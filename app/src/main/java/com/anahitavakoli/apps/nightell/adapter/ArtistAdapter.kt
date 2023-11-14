package com.anahitavakoli.apps.nightell.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.anahitavakoli.apps.nightell.R
import com.anahitavakoli.apps.nightell.model.Artist
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ArtistAdapter(mContext: Context, list : List<Artist>): RecyclerView.Adapter<ArtistAdapter.ArtistVH>() {

    val context = mContext
    val artistList = list

    class ArtistVH(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgArtist = itemView.findViewById<AppCompatImageView>(R.id.img_artist)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistVH {
        val view : View = LayoutInflater.from(context).inflate(R.layout.artist_item,null)
        return ArtistVH(view)
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

    override fun onBindViewHolder(holder: ArtistVH, position: Int) {
        val artist = artistList[position]
        Glide
            .with(context)
            .load(artist.artistImage)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.baseline_category_24)
            .into(holder.imgArtist);
    }
}