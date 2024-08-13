package com.example.bininfotracker.di

import com.example.bininfotracker.data.BinlistRepositoryImpl
import com.example.bininfotracker.domain.api.BinlistRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<BinlistRepository> {
        BinlistRepositoryImpl(get(), get())
    }
}