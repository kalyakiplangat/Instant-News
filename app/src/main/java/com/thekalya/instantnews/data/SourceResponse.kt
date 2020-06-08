package com.thekalya.instantnews.data

import com.google.gson.annotations.SerializedName


data class SourceResponse(
    @SerializedName("sources")
    var sources: List<Category>,
    @SerializedName("status")
    var status: String // ok
)