package com.davidhabot.adenleaguerenewal.entity;

import com.davidhabot.adenleaguerenewal.exception.WrongCoordinateException;
import com.davidhabot.adenleaguerenewal.game.Updatable;
import com.davidhabot.adenleaguerenewal.game.UpdateManager;
import com.davidhabot.adenleaguerenewal.graphics.Renderable;
import com.davidhabot.adenleaguerenewal.graphics.Screen;
import com.davidhabot.adenleaguerenewal.graphics.Sprite;
import com.davidhabot.adenleaguerenewal.input.GameKeyListener;
import com.davidhabot.adenleaguerenewal.input.KeyBoardManager;
import com.davidhabot.adenleaguerenewal.input.PlayerKeySet;
import lombok.NonNull;

import javax.swing.*;

public class Player extends Actor implements GameKeyListener, Updatable, Renderable {

    private static final int DASH_DISTANCE = 3; //플레이어가 질주를 사용했을때의 질주의 거리이다. (speed 에 따라 변화함)

    //Player 의 기본 정보를 초기화하는 생성자
    public Player(Sprite[] sprite, int x, int y, double speed, int... keyId) {
        super(keyId, sprite, x, y, speed); //super class 인 Actor 의 생성자를 호출한다.
        //KeyBoardManager kb = new KeyBoardManager(frame, this,  keyId); //플레이어가 게임에서 사용할 키셋
        UpdateManager.addUpdatable(this);//해당 클래스를 업데이트 매니저에 넣는다.
        Renderable.renderables.add(this);
    }

    //플레이어가 업데이트 될때의 로직
    public void update() {
        checkMovement();
        checkSkillCast();
    }

    //checkMovement() - 이벤트가 일어난 키가 이동(Dash 포함)에 관련된 키인지 확인한다.
    @Override
    protected void checkMovement() {
        int xMovement = 0, yMovement = 0;
        //keyId 에서 PlayerKeySet 의 값을통해 UP 키의 아이디를 불러오고, 해당 아이디를 keyStatus 인덱스에 넣어 해당 아이디를 가진 키가 눌렸는지 확인한다.
        if (keyStatus[keyId[PlayerKeySet.MOVE_UP.getIdx()]])//UP키 눌림여부
            yMovement = (int) -Math.round(speed); //반올림한 speed 값으로 Y축 이동거리를 지정한다
        if (keyStatus[keyId[PlayerKeySet.MOVE_DOWN.getIdx()]])//DOWN 키 눌림여부
            yMovement = (int) Math.round(speed); //반올림한 speed 값으로 Y축 이동거리를 지정한다
        if (keyStatus[keyId[PlayerKeySet.MOVE_LEFT.getIdx()]])//LEFT 키 눌림여부
            xMovement = (int) -Math.round(speed); //반올림한 speed 값으로 X축 이동거리를 지정한다
        if (keyStatus[keyId[PlayerKeySet.MOVE_RIGHT.getIdx()]])//RIGHT 키 눌림여부
            xMovement = (int) Math.round(speed); //반올림한 speed 값으로 X축 이동거리를 지정한다

        //Dash 키 눌림 여부를 통해 이동 거리를 설정한다
        if (keyStatus[keyId[PlayerKeySet.MOVE_DASH.getIdx()]]) {
            //DASH 시 이동거리가 DASH_DISTANCE 배 증가시킨다
            xMovement *= DASH_DISTANCE;
            yMovement *= DASH_DISTANCE;
        }
        if(xMovement != 0 || yMovement != 0)
            move(xMovement, yMovement); //X/Y축 이동거리만큼 플레이어를 이동시킨다.
    }

    //checkSkillCast() - 이벤트가 일어난 키가 스킬발동에 관련된 키인지 확인한다.
    private void checkSkillCast() {
        //TODO 2020-11-28 07:02 AM | 스킬발동 관련 로직 처리 | David Habot
        if(keyStatus[PlayerKeySet.SKILL_A.getIdx()]);
    }

    @Override
    public void render(@NonNull Screen screen) throws WrongCoordinateException {
        if(super.x < 0 || super.y < 0) throw new WrongCoordinateException("플레이어의 좌표가 음수입니다!");
        int idx = 0;
        if()
        int w = sprites[idx].getWidth();
        for(int y = 0; y < sprites[0].getHeight(); y++) {
            for(int x = 0; x < w; x++) {
                if(sprites[idx].getPixels()[x + y * w] != 0xFF00FF)
                    //스크린의 중앙부분에 스프라이트를 렌더링한다
                    screen.getScreen()[(x + screen.getWidth() / 2)+ (y + screen.getHeight() / 2) * screen.getWidth()] =
                            sprites[idx].getPixels()[x + y * w];
            }
        }
    }

    @Override
    public void gameKeyPressed(int keyId) {
        keyStatus[keyId] = true;
    }

    @Override
    public void gameKeyReleased(int keyId) {
        keyStatus[keyId] = false;
    }
}
