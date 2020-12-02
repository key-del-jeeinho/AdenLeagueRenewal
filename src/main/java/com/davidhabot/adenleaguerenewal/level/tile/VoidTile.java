package com.davidhabot.adenleaguerenewal.level.tile;

import com.davidhabot.adenleaguerenewal.graphics.Sprite;

public class VoidTile extends Tile {
    public VoidTile(Sprite sprite, int idx) {
        super(sprite, TileType.VOID.getColor()[idx]);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

    @Override
    public int getId() {
        return TileType.VOID.getId();
    }
}
