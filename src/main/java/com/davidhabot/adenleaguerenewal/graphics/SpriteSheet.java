package com.davidhabot.adenleaguerenewal.graphics;

import lombok.Getter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {
    private final String PATH; //스프라이트 시트의 주소
    /*
    WIDTH : 스프라이트 시트의 너비
    HEIGHT : 스프라이트 시트의 높이
    GRID_SIZE : 스프라이트 한 칸의 크기
     */
    @Getter
    private final int WIDTH, HEIGHT, CELL_SIZE;
    private static final int DEFAULT_CELL_SIZE = 16; //셀 크기가 지정되어있지 않을경우 기본적인 셀 의 크기값
    @Getter
    private int[] sheet; //스프라이트 시트의 색상값(이미지)가 저장될 정수형 배열

    //스프라이트 시트의 데이터를 초기화하는 생성자
    public SpriteSheet(String path, int gridSize, int raw, int column) {
        int height = gridSize * raw;
        int width = gridSize * column;

        this.PATH = path;
        this.CELL_SIZE = gridSize;
        this.HEIGHT = height;
        this.WIDTH = width;
        this.sheet = new int[width * height];

        loadSheet(); //스프라이트 시트를 sheet에 불러온다
    }

    public SpriteSheet(String path, int width, int height) {
        this.PATH = path;
        this.CELL_SIZE = DEFAULT_CELL_SIZE;
        this.HEIGHT = height;
        this.WIDTH = width;
        this.sheet = new int[width * height];

        loadSheet(); //스프라이트 시트를 sheet에 불러온다
    }

    private void loadSheet() {
        try {
            BufferedImage img = ImageIO.read(SpriteSheet.class.getResource(this.PATH));
            int width = img.getWidth();
            int height = img.getHeight();
            //sheet 배열에 스프라이트 시트 이미지를 불러온다
            img.getRGB(0, 0, width, height, sheet, 0, width);
            for(int i = 0; i < sheet.length; i++) {
                sheet[i] = sheet[i] & 0xFFFFFF;
            }
        } catch (IOException e) {
            //TODO 2020.11.30 14:12 PM | err handling | David Habot
            e.printStackTrace();
        }
    }
}
