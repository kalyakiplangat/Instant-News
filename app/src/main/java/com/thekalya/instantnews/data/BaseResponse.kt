package com.thekalya.instantnews.data

import com.google.gson.annotations.SerializedName


/**
 * Created by Enock on 2/24/20.
 */
data class BaseResponse(
    @SerializedName("articles")
    var articles: List<Articles>,
    @SerializedName("status")
    var status: String, // ok
    @SerializedName("totalResults")
    var totalResults: Int // 4855
)