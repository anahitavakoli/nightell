package com.anahitavakoli.apps.nightell.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.anahitavakoli.apps.nightell.adapter.ArtistAdapter
import com.anahitavakoli.apps.nightell.adapter.AudioAdapter
import com.anahitavakoli.apps.nightell.network.ApiCaller
import com.anahitavakoli.apps.nightell.databinding.FragmentHomeBinding
import com.anahitavakoli.apps.nightell.model.ArtistList
import com.anahitavakoli.apps.nightell.model.IResponse
import com.anahitavakoli.apps.nightell.model.LatestAudio


class HomeFragment : Fragment() {

    var apiCaller: ApiCaller = ApiCaller()
    lateinit var binding : FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater)
        val view : View = binding.root

        apiCaller.getLatestStory(object : IResponse<LatestAudio>{
            override fun onSuccess(response: LatestAudio) {

                binding.recyclerLatestAudio.adapter = AudioAdapter(requireActivity(), response.latestAudio)
                binding.recyclerLatestAudio.layoutManager = LinearLayoutManager(requireContext(),
                LinearLayoutManager.HORIZONTAL,false)

            }

            override fun onFailure(errorResponse: String) {

            }

        })

        apiCaller.getArtists(object : IResponse<ArtistList>{
            override fun onSuccess(response: ArtistList) {
                binding.recyclerArtistList.adapter = ArtistAdapter(requireContext(), response.Artists)
                binding.recyclerArtistList.layoutManager = LinearLayoutManager(requireContext(),
                    LinearLayoutManager.HORIZONTAL,false)
            }

            override fun onFailure(errorResponse: String) {
                TODO("Not yet implemented")
            }

        })

        return view
    }


}