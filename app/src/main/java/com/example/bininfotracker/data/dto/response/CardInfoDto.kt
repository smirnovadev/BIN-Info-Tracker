package com.example.bininfotracker.data.dto.response

data class CardInfoDto(
    val country: Country,
    val scheme: String,
    val bank: Bank
) : Response()

data class Country(
    val name: String,
    val latitude: Int,
    val longitude: Int
)

data class Bank(
    val name: String,
    val url: String,
    val city: String,
    val phone: String
)