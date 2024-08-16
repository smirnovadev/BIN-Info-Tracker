package com.example.bininfotracker.di

import com.example.bininfotracker.domain.api.HistoryCardInfoInteractor
import com.example.bininfotracker.domain.api.SearchCardInfoInteractor
import com.example.bininfotracker.domain.impl.HistoryCardInfoInteractorImpl
import com.example.bininfotracker.domain.impl.SearchCardInfoInteractorImpl
import org.koin.dsl.module

val interactorModule = module {
    single<SearchCardInfoInteractor> {
        SearchCardInfoInteractorImpl(get())
    }
    single<HistoryCardInfoInteractor> {
        HistoryCardInfoInteractorImpl(get())
    }
}