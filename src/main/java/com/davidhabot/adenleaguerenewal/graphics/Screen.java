package com.davidhabot.adenleaguerenewal.graphics;

import com.davidhabot.adenleaguerenewal.game.Game;
import lombok.NonNull;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Screen extends Canvas implements Runnable{
    private final BufferedImage img;
    private final int[] pixels;

    public Screen(int width, int height) {
        setPreferredSize(Game.configuration.getSize());
        //TrueColor 형식의 색깊이를 width * height 넙이의 이미지를 int 형식으로 저장하는 BufferedImage 로 초기화
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //img 의 있는 값을 프로그램에서 조작할 수 있는 int array 형식으로 변환해 저장
        pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
    }


    @Override
    public void run() {
        //게임을 랜더링하는 쓰레드이다.
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();

        Graphics2D g = (Graphics2D)bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight()); //화면전체를 검정색으로 칠한다.
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null); //이미지를 덧씌운다.
        renderUI(g); //UI를 출력한다.
        
        g.dispose();
        bs.show(); //BufferStrategy 를 실제 화면에 출력한다.
    }

    public void renderUI(Graphics g) {
        Color ui_background = new Color(0x202020);
        Color ui_title = new Color(0xFFFE20);
        g.setColor(ui_background);
        g.fillRect(0, 0, getWidth(), (int)(getHeight() / 10 * 1.5));
        g.setColor(ui_title);
        g.setFont(new Font("Verdana", Font.PLAIN, 12));
        g.drawString("AdenLeague", 7, 13);
    }

    @Override
    public BufferStrategy getBufferStrategy() {
        BufferStrategy bs;
        if(super.getBufferStrategy() == null)
            createBufferStrategy(3);
        bs = super.getBufferStrategy();
        return bs;
    }
}
