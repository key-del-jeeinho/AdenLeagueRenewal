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
        g.setColor(Color.white);
        g.setFont(new Font("Verdana", Font.PLAIN, 15));
        g.drawString("Score : " + Game.getScore(), 10, 20);
        g.drawString("Time : " + Game.getGameTimer(), 10, 40);
    }

    public void showWin() {
        BufferStrategy bs = getBufferStrategy();
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.white);
        g.setFont(new Font("Verdana", Font.BOLD, 60));
        g.drawString("WIN", screen.getWidth()/2 - 60, screen.getHeight()/2);
        renderUI(g);
        bs.show();
    }

    public void showLose() {
        BufferStrategy bs = getBufferStrategy();
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.RED);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.white);
        g.setFont(new Font("Verdana", Font.BOLD, 60));
        g.drawString("LOSE", screen.getWidth()/2 - 60, screen.getHeight()/2);
        renderUI(g);
        bs.show();
    }
}
