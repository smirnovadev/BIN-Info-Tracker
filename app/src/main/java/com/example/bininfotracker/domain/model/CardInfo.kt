package com.example.bininfotracker.domain.model

data class CardInfo(
    val countryName: String,
    val latitude: Double,
    val longitude: Double,
    val cardType: String,
    val bankName: String,
    val bankUrl: String,
    val bankPhone: String,
    val bankCity: String
)