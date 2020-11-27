package com.davidhabot.adenleaguerenewal.graphics;

import lombok.Getter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {
    private static final long serialVersionUID = 1L; //직렬화 명시

    private String path; //스프라이트 시트의 경로
    @Getter
    private final int LENGTH; //스프라이트 시트의 크기
    public int[] sheet; //int array 값으로 변환한 스프라이트시트 이미지

    //레벨의 구성요소인 타일에 대한 스프라이트 시트를 불러온다
    public static SpriteSheet tilesA = new SpriteSheet("/texture/spritesheet.png", 16*16);
    //플래이어의 기본적인 움직임에 대한 스프라이트 시트를 불러온다
    public static SpriteSheet playerKnight = new SpriteSheet("/texture/character_player.png", 16*3);
    
    //스프라이트 시트의 기본적인 정보를 구축하는 생성자
    public SpriteSheet(String path, int length) {
        this.path = path;
        this.LENGTH = length;
        sheet = new int[LENGTH * LENGTH];
        loadSheet();
    }

    private void loadSheet() {
        try {
            BufferedImage img = ImageIO.read(SpriteSheet.class.getResource(path)); //img 에 path 에서 가져온 이미지를 저장한다.
            //sheet 배열에 int array 값으로 변환한 스프라이트 시트 이미지흫 저장한다.
            //가로와 세로길이가 같으므로 스캔 크기는 width 나 height 중 하나로 한다.
            img.getRGB(0, 0, img.getWidth(), img.getHeight(), sheet, 0, img.getWidth());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
