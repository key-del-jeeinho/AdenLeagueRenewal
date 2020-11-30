package com.davidhabot.adenleaguerenewal.game;


public class Game implements Runnable{

    public final static GameConfiguration configuration = new GameConfiguration(300, 9/16.0, 3, "AdenLeague"); //게임에 대한 초기설정
    public static GameData data = new GameData();

    private  Thread render;
    private boolean isRunning = false; //게임이 진행중인지 여부

    public Game() {
        //addKeyListener();
    }

    private long lastTime = System.nanoTime(); // lastTime 이란 변수를 현재 시간(단위 : nano)으로 초기화
    private long timer = System.currentTimeMillis(); //timer 이란 변수를 현재 시간(단위 : milli)으로 초기화
    private final double ns = 1000000000.0 / 60.0;
    private double delta = 0;
    private int frames = 0;
    private int updates = 0;
    @Override
    public void run() {
        while (true) {
            long now = System.nanoTime();
            //frame 수를 세기 위한 작업 - delta 가 1이라면 1frame(1/60s) 가 지나갔다는것을 뜻한다.
            delta += (now - lastTime) / ns; //루프를 한번 돌 때 걸리는 시간을 ns로 나누어 delta 에 누적
            lastTime = now; //lastTime 을 현재로 갱신한다
            //1frame 마다 게임을 업데이트시킨다.
            while (delta >= 1) {
                UpdateManager.updateAll();//스태틱메서드 _update 를 통해서 모든 정보를 업데이트한다.
                updates++;
                delta--;
            }
            frames++;
            checkTimer();
        }
    }

    private void checkTimer() {
        //1초가 지나면 true 반환
        if(System.currentTimeMillis() - timer > 1000) {
            timer+=1000;
            String formattedInfo = formatTimerInfo(updates, frames);
            initTimer();
            printTitle(formattedInfo);
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
}
