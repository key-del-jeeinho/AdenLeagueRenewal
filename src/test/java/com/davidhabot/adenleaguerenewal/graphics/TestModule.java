package com.davidhabot.adenleaguerenewal.graphics;

import com.davidhabot.adenleaguerenewal.game.UpdateManager;
import org.junit.Test;

public class TestModule {
    private static long lastTime = System.nanoTime(); // lastTime 이란 변수를 현재 시간(단위 : nano)으로 초기화
    private static long timer = System.currentTimeMillis(); //timer 이란 변수를 현재 시간(단위 : milli)으로 초기화
    private static final double ns = 1000000000.0 / 60.0;
    private static double delta = 0;
    private static int frames = 0;
    private static int updates = 0;

    public static void testFPS(Testable testable) {
        //Functional Interface 를 통해 테스트할 메소드를 인자로 전달한다.
        while (true) {
            long now = System.nanoTime();
            //frame 수를 세기 위한 작업 - delta 가 1이라면 1frame(1/60s) 가 지나갔다는것을 뜻한다.
            delta += (now - lastTime) / ns; //루프를 한번 돌 때 걸리는 시간을 ns로 나누어 delta 에 누적
            lastTime = now; //lastTime 을 현재로 갱신한다
            //1frame 마다 게임을 업데이트시킨다.
            while (delta >= 1) {
                testable.test(); //테스트 모듈로 전달된 인자를 테스트한다
                updates++;
                delta--;
            }
            frames++;
            checkTimer();
        }
    }
    private static void checkTimer() {
        if(System.currentTimeMillis() - timer > 1000) { //1초가 지났는지 검사한다
            timer+=1000; //1초가 지난 뒤 타이머를 실제 시간과 동기화(+ 1초)한다
            String formattedInfo = formatTimerInfo(updates, frames); //ups 와 fps 를 포멧팅하여 가져온다
            System.out.println(formattedInfo); //포맷팅한 ups 와 fps 를 출력한다
            initTimer();//업데이트횟수와 프레임 변동 횟수를 초기화한다
        }
    }

    private static void initTimer() {
        updates = 0;
        frames = 0;
    }

    private static String formatTimerInfo(int updates, int frames) {
        return updates + " ups | " + frames + " fps";
    }
}
