package com.davidhabot.adenleaguerenewal.graphics;

import com.davidhabot.adenleaguerenewal.game.Game;
import lombok.Getter;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class ScreenController extends Canvas {
    @Getter
    Screen screen;

    public ScreenController(int width, int height) {
        screen = new Screen(width, height);
        Dimension size = new Dimension(Game.configuration.getWidth() * Game.configuration.getScale(), Game.configuration.getHeight() * Game.configuration.getScale());
        setPreferredSize(size);
    }

    @Override
    public BufferStrategy getBufferStrategy() {
        BufferStrategy bs;
        if(super.getBufferStrategy() == null)
            createBufferStrategy(3);
        bs = super.getBufferStrategy();
        return bs;
    }

    public void renderScreen() {
        BufferStrategy bs = getBufferStrategy();
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.PINK);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(screen.getImg(), 0, 0, getWidth(), getHeight(), null);
        renderUI(g);
        bs.show();
    }

    private void renderUI(Graphics g) {
    }
}
