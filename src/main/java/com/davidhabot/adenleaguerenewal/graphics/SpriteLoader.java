package com.davidhabot.adenleaguerenewal.graphics;

import java.awt.*;

public class SpriteLoader {
    public SpriteSheet tile_naturalA;
    public SpriteSheet character_player_move;

    public Sprite voidTile, grass, flowerA, flowerB, rock, stone, stone_jewel, oak, oak_hole, dirt, water
            , player;

    public SpriteLoader() {
        loadSheet();
        loadSprite();
    }

    public void loadSheet() {
        tile_naturalA = new SpriteSheet("/texture/spritesheet.png", 16, 16, 16);
        character_player_move= new SpriteSheet("/texture/character_player.png", 32, 3, 3);
    }

    private void loadSprite() {
        voidTile = new Sprite(16, new Color(0x1B, 0x87, 0xE0));

        grass = new Sprite(16, 0, 0, tile_naturalA);
        flowerA = new Sprite(16, 1, 0, tile_naturalA);
        flowerB = new Sprite(16, 2, 0, tile_naturalA);
        rock = new Sprite(16, 3, 0, tile_naturalA);

        stone = new Sprite(16, 0, 1, tile_naturalA);
        stone_jewel = new Sprite(16, 1, 1, tile_naturalA);

        oak = new Sprite(16, 0, 2, tile_naturalA);
        oak_hole = new Sprite(16, 1, 2, tile_naturalA);
        dirt = new Sprite(16, 2, 2, tile_naturalA);

        water = new Sprite(16, 0, 3, tile_naturalA);

        player = new Sprite(32, 2, 0, character_player_move);
    }
}
