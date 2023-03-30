package com.example.mytestapp.model

import com.google.gson.annotations.SerializedName

data class Department(
    @SerializedName("departmentId")
    val departmentId: Int,
    @SerializedName("displayName")
    val displayName: String
)
