package com.davidhabot.adenleaguerenewal.level.tile;

import com.davidhabot.adenleaguerenewal.graphics.Sprite;

public class WaterTile extends Tile {
    public WaterTile(Sprite sprite, int idx) {
        super(sprite, TileType.WATER.getColor()[idx]);
    }

    @Override
    public boolean isSolid() {
        return false;
    }

    @Override
    public int getId() {
        return TileType.WATER.getId();
    }
}
