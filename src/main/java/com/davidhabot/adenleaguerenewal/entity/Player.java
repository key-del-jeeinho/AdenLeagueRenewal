package com.davidhabot.adenleaguerenewal.entity;

import com.davidhabot.adenleaguerenewal.game.Updatable;
import com.davidhabot.adenleaguerenewal.graphics.Sprite;
import com.davidhabot.adenleaguerenewal.input.GameKeyListener;
import com.davidhabot.adenleaguerenewal.input.KeyBoardManager;
import com.davidhabot.adenleaguerenewal.input.PlayerKeySet;

public class Player extends Actor implements GameKeyListener, Updatable {

    private static final int DASH_DISTANCE = 3;
    public Player(Sprite[] sprite, int x, int y, double speed, int... keyId) {
        super(keyId, sprite, x, y, speed);
        KeyBoardManager kb = new KeyBoardManager(this,  keyId);
        setKb(kb);
    }

    public void update() {
        checkMovement();
        checkSkillCast();
    }

    //checkMovement() - 이벤트가 일어난 키가 이동(Dash포함)에 관련된 키인지 확인한다.
    @Override
    protected void checkMovement() {
        int xMovement = 0, yMovement = 0;
        if (keyStatus[keyId[PlayerKeySet.MOVE_UP.getIdx()]])
            yMovement = (int) -Math.round(speed);
        if (keyStatus[keyId[PlayerKeySet.MOVE_DOWN.getIdx()]])
            yMovement = (int) Math.round(speed);
        if (keyStatus[keyId[PlayerKeySet.MOVE_LEFT.getIdx()]])
            xMovement = (int) -Math.round(speed);
        if (keyStatus[keyId[PlayerKeySet.MOVE_RIGHT.getIdx()]])
            xMovement = (int) Math.round(speed);
        if (keyStatus[keyId[PlayerKeySet.MOVE_DASH.getIdx()]]) {
            xMovement *= 3;
            yMovement *= 3;
        }
        move(xMovement, yMovement);
    }

    //checkSkillCast() - 이벤트가 일어난 키가 스킬발동에 관련된 키인지 확인한다.
    private void checkSkillCast() {
    }
}
