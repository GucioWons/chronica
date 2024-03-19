package com.chronica.chain.logic;

import com.chronica.chain.entity.Chain;
import com.chronica.chain.repository.ChainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChainService {
    private final ChainRepository chainRepository;

    public Chain createChain(Chain chain) {
        return chainRepository.save(chain);
    }

    public Chain getChainById(Long chainId) {
        return chainRepository
                .findById(chainId)
                .orElseThrow(IllegalAccessError::new);
    }
}
