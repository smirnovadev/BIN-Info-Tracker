package com.example.bininfotracker.di

import com.example.bininfotracker.data.HistoryCardInfoRepositoryImpl
import com.example.bininfotracker.data.SearchCardInfoRepositoryImpl
import com.example.bininfotracker.domain.api.HistoryCardInfoRepository
import com.example.bininfotracker.domain.api.SearchCardInfoRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<SearchCardInfoRepository> {
        SearchCardInfoRepositoryImpl(get(), get())
    }
    single<HistoryCardInfoRepository> {
        HistoryCardInfoRepositoryImpl(get(), get())
    }

}