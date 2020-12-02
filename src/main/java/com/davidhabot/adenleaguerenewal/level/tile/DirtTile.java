package com.davidhabot.adenleaguerenewal.level.tile;

import com.davidhabot.adenleaguerenewal.graphics.Sprite;

public class DirtTile extends Tile {
    public DirtTile(Sprite sprite, int idx) {
        super(sprite, TileType.DIRT.getColor()[idx]);
    }

    @Override
    public boolean isSolid() {
        return false;
    }

    @Override
    public int getId() {
        return TileType.DIRT.getId();
    }
}
