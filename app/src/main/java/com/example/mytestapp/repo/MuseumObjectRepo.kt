package com.example.mytestapp.repo

import android.util.Log
import com.example.mytestapp.model.MuseumObjectIdList
import com.example.mytestapp.network.MetService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MuseumObjectRepo (val service: MetService, val objectIds: MuseumObjectIdList) {


//    fun getMuseumObjectIds(): IntArray? {
//        var objectsList: IntArray? = null
//        CoroutineScope(Dispatchers.IO).launch {
//            val response = service.fetchMuseumObjectIds()
//            response.body().let {
//                objectsList = it?.objectIds
//            }
//        }
//        return objectsList
//    }

    fun getMuseumObjectQuantity(): Int {

        return objectIds.total ?: 0
    }

}