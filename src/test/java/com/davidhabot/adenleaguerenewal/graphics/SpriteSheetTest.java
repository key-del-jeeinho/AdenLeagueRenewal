package com.davidhabot.adenleaguerenewal.graphics;

import org.junit.Test;

public class SpriteSheetTest {
    private static final SpriteSheet sheet = new SpriteSheet("/texture/spritesheet.png", 16, 16, 16);
    @Test
    public void testSpriteSheet() {
        int[][] sheetArr = sheet.getSheet();

        /*for(int i = 0; i < sheetArr.length; i++) {
            for(int j = 0; j < sheetArr[0].length; j++) {
                //System.out.printf("%03d | %03d | 0x", i, j);
                //System.out.format("%06X%n", sheetArr[i][j]);
            }
            //System.out.println(i+"line");
        }*/
    }

    @Test
    public void testSprite() {
        Sprite sprite = new Sprite(0, 0, sheet);
        int[][] spriteArr = sprite.getSprite();
        for(int i = 0; i < spriteArr.length; i++) {
            for(int j = 0; j < spriteArr[0].length; j++) {
                System.out.printf("%03d | %03d | 0x", i, j);
                System.out.format("%06X%n", spriteArr[i][j]);
            }
        }
    }

}
