package com.thekalya.instantnews.ui.source

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thekalya.instantnews.GeneralResponse
import com.thekalya.instantnews.data.Category
import com.thekalya.instantnews.network.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SourceViewModel : ViewModel() {
    private val response = MutableLiveData<GeneralResponse>()
    var categoryList = MutableLiveData<List<Category>>()
    private val disposable = CompositeDisposable()

    private val client by lazy {
        ApiClient.getClient()
    }


    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        disposable.add(client.getArticlesSource("technology")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {result ->
                    response.value = GeneralResponse.SUCCESS
                    categoryList.value = result.sources
                },
                {
                    this::onError
                    response.value = GeneralResponse.ERROR
                }
            ))

    }

    private fun onError(e: Throwable){
        e.printStackTrace()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("SourceViewModel", "SourceViewModel is cleared")
    }
}