package com.example.bininfotracker.di

import com.example.bininfotracker.data.NetWorkClient
import com.example.bininfotracker.data.network.BnlistApi
import com.example.bininfotracker.data.network.RetrofitNetworkClient
import com.example.bininfotracker.domain.mapper.CardMapper
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single<BnlistApi> {
        Retrofit.Builder()
            .baseUrl("https://lookup.binlist.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BnlistApi::class.java)
    }

    single<NetWorkClient> { RetrofitNetworkClient(get()) }

    single<CardMapper> {
        CardMapper()
    }

}