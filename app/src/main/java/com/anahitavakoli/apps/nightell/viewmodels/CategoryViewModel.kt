package com.anahitavakoli.apps.nightell.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anahitavakoli.apps.nightell.model.CategoryList
import com.anahitavakoli.apps.nightell.repository.CategoryRepository


class CategoryViewModel: ViewModel() {

    private val repository = CategoryRepository.instance

    fun categoryList() : MutableLiveData<CategoryList> = repository.showCategoryList()

}