package com.example.cobatokped.core.di

import com.example.cobatokped.core.data.source.local.LocalDataSource
import com.example.cobatokped.core.data.source.remote.RemoteDataSource
import com.example.cobatokped.core.data.source.remote.network.ApiConfig
import org.koin.dsl.module

val appModule = module {
    single { ApiConfig.provideApiService }
    single { RemoteDataSource(get()) }
    single { LocalDataSource() }

}