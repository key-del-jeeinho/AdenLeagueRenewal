package com.davidhabot.adenleaguerenewal.graphics;

import com.davidhabot.adenleaguerenewal.exception.WrongCoordinateException;
import com.davidhabot.adenleaguerenewal.game.Game;
import lombok.Getter;
import lombok.NonNull;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

public class Screen implements Renderable{
    @Getter
    private BufferedImage img;
    @Getter
    private int[] screen;
    @Getter
    private final int width, height;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        initScreen(); //스크린의 모든 픽셀을 초기화한다
        Renderable.renderables.add(0, this);
    }

    private void initScreen() {
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        screen = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
    }

    //clear() - 화면의 모든 픽셀을 검정색으로 초기화한다다
   public void clear() {
       Arrays.fill(screen, 0x000000); //화면의 모든 픽셀을 검정색으로 초기화한다
    }

    @Override
    public void render(@NonNull Screen screen) {
    }

    public void renderAll() {
        try {
            for (Renderable renderable : Renderable.renderables)
                renderable.render(this);
        } catch (WrongCoordinateException e) {
            e.printStackTrace();
        }
    }
}
