package com.davidhabot.adenleaguerenewal.level.tile;

import com.davidhabot.adenleaguerenewal.graphics.SpriteLoader;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class TileLoader {
    //호출된 타일의 생성자 내에서 해당 타일을 tiles 에 넣으므로, 런타임 이전에 타일은 전부 로딩된다.
    @Getter
    private static final List<Tile> tiles = new ArrayList<>(); //게임 내 존재하는 모든 타일을 저장하는 리스트

    @Getter
    Tile voidTile, grass, dirt, flowerA, flowerB, rock, stone, stone_jewel, oak, oak_hole, water; //게임 내 존재하는 모든 타일

    //타일을 로딩하는 타일로더의 기본적인 생성자
    public TileLoader(SpriteLoader loader) {
        loadTile(loader);
    }

    //게임 내 존재하는 모든 타일을 불러온다
    private void loadTile(SpriteLoader loader) {
        voidTile = new VoidTile(loader.voidTile, 0);
        grass = new GrassTile(loader.grass, 0);
        dirt = new DirtTile(loader.dirt, 0);
        flowerA = new FlowerTile(loader.flowerA, 0);
        flowerB = new FlowerTile(loader.flowerB, 0);
        rock = new RockTile(loader.rock, 0);
        stone = new StoneTile(loader.stone, 0);
        stone_jewel = new StoneTile(loader.stone_jewel, 0);
        oak = new OakTile(loader.oak, 0);
        oak_hole = new OakHoleTile(loader.oak_hole, 0);
        water = new WaterTile(loader.water, 0);
    }

    //TODO 같은 ID를 가지고있는 타일에 대한 처리 필요 ex. flower => 고유식별자 제작 고려
    //getTile() - 로딩된 타일중에서 해당 타입의 타일을 불러온다
    public static Tile getTile(TileType type) {
        for(Tile tile : tiles)
            if(tile.getId() == type.getId()) {
                return tile;
            }
        throw new NullPointerException();
    }
}
