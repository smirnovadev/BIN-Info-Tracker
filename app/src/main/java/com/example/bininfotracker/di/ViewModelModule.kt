package com.example.bininfotracker.di

import com.example.bininfotracker.ui.HistoryViewModel
import com.example.bininfotracker.ui.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.dsl.module

val viewModelModule = module {
    viewModel<SearchViewModel> {
        SearchViewModel(get(), get())
    }

    viewModel<HistoryViewModel> {
        HistoryViewModel(get())
    }
}