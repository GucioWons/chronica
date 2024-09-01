package org.chronica.library.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ChainType {
    EPIC(0),
    STORY(1),
    TASK(2),
    BUG(2);

    private final Integer level;
}
