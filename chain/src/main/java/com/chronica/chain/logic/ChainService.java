package com.chronica.chain.logic;

import com.chronica.chain.entity.Chain;
import com.chronica.chain.exception.NoChainException;
import com.chronica.chain.mapper.ChainMapper;
import com.chronica.chain.repository.ChainRepository;
import lombok.RequiredArgsConstructor;
import org.chronica.library.dto.chain.ChainDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChainService {
    private final ChainRepository chainRepository;
    private final ChainMapper chainMapper;
    private final ChainInheritanceVerifier chainInheritanceVerifier;

    public ChainDTO createChain(ChainDTO chain) {
        Chain toSave = chainMapper.mapToNewEntity(chain);
        chainInheritanceVerifier.verifyInheritance(toSave);
        return chainMapper.mapToDTO(
                chainRepository.save(toSave));
    }

    public ChainDTO getChainById(Long chainId) {
        return chainRepository
                .findByIdAndDeprecatedFalse(chainId)
                .map(chainMapper::mapToDTO)
                .orElseThrow(() -> new NoChainException("Cannot find Chain with id" + chainId));
    }

    public List<ChainDTO> getChains() {
        return chainRepository
                .findAll()
                .stream()
                .map(chainMapper::mapToDTO)
                .toList();
    }

    public ChainDTO updateChainById(Long chainId, ChainDTO chainDto) {
        return chainRepository
                .findByIdAndDeprecatedFalse(chainId)
                .map(chain ->
                        chainMapper.mapToDTO(
                                chainRepository.save(
                                        chainMapper.mapToUpdateEntity(chain, chainDto))))
                .orElseThrow(() -> new NoChainException("Cannot find Chain with id" + chainId));
    }

    public String deleteChainById(Long chainId) {
        return chainRepository
                .findByIdAndDeprecatedFalse(chainId)
                .map(this::handleDeprecation)
                .orElseThrow(() -> new NoChainException("Cannot find Chain with id" + chainId));
    }

    private String handleDeprecation(Chain chain) {
        chain.setBaseChain(null);
        chain.getChildChains().clear();
        chain.setDeprecated(true);
        chainRepository.save(chain);
        return "Chain has been deprecated.";
    }
}
