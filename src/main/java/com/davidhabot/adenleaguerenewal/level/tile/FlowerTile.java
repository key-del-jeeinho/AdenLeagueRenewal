package com.davidhabot.adenleaguerenewal.level.tile;

import com.davidhabot.adenleaguerenewal.graphics.Sprite;

public class FlowerTile extends Tile {
    public FlowerTile(Sprite sprite, int idx) {
        super(sprite, TileType.FLOWER.getColor()[idx]);
    }

    @Override
    public boolean isSolid() {
        return false;
    }

    @Override
    public int getId() {
        return TileType.FLOWER.getId();
    }
}
