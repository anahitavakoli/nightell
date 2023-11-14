package com.anahitavakoli.apps.nightell.ui.category

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.anahitavakoli.apps.nightell.adapter.CategoryAdapter
import com.anahitavakoli.apps.nightell.databinding.FragmentCategoryBinding
import com.anahitavakoli.apps.nightell.model.CategoryList
import com.anahitavakoli.apps.nightell.viewmodels.CategoryViewModel

class CategoryFragment : Fragment() {

    lateinit var binding : FragmentCategoryBinding
    lateinit var owner : LifecycleOwner
    lateinit var viewModel : CategoryViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.owner = this
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)

        viewModel.categoryList().observe(owner , Observer<CategoryList>{

            binding.constraintCat.visibility = View.VISIBLE
            binding.progressbar.visibility = View.GONE

            binding.recyclerCategory.adapter = CategoryAdapter(requireContext(), it.categories)
                binding.recyclerCategory.layoutManager = LinearLayoutManager(requireContext(),
                    LinearLayoutManager.HORIZONTAL,false)
        })

        return binding.root
    }

}