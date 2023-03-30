package com.example.mytestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytestapp.databinding.ActivityMainBinding
import com.example.mytestapp.model.MuseumObjectIdList
import com.example.mytestapp.network.MetService
import com.example.mytestapp.network.RetrofitInitializer
import com.example.mytestapp.network.RetrofitInstance
import com.example.mytestapp.repo.MuseumObjectRepo
import com.example.mytestapp.view.ObjectAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import retrofit2.http.Query

const val TAG = "MainActivity"

// https://www.youtube.com/watch?v=t6Sql3WMAnk&t=3s
// https://github.com/philipplackner/RetrofitCrashCourse/blob/master/app/src/main/java/com/plcoding/retrofitcrashcourse/MainActivity.kt
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var objectAdapter: ObjectAdapter
    lateinit var service: MetService
    lateinit var repo: MuseumObjectRepo
    lateinit var objectIds: MuseumObjectIdList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()

        lifecycleScope.launchWhenCreated {
            binding.progressBar.isVisible = true
            val response = try {
                RetrofitInstance.api.fetchMuseumObjectIdsByDepto(6) // Asian Art
            } catch(e: IOException) {
                Log.e(TAG, "IOException, you might not have internet connection")
                binding.progressBar.isVisible = false
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException, unexpected response")
                binding.progressBar.isVisible = false
                return@launchWhenCreated
            }
            if(response.isSuccessful && response.body() != null) {
                objectAdapter.museumObjectIds = response.body()!!.objectIds
            } else {
                Log.e(TAG, "Response not successful")
            }
            binding.progressBar.isVisible = false
        }
//        service = RetrofitInitializer().metService()
//        CoroutineScope(Dispatchers.IO).launch {
//            val response = service.fetchMuseumObjectIds()
//            objectIds = response.body()!!
//        }
//
//        repo = MuseumObjectRepo(service, objectIds)
//
//
//        val quantityOfObjects = repo.getMuseumObjectQuantity()
//        binding.myText.text = "Número de objetos: $quantityOfObjects"
//        val a = 3
    }

    private fun setupRecyclerView() = binding.rvObjects.apply {
        objectAdapter = ObjectAdapter()
        adapter = objectAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }
}