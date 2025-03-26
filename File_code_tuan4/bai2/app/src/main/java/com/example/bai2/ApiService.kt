package com.example.bai2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("tasks")
    fun getTodos(): Call<ApiResponse>

    @GET("task/{id}")
    fun getTodoById(@Path("id") id: Int): Call<ListItem>  // Thêm API lấy chi tiết
}

