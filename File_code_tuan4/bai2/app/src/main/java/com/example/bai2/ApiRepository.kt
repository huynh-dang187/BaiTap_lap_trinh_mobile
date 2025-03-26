package com.example.bai2

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiRepository {
    fun fetchTasks(onResult: (List<ListItem>?) -> Unit) {
        RetrofitClient.instance.getTodos().enqueue(object : Callback<ApiResponse> {
            override fun onResponse(
                call: Call<ApiResponse>,
                response: Response<ApiResponse>
            ) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()
                    Log.d("API_RESPONSE", "Dữ liệu API: ${apiResponse?.data}")
                    onResult(apiResponse?.data) // Trả về danh sách ListItem
                } else {
                    Log.e("API_ERROR", "Lỗi response: ${response.errorBody()?.string()}")
                    onResult(null)
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e("API_ERROR", "Lỗi kết nối API: ${t.message}")
                onResult(null)
            }
        })
    }

    fun getTodoById(id: Int, onResult: (ListItem?) -> Unit) {
        RetrofitClient.instance.getTodoById(id).enqueue(object : Callback<ListItem> {
            override fun onResponse(call: Call<ListItem>, response: Response<ListItem>) {
                if (response.isSuccessful) {
                    onResult(response.body())
                } else {
                    Log.e("API_ERROR", "Lỗi response: ${response.errorBody()?.string()}")
                    onResult(null)
                }
            }

            override fun onFailure(call: Call<ListItem>, t: Throwable) {
                Log.e("API_ERROR", "Lỗi kết nối API: ${t.message}")
                onResult(null)
            }
        })
    }
}