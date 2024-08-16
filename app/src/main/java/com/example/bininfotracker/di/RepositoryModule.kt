package com.example.bininfotracker.di

import com.example.bininfotracker.data.HistoryRepositoryImpl
import com.example.bininfotracker.data.SearchRepositoryImpl
import com.example.bininfotracker.domain.api.HistoryRepository
import com.example.bininfotracker.domain.api.SearchRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<SearchRepository> {
        SearchRepositoryImpl(get(), get())
    }
    single<HistoryRepository> {
        HistoryRepositoryImpl(get(), get())
    }
}