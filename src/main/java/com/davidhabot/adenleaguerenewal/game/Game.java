package com.davidhabot.adenleaguerenewal.game;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public class Game implements Runnable{

    public final static GameConfiguration configuration = new GameConfiguration(300, 9/16.0, 2, "AdenLeague"); //게임에 대한 초기설정
    public static GameData data = new GameData();

    private  Thread game;
    private boolean isRunning = false; //게임이 진행중인지 여부

    public Game() {
        //addKeyListener();
    }

    private long lastTime = System.nanoTime(); // lastTime 이란 변수를 현재 시간(단위 : nano)으로 초기화
    private long timer = System.currentTimeMillis(); //timer 이란 변수를 현재 시간(단위 : milli)으로 초기화
    private final double ns = 1000000000.0 / 60.0;
    @Getter
    private static int score = 0, gameTimer = 60;

    public static void addScore() {
        score++;
        System.out.println("score : " + score);
    }

    public void start() {
        this.isRunning = true;
        game = new Thread(this, "Game");
        game.run();
    }

    //TODO 주석달기
    private double delta = 0;
    private int frames = 0;
    private int updates = 0;
    @Override
    public void run() {
        int x = 0, y = 0;
        while (true) {
            long now = System.nanoTime();
            //frame 수를 세기 위한 작업 - delta 가 1이라면 1frame(1/60s) 가 지나갔다는것을 뜻한다.
            delta += (now - lastTime) / ns; //루프를 한번 돌 때 걸리는 시간을 ns로 나누어 delta 에 누적
            lastTime = now; //lastTime 을 현재로 갱신한다
            //1frame 마다 게임을 업데이트시킨다.
            while (delta >= 1) {
                UpdateManager.updateAll();//스태틱메서드 _update 를 통해서 모든 정보를 업데이트한다.
                x++;
                y++;
                data.getLevels().get(0).setOffset(data.player.getX(), data.player.getY());
                updates++;
                delta--;
            }
            data.getScreenControl().getScreen().renderAll();
            data.getScreenControl().renderScreen();
            frames++;
            checkTimer();

            //점수 로직
            if(score >= 15) {
                System.out.println("게임이 끝났습니다!");
                while(true)
                    data.getScreenControl().showWin();
            }else if(score >= 10) {
                data.getPlayer().setSpeed(2);
            }else if(score >= 5) {
                data.getPlayer().setSpeed(1.5);
            }

            //타이머 로직
            if(gameTimer <= 0)
                while(true)
                    data.getScreenControl().showLose();
            else if(gameTimer <= 10)
                data.getPlayer().setSpeed(10);
        }
    }

    private void checkTimer() {
        //1초가 지나면 true 반환
        if(System.currentTimeMillis() - timer > 1000) {
            timer+=1000;
            String formattedInfo = formatTimerInfo(updates, frames);
            initTimer();
            printTitle(formattedInfo);
            gameTimer--;
        }
    }

    private void initTimer() {
        updates = 0;
        frames = 0;
    }

    private String formatTimerInfo(int updates, int frames) {
        return updates + " ups | " + frames + " fps";
    }

    private void printTitle(String timerInfo) {
        Game.data.getFrame().setTitle(Game.configuration.getTitle() + timerInfo);
    }

    public static void main(String[] args) {
        Game game = new Game();
        data.getFrame().setResizable(false);
        data.getFrame().add(data.getScreenControl());
        data.getFrame().addKeyListener(data.getPlayer().getKb());
        data.getFrame().requestFocus();
        data.getFrame().pack();
        data.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        data.getFrame().setLocationRelativeTo(null);
        data.getFrame().setVisible(true);
        game.start();
    }
}
