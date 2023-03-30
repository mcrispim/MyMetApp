package com.example.mytestapp.network

import com.example.mytestapp.model.Department
import com.example.mytestapp.model.MuseumObject
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MetService {

    @GET("objects/{objectID}")
    fun getMuseumObject(@Path("objectId") objectId: Int): MuseumObject

    @GET("departments")
    fun getDepartments(): List<Department>

    @GET("objects")
    fun getMuseumObjectIdsByDepto(@Query("departmentIds") deptoId: Int): List<Int>

    @GET("objects")
    fun getMuseumObjectIds(): List<Int>
}
