package com.chronica.chain.logic;

import com.chronica.chain.dto.ChainDTO;
import com.chronica.chain.entity.Chain;
import com.chronica.chain.mapper.ChainMapper;
import com.chronica.chain.repository.ChainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChainService {
    private final ChainRepository chainRepository;
    private final ChainMapper chainMapper;
    private final ChainInheritanceVerifier chainInheritanceVerifier;

    public ChainDTO createChain(ChainDTO chain) {
        Chain toSave = chainMapper.mapToEntity(chain);
        chainInheritanceVerifier.verifyInheritance(toSave);
        return chainMapper.mapToDTO(
                chainRepository.save(toSave));
    }

    public ChainDTO getChainById(Long chainId) {
        return chainRepository
                .findByIdAndDeprecatedFalse(chainId)
                .map(chainMapper::mapToDTO)
                .orElseThrow(IllegalAccessError::new);
    }

    public ChainDTO updateChainById(Long chainId, ChainDTO chainDto) {
        return chainRepository
                .findByIdAndDeprecatedFalse(chainId)
                .map(chain -> chainMapper.mapToDTO(
                        chainRepository.save(
                        chainMapper.mapToUpdateEntity(chain, chainDto))))
                .orElseThrow(IllegalArgumentException::new);
    }

    public String deleteChainById(Long chainId) {
        return chainRepository
                .findByIdAndDeprecatedFalse(chainId)
                .map(this::handleDeprecation)
                .orElseThrow();
    }

    private String handleDeprecation(Chain chain) {
        chain.setBaseChain(null);
        chain.setChildChains(null);
        chain.setDeprecated(true);
        return "Chain has been deprecated.";
    }
}
