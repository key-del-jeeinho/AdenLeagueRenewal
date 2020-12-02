package com.davidhabot.adenleaguerenewal.level.tile;

import com.davidhabot.adenleaguerenewal.graphics.Sprite;

public class StoneTile extends Tile {
    public StoneTile(Sprite sprite, int idx) {
        super(sprite, TileType.STONE.getColor()[idx]);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

    @Override
    public int getId() {
        return TileType.STONE.getId();
    }
}
