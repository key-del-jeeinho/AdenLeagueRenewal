package com.davidhabot.adenleaguerenewal.game;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class UpdateManager implements Updatable{
    @Getter
    private static int updateCnt; //전체 업데이트(updateAll)횟수를 저장하는 함수
    private static final List<Updatable> updatables = new ArrayList<>();//업데이트 할 클래스들을 저장하는 리스트

    public UpdateManager() {
        updatables.add(0, this);//자기자신을 가장 첫번째로 넣는다.
    }

    public static void addUpdatable(Updatable updatable) {
        updatables.add(updatable);
    }

    @Override
    public void update() {
        updateCnt++;
    }

    public static void updateAll() {
        for(Updatable updatable : updatables)
            updatable.update();
    }
}
