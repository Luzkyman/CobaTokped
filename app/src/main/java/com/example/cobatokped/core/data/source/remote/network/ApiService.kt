package com.example.cobatokped.core.data.source.remote.network

import android.provider.ContactsContract.CommonDataKinds.Email
import com.example.cobatokped.core.data.source.remote.request.LoginRequest
import com.example.cobatokped.core.data.source.remote.response.LoginResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("login")
    suspend fun login(
        @Body login: LoginRequest,
//    @Field("email") email: String,
//    @Field("password") password: String,

    ): Response<LoginResponse>

    // "http://127.0.0.1:8000/api/register"
    @POST("register")
    suspend fun register(
        //@Body user: User
    ): Response<RequestBody>

}