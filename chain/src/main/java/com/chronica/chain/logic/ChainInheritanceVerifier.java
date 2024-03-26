package com.chronica.chain.logic;

import com.chronica.chain.entity.Chain;
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
        if (chain == null) {
            return;
        }

        if (chain.getType().getLevel() > chain.getBaseChain().getType().getLevel()) {
            throw new IllegalArgumentException();
        }

        if (visited.contains(chain)) {
            throw new IllegalArgumentException();
        }

        visited.add(chain);
        verifyInheritance(chain.getBaseChain(), visited);
    }
}
