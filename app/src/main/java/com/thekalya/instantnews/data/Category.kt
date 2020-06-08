package com.thekalya.instantnews.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Enock on 6/8/20.
 */
data class Category(
    @SerializedName("category")
    var category: String,
    @SerializedName("country")
    var country: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("language")
    var language: String, // en
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
): Serializable
