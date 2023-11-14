package com.anahitavakoli.apps.nightell.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.anahitavakoli.apps.nightell.R
import com.anahitavakoli.apps.nightell.activity.AudioPlayerActivity
import com.anahitavakoli.apps.nightell.customView.FarsiTextView
import com.anahitavakoli.apps.nightell.model.Audio
import com.bumptech.glide.Glide

class AudioAdapter(mContext : Context, list : List<Audio>) : RecyclerView.Adapter<AudioAdapter.AudioVH>() {

    private val context = mContext
    private val audioList = list

    class AudioVH(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgAudio: AppCompatImageView = itemView.findViewById(R.id.img_audio)
        val txtTrack: FarsiTextView = itemView.findViewById(R.id.txt_track)
        val cardTrack: CardView = itemView.findViewById(R.id.card_audio)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioVH {
        val view : View = LayoutInflater.from(context).inflate(R.layout.audio_track_item , null)
        return AudioVH(view)
    }

    override fun getItemCount(): Int {
        return audioList.size
    }

    override fun onBindViewHolder(holder: AudioVH, position: Int) {
        val audio = audioList[position]
        holder.txtTrack.text = audio.mp3Title
        Glide
            .with(context)
            .load(audio.mp3ThumbnailB)
            .centerCrop()
            .placeholder(R.drawable.baseline_category_24)
            .into(holder.imgAudio);

        holder.cardTrack.setOnClickListener{
            val intent = Intent(context,AudioPlayerActivity::class.java)
            intent.putExtra("audio", audio)
            context.startActivity(intent)
        }
    }
}