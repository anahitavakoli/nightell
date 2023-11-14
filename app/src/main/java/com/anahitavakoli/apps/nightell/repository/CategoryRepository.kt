package com.anahitavakoli.apps.nightell.repository

import androidx.lifecycle.MutableLiveData
import com.anahitavakoli.apps.nightell.network.ApiService
import com.anahitavakoli.apps.nightell.network.IService
import com.anahitavakoli.apps.nightell.model.CategoryList
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CategoryRepository {

    private var categoryList = MutableLiveData<CategoryList>()

    companion object {
        val instance = CategoryRepository()
    }


    fun showCategoryList() : MutableLiveData<CategoryList> {

        var iService: IService = ApiService.retrofit.create(IService::class.java)

        GlobalScope.launch {
            val result = iService.getCategories()
            if (result.body() != null) {
                categoryList.postValue(result.body())
            }
        }

        return categoryList
    }
}