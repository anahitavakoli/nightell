package com.anahitavakoli.apps.nightell.model

interface IResponse<T> {

    fun onSuccess(response: T)
    fun onFailure(errorResponse: String)

}