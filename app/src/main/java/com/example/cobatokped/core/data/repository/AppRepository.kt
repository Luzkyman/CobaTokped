package com.example.cobatokped.core.data.repository

import android.util.Log
import com.example.cobatokped.core.data.source.local.LocalDataSource
import com.example.cobatokped.core.data.source.remote.RemoteDataSource
import com.example.cobatokped.core.data.source.remote.request.LoginRequest
import kotlinx.coroutines.flow.flow
import com.inyongtisto.myhelper.extension.logs
import java.lang.Exception

class AppRepository (val local:LocalDataSource, val remote:RemoteDataSource) {

    fun login (data:LoginRequest) = flow {
        try {
            remote.login(data).let {
                if(it.isSuccessful){
                    val body = it.body()
                    emit(body)
                    logs("success:"+ body.toString())
                } else {
                    logs("Error:"+" keterangan error")
                }
            }
        } catch (e:Exception){
            logs("login: error yang di handle:" + e.message)
        }
    }

}