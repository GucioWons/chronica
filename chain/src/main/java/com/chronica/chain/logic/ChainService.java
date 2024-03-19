package com.chronica.chain.logic;

import com.chronica.chain.dto.ChainDTO;
import com.chronica.chain.mapper.ChainMapper;
import com.chronica.chain.repository.ChainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChainService {
    private final ChainRepository chainRepository;
    private final ChainMapper chainMapper;

    public ChainDTO createChain(ChainDTO chain) {
        return chainMapper.mapToDTO(chainRepository.save(chainMapper.mapToEntity(chain)));
    }

    public ChainDTO getChainById(Long chainId) {
        return chainRepository
                .findById(chainId)
                .map(chainMapper::mapToDTO)
                .orElseThrow(IllegalAccessError::new);
    }
}
