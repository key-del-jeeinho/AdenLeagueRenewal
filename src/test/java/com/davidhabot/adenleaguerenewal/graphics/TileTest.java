package com.davidhabot.adenleaguerenewal.graphics;

import com.davidhabot.adenleaguerenewal.exception.WrongCoordinateException;
import com.davidhabot.adenleaguerenewal.level.ImageLevel;
import com.davidhabot.adenleaguerenewal.level.tile.TileLoader;
import org.junit.Test;

public class TileTest {
    SpriteLoader spriteLoader = new SpriteLoader();
    TileLoader tileLoader = new TileLoader(spriteLoader);
    @Test
    public void testLevel() {
        ImageLevel imgLevel = new ImageLevel("/texture/level.png");
        imgLevel.setOffset(200, 250);
        Testable testable = () -> {
            try {
                imgLevel.render(new Screen(500, 500));
            } catch (WrongCoordinateException e) {
                e.printStackTrace();
            }
        };

        //람다식을 활용해 테스트용 Testable 인스턴스를 생성하여 testFPS 로 테스트한다
        TestModule.testFPS(
                () -> {
                    try {
                        imgLevel.render(new Screen(500, 500));
                    } catch (WrongCoordinateException e) {
                        e.printStackTrace();
                    }
                }
        );

    }

    @Test
    public void testTile() {
        int[] pixel = tileLoader.getDirt().getSprite().getPixels();
        int width = tileLoader.getDirt().getSprite().getWidth();
        int height = tileLoader.getDirt().getSprite().getHeight();

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                System.out.format("%06x", pixel[x + y * width]);
                System.out.print(" | ");
            }
            System.out.println(" ");
        }
    }

    public void printLevel(ImageLevel imgLevel) {
        for(int y = 0; y < imgLevel.getHeight(); y++) {
            for(int x = 0; x < imgLevel.getWidth(); x++) {
                System.out.print(imgLevel.getTile(x, y).getId());
            }
            System.out.println(" ");
        }
    }
}
