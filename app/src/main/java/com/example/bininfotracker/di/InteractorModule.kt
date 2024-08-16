package com.example.bininfotracker.di

import com.example.bininfotracker.domain.api.HistoryInteractor
import com.example.bininfotracker.domain.api.SearchInteractor
import com.example.bininfotracker.domain.impl.HistoryInteractorImpl
import com.example.bininfotracker.domain.impl.SearchInteractorImpl
import org.koin.dsl.module

val interactorModule = module {
    single<SearchInteractor> {
        SearchInteractorImpl(get())
    }
    single<HistoryInteractor> {
        HistoryInteractorImpl(get())
    }
}