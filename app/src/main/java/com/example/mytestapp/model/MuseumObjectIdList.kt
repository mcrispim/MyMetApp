package com.example.mytestapp.model

import com.google.gson.annotations.SerializedName

data class MuseumObjectIdList(
    @SerializedName("total")
    val total: Int,
    @SerializedName("objectIds")
    val objectIds: List<Int>
)