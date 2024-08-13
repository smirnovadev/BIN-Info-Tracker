package com.example.bininfotracker.data.dto.response

data class CardInfoDto(
    val countryName: String,
    val latitude: Double,
    val longitude: Double,
    val cardType: String,
    val bankName: String,
    val bankUrl: String,
    val bankPhone: String,
    val bankCity: String
): Response()