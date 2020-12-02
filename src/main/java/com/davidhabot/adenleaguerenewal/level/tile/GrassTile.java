package com.davidhabot.adenleaguerenewal.level.tile;

import com.davidhabot.adenleaguerenewal.graphics.Sprite;

public class GrassTile extends Tile{
    public GrassTile(Sprite sprite, int idx) {
        super(sprite, TileType.GRASS.getColor()[idx]);
    }

    @Override
    public boolean isSolid() {
        return false;
    }

    @Override
    public int getId() {
        return TileType.GRASS.getId();
    }
}
