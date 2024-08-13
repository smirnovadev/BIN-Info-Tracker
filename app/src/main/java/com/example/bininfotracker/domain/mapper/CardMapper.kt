package com.example.bininfotracker.domain.mapper

import com.example.bininfotracker.data.dto.response.CardInfoDto
import com.example.bininfotracker.domain.model.CardInfo

class CardMapper {
    fun map(dto: CardInfoDto) : CardInfo {
        return CardInfo(
            countryName = dto.countryName,
            latitude = dto.latitude,
            longitude = dto.longitude,
            cardType = dto.cardType,
            bankName = dto.bankName,
            bankUrl = dto.bankUrl,
            bankPhone = dto.bankPhone,
            bankCity = dto.bankCity


        )
    }
}