package com.davidhabot.adenleaguerenewal.level;

import com.davidhabot.adenleaguerenewal.game.Updatable;
import com.davidhabot.adenleaguerenewal.graphics.Renderable;
import com.davidhabot.adenleaguerenewal.level.tile.Tile;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public abstract class Level implements Renderable, Updatable {
    protected int tileWidth;
    protected int tileHeight;
    protected int x, y; //플레이어의 이동에 따라 맵을 이동시키기 위한 맵의 좌측상단 모서리 좌표값
    protected int[] level;
    @Getter @Setter
    private int width, height;

    private Level(int x, int y) {
        tileWidth = 16;
        tileHeight = 16;
        this.x = x;
        this.y = y;
    }

    public Level(Dimension size) {
        this(0, 0);
        this.width = size.width;
        this.height = size.height;
        generateLevel();
    }

    public Level(String path) {
        this(0, 0);
        loadLevel(path);
        tileWidth = getTile(0, 0).getSprite().getWidth();
        tileHeight = getTile(0, 0).getSprite().getWidth();
        generateLevel();
    }

    protected abstract void loadLevel(String path);
    protected abstract void generateLevel();
    public abstract Tile getTile(int x, int y);

    public void setOffset(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
