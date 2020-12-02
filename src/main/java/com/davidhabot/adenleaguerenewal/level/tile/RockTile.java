package com.davidhabot.adenleaguerenewal.level.tile;

import com.davidhabot.adenleaguerenewal.graphics.Sprite;

public class RockTile extends Tile {
    public RockTile(Sprite sprite, int idx) {
        super(sprite, TileType.ROCK.getColor()[idx]);
    }

    @Override
    public boolean isSolid() {
        return false;
    }

    @Override
    public int getId() {
        return TileType.ROCK.getId();
    }
}
