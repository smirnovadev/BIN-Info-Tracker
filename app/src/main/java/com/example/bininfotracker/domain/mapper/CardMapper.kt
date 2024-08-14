package com.example.bininfotracker.domain.mapper

import com.example.bininfotracker.data.dto.response.CardInfoDto
import com.example.bininfotracker.domain.model.CardInfo

class CardMapper {
    fun map(dto: CardInfoDto) : CardInfo {
        return CardInfo(
            countryName = dto.country.name,
            latitude = dto.country.latitude,
            longitude = dto.country.longitude,
            scheme = dto.scheme,
            bankName = dto.bank.name,
            bankUrl = dto.bank.url,
            bankPhone = dto.bank.phone,
            bankCity = dto.bank.city
        )
    }
}