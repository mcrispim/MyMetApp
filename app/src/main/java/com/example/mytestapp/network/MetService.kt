package com.example.mytestapp.network

import com.example.mytestapp.model.Department
import com.example.mytestapp.model.Short
import com.example.mytestapp.model.MuseumObjectIdList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MetService {

    @GET("objects/{objectID}")
    suspend fun fetchMuseumObject(@Path("objectId") objectId: Int): Response<Short>

    @GET("departments")
    suspend fun fetchDepartments(): Response<List<Department>>

    @GET("objects")
    suspend fun fetchMuseumObjectIdsByDepto(@Query("departmentIds") deptoId: Int): Response<MuseumObjectIdList>

    @GET("objects")
    suspend fun fetchMuseumObjectIds(): Response<MuseumObjectIdList>

}
