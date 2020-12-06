package com.davidhabot.adenleaguerenewal.graphics;

import java.awt.*;

public class SpriteLoader {
    public SpriteSheet tile_naturalA;
    public SpriteSheet character_player_move;
    public SpriteSheet entity_shadow;

    public Sprite voidTile;
    public Sprite grass;
    public Sprite flowerA;
    public Sprite flowerB;
    public Sprite rock;
    public Sprite stone;
    public Sprite stone_jewel;
    public Sprite oak;
    public Sprite oak_hole;
    public Sprite dirt;
    public Sprite water;
    public Sprite shadow;
    public Sprite[] player;

    public SpriteLoader() {
        loadSheet();
        loadSprite();
    }

    public void loadSheet() {
        tile_naturalA = new SpriteSheet("/texture/spritesheet.png", 16, 16, 16);
        character_player_move= new SpriteSheet("/texture/character_player.png", 32, 4, 3);
        entity_shadow= new SpriteSheet("/texture/shadow.png", 16, 2, 1);
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

        //TODO 2020-12-06 09:12 AM | for 문을 통해서 자동화 | DavidHabot
        player = new Sprite[]{
                new Sprite(32, 0, 0, character_player_move),
                new Sprite(32, 1, 0, character_player_move),
                new Sprite(32, 2, 0, character_player_move),
                new Sprite(32, 3, 0, character_player_move),
                new Sprite(32, 0, 1, character_player_move),
                new Sprite(32, 0, 2, character_player_move),
                new Sprite(32, 1, 1, character_player_move),
                new Sprite(32, 1, 2, character_player_move),
                new Sprite(32, 2, 1, character_player_move),
                new Sprite(32, 2, 2, character_player_move),
                new Sprite(32, 3, 1, character_player_move),
                new Sprite(32, 3, 2, character_player_move)
        };

        shadow = new Sprite(16, 0, 0, entity_shadow);
    }
}
