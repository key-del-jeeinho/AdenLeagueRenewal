package com.davidhabot.adenleaguerenewal.level.tile;

import com.davidhabot.adenleaguerenewal.graphics.Sprite;

public class OakHoleTile extends Tile {
    public OakHoleTile(Sprite sprite, int idx) {
        super(sprite, TileType.OAK_HOLE.getColor()[idx]);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

    @Override
    public int getId() {
        return TileType.OAK_HOLE.getId();
    }
}
