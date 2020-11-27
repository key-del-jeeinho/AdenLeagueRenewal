package com.davidhabot.adenleaguerenewal.entity;

import com.davidhabot.adenleaguerenewal.graphics.Sprite;
import com.davidhabot.adenleaguerenewal.input.GameKeyListener;
import com.davidhabot.adenleaguerenewal.input.KeyBoardManager;
import lombok.Getter;
import lombok.Setter;

import java.awt.event.KeyEvent;

public abstract class Actor implements Entity, GameKeyListener{
    protected int[] keyId;
    protected boolean[] keyStatus; //해당 키가 눌렸는지를 boolean 값으로 저장한다. 눌린상태면 true, 눌리지 않은 상태=면 false
    protected Sprite[] sprites; //상황에 따른 액터의 모양을 모아둔 스프라이트 그룹
    protected int x, y; //액터의 현재 위치를 저장하는 int 형 변수
    @Getter @Setter
    protected double speed; //액터의 속도(이동관련 처리로직에 영향울 준다)

    @Getter @Setter
    protected KeyBoardManager kb = new KeyBoardManager(this,
            KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D); //기본적인 이동에 관한 키보드 클래스를 작성한다.

    //Actor 의 기본정보를 초기화한다.
    public Actor(int[] keyId, Sprite[] sprites, int x, int y, double speed) {
        this.keyId = keyId;
        this.keyStatus = new boolean[120];
        this.sprites = sprites;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.kb = kb;
        kb.addListener(this); //키보드 클래스에 해당 게임 키보드 리스너를 활성화시킨다.
    }


    protected abstract void checkMovement();

    protected void move(int x, int y) {
        this.x += x; //x축으로 speed * distance 만큼 이동한다
        this.y += y; //y축으로 speed * distance 만큼 이동한다
        //move event 에 대한 로그를 출력한다
        System.out.printf("Move Event 발생 x축으로 %d만큼, y축으로 %d만큼 이동합니다.\n플레이어 좌표 : (%d, %d)\n", x, y, this.x, this.y);
    }

    //keyPressed 이벤트를 받아 처리한다
    @Override
    public void gameKeyPressed(int keyId) {
        keyStatus[keyId] = true;
        System.out.println("Key Pressed : " + keyId);
    }

    @Override
    public void gameKeyReleased(int keyId) {
        keyStatus[keyId] = false;
        System.out.println("Key Released : " + keyId);
    }
}
