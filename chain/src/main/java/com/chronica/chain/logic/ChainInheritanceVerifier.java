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

        if (chain.getType().getLevel() <= chain.getBaseChain().getType().getLevel()) {
            throw new InheritanceException("Chain cannot be Base Chain of Chain with the same or lower type.");
        }

        if (visited.contains(chain)) {
            throw new InheritanceException("Chains inheritance cannot be looped.");
        }

        visited.add(chain);
        verifyInheritance(chain.getBaseChain(), visited);
    }
}
