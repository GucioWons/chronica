package com.chronica.chain.dto;

import com.chronica.chain.enumerated.ChainType;

import java.math.BigDecimal;

public record ChainDTO(
        Long id,
        String title,
        String description,
        ChainType type,
        BigDecimal estimation,
        BigDecimal timeLeft,
        Integer points,
        boolean deprecated) {

}
