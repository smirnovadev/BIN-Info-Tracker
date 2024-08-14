package com.example.bininfotracker.domain.model

data class CardInfo(
    val scheme: String?,
    val countryName: String?,
    val latitude: Long?,
    val longitude: Long?,
    val bankName: String?,
    val bankUrl: String?,
    val bankPhone: String?,
    val bankCity: String?
)