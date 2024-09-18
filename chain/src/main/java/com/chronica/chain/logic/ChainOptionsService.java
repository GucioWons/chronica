package com.chronica.chain.logic;

import com.chronica.chain.mapper.ChainSelectMapper;
import com.chronica.chain.repository.ChainRepository;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.chain.ChainSelectDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChainOptionsService {
    private final ChainRepository chainRepository;
    private final ChainSelectMapper chainSelectMapper;

    public List<ChainSelectDTO> getChainSelects() {
        return chainRepository
                .findAll()
                .stream()
                .map(chainSelectMapper::mapToChainSelectDTO)
                .toList();
    }
}
