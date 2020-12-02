package com.davidhabot.adenleaguerenewal.graphics;

import lombok.Getter;

import java.awt.*;
import java.util.Arrays;

public class Sprite{
    @Getter
    private final int width, height; //스프라이트의 크기
    private int posX;
    private int posY; //스프라이트 시트에서 해당 스프라이트가 존재하는 좌표값(행렬)
    @Getter
    private int[] pixels;
    private SpriteSheet sheet;

    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        this(size, size, x, y, sheet);
    }

    public Sprite(int width, int height, int x, int y, SpriteSheet sheet) {
        this(width, height); //해당 스프라이트의 크기를 초기화한다
        //스프라이트시트에서 스프라이트의 위치를 초기화한다
        this.posX = x;
        this.posY = y;
        //해당 스프라이트가 있는 스프라이트 시트를 sheet 에 넣는다
        this.sheet = sheet;
        loadSprite();
    }

    private void loadSprite() {
        int posX = (this.posX*sheet.getCELL_SIZE());
        int posY = (this.posY*sheet.getCELL_SIZE());
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                pixels[x + y * height] = sheet.getSheet()[(x + posX) + (y + posY) * sheet.getHEIGHT()];
            }
        }
    }

    public Sprite(int width, int height) {
        //스프라이트의 크기를 size 로 초기화한다
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
    }

    public Sprite(int size, Color color) {
        this(size, size);
        setColor(color.getRGB());
    }

    private void setColor(int color) {
        Arrays.fill(pixels, color);
    }
}
