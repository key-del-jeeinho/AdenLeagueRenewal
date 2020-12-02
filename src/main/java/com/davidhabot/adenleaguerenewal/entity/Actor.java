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
    protected Direction dir;
    protected double speed; //액터의 속도(이동관련 처리로직에 영향울 준다)

    @Getter @Setter
    protected KeyBoardManager kb = new KeyBoardManager(this,
            KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D); //기본적인 이동에 관한 키보드 클래스를 작성한다

    //Actor 의 기본정보를 초기화하는 생성자이다
    public Actor(int[] keyId, Sprite[] sprites, int x, int y, double speed) {
        this.keyId = keyId;
        this.keyStatus = new boolean[120];
        this.sprites = sprites;
        this.x = x;
        this.y = y;
        this.dir = Direction.DOWN;
        this.speed = speed;
        this.kb = kb;
        kb.addListener(this); //키보드 클래스에 해당 게임 키보드 리스너를 활성화시킨다.
    }


    protected abstract void checkMovement();

    protected void move(int x, int y) {
        rotate(x, y);
        this.x += x; //x 축으로 speed * distance 만큼 이동한다
        this.y += y; //y 축으로 speed * distance 만큼 이동한다
        //move event 에 대한 로그를 출력한다
        System.out.printf("Move Event 발생 x축으로 %d만큼, y축으로 %d만큼 이동합니다.\n플레이어 좌표 : (%d, %d)\n", x, y, this.x, this.y);
    }

    protected void rotate(int x, int y) {
        //최적화를 위해 일단 x가 0 (음직이지 않음) 인지 검사
        if(x != 0) {
            if (x < 0) rotate(Direction.LEFT); //x가 음수일경우 왼쪽으로 이동한것이므로, 방향을 왼쪽으로 전환
            if (x > 0) rotate(Direction.RIGHT); //x가 양수일경우 오른쪽으로 이동한것이므로, 방향을 오른쪽으로 전환
        }
        //최적화를 위해 일단 y가 0 (음직이지 않음) 인지 검사
        if(y != 0) {
            if(y < 0) rotate(Direction.UP); //y가 음수일경우 위쪽으로 이동한것이므로, 방향을 위쪽으로 전환
            if(y > 0) rotate(Direction.DOWN); //y가 양수일경우 아래쪽으로 이동한것이므로, 방향을 아래쪽으로 전환
        }
    }
    protected void rotate(Direction dir, boolean isRelative) {
        if(isRelative) //매개변수로 받은 dir 이 상대적인 방향(현재 방향에서 dir만큼 회전)일경우
            rotate(this.dir.add(dir)); //rotate 에 만들어놓은 add메소드를 통하여 해당 로직을 처리한다
        else rotate(dir);//dir 이 절대적인 방향일경우, 그대로 rotate 함수를 호출한다
    }
    public void rotate(Direction dir) {
        System.out.printf("Rotate Event 발생 %s 에서 %s로 움직여 %s 로 방향으로 전환합니다.\n", this.dir, dir, this.dir.minus(dir));
        this.dir = dir;//dir 값을 지정한다.
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
