package com.example.cobatokped.core.di

import com.example.cobatokped.core.data.repository.AppRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { AppRepository(get(),get()) }
}