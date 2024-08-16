package com.example.bininfotracker.domain.model

data class CardInfo(
    val scheme: String?,
    val countryName: String?,
    val latitude: Int?,
    val longitude: Int?,
    val bankName: String?,
    val bankUrl: String?,
    val bankPhone: String?,
    val bankCity: String?
)