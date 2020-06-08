package com.thekalya.instantnews.network

import com.thekalya.instantnews.data.BaseResponse
import com.thekalya.instantnews.data.SourceResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("everything")
    fun getALlArticles(
        @Query("q") query: String
    ): Observable<BaseResponse>

    @GET("everything")
    fun getArticlesInCategory(
        @Query("domains") domains: String,
        @Query("q") query: String
    ): Observable<BaseResponse>

    @GET("sources")
    fun getArticlesSource(
        @Query("category") category: String
    ): Observable<SourceResponse>

}