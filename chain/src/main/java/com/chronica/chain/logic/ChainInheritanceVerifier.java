package com.chronica.chain.logic;

import com.chronica.chain.entity.Chain;
import com.chronica.chain.exception.InheritanceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ChainInheritanceVerifier {
    public void verifyInheritance(Chain chain) {
        verifyInheritance(chain, new HashSet<>());
    }

    private void verifyInheritance(Chain chain, Set<Chain> visited) {
        if (chain.getBaseChain() == null) {
            return;
        }

        if (chain.getChainType().getLevel() <= chain.getBaseChain().getChainType().getLevel()) {
            throw new InheritanceException("");
        }

        if (visited.contains(chain)) {
            throw new InheritanceException("");
        }

        visited.add(chain);
        verifyInheritance(chain.getBaseChain(), visited);
    }
}
