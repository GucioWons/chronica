package com.chronica.chain.logic;

import com.chronica.chain.entity.Chain;
import lombok.RequiredArgsConstructor;
import org.chronica.library.exception.ChronicaException;
import org.chronica.library.exception.dto.enumerated.ErrorMessage;
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
            throw new ChronicaException(ErrorMessage.INHERITANCE_LEVEL_EXCEPTION);
        }

        if (visited.contains(chain)) {
            throw new ChronicaException(ErrorMessage.INHERITANCE_LOOP_EXCEPTION);
        }

        visited.add(chain);
        verifyInheritance(chain.getBaseChain(), visited);
    }
}
