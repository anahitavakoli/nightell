package com.anahitavakoli.apps.nightell.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.anahitavakoli.apps.nightell.adapter.AudioAdapter
import com.anahitavakoli.apps.nightell.database.Database
import com.anahitavakoli.apps.nightell.databinding.FragmentFavoriteBinding
import com.anahitavakoli.apps.nightell.model.Audio

class FavoriteFragment : Fragment() {

    lateinit var binding : FragmentFavoriteBinding
    lateinit var audioList : List<Audio>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFavoriteBinding.inflate(layoutInflater)
        val view : View = binding.root
        return view
    }

    override fun onResume() {
        super.onResume()
        audioList = Database.db.favoriteDao().showFavorites()
        binding.reyclerFavorite.adapter = AudioAdapter(requireContext(),audioList)
        binding.reyclerFavorite.layoutManager = GridLayoutManager(requireContext(),2)
    }

}