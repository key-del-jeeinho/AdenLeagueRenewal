package com.davidhabot.adenleaguerenewal.level.tile;

import com.davidhabot.adenleaguerenewal.graphics.Sprite;
import lombok.Getter;
import lombok.Setter;

public abstract class Tile {
    @Getter @Setter
    private long color; //해당 타일의 레벨이미지에서의 ㅍ시색
    @Getter
    private final Sprite sprite; //해당 타일이 소유한 스프라이트

    //타일 클래스의 기본적인 생성자
    public Tile(Sprite sprite, int color) {
        this.sprite = sprite;
        this.color = color;
        TileLoader.getTiles().add(this); //타일 생성시 자동적으로 타일로더 내부리스트에 타일이 등록된다
    }

    public abstract boolean isSolid(); //고체여부(엔티티 이동제한을 위함)
    public abstract int getId(); //해당 타일의 식별자 
}
