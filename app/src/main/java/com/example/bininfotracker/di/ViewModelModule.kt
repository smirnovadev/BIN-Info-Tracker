package com.example.bininfotracker.di

import com.example.bininfotracker.ui.CardInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<CardInfoViewModel> {
        CardInfoViewModel(get())
    }
}