package com.davidhabot.adenleaguerenewal.entity;

import lombok.Getter;

public enum PlayerSpriteSet {
    STAND_UP(0),
    STAND_RIGHT(1),
    STAND_DOWN(2),
    STAND_LEFT(3),

    MOVE_UP(4, 5),
    MOVE_RIGHT(6, 7),
    MOVE_DOWN(8, 9),
    MOVE_LEFT(10, 11);

    @Getter
    private final int[] idx;


    PlayerSpriteSet(int... idx) {
        this.idx = idx;
    }
    PlayerSpriteSet() {
        int[] prevIdx = PlayerSpriteSet.values()[this.ordinal() - 1].getIdx();
        this.idx = new int[prevIdx[prevIdx.length -1 ]];
    }
}
