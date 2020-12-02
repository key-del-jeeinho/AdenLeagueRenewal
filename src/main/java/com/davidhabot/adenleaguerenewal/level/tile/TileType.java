package com.davidhabot.adenleaguerenewal.level.tile;

import lombok.Getter;

//게임내 존재하는 타일의 종류, 해당 타일종류의 식별자와 LevelImg 에서 표시되는 색상의 배열(한 종류더라도 서로 다른 타일이있으므로)을 담는다
public enum TileType {
    VOID(0, 0x000000),
    GRASS(1, 0x00FF00),
    DIRT(2, 0xCC9966),
    FLOWER(3, 0xFFFF00, 0xFF00FF),
    ROCK(4, 0x999999),
    STONE(5, 0x333333),
    OAK(6, 0x996633),
    OAK_HOLE(7, 0x663300),
    WATER(8, 0x0000FF);

    @Getter
    private final int id; //식별자
    @Getter
    private final int[] color; //표시색상

    TileType(int id, int... color) {
        this.id = id;
        this.color = color;
    }
}
