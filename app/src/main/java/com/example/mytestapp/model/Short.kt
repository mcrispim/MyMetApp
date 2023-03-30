package com.example.mytestapp.model

import com.google.gson.annotations.SerializedName

data class Short(
    @SerializedName("objectId")
    val objectID: Int,
    @SerializedName("primaryImage")
    val primaryImage: String,
    @SerializedName("primaryImageSmall")
    val primaryImageSmall: String,
    @SerializedName("department")
    val department: String,
    @SerializedName("objectName")
    val objectName: String,
    @SerializedName("objectTitle")
    val objectTitle: String,
    @SerializedName("artistName")
    val artistName: String,
    @SerializedName("objectDate")
    val objectDate: String
)
