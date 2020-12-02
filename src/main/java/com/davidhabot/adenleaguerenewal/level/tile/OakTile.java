package com.davidhabot.adenleaguerenewal.level.tile;

import com.davidhabot.adenleaguerenewal.graphics.Sprite;

public class OakTile extends Tile {
    public OakTile(Sprite sprite, int idx) {
        super(sprite, TileType.OAK.getColor()[idx]);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

    @Override
    public int getId() {
        return TileType.OAK.getId();
    }
}
