package com.chronica.chain.dto;

import com.chronica.chain.enumerated.ChainType;

public record BaseChainDTO(Long id, String title, ChainType type) {
}
