package com.chronica.chain.dto;

import com.chronica.chain.enumerated.ChainType;

import java.util.List;

public record ChildChainDTO(Long id, String title, ChainType type, List<ChildChainDTO> childChains) {

}
