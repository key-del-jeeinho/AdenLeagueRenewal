package com.davidhabot.adenleaguerenewal.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

//https://docs.oracle.com/javase/7/docs/api/constant-values.html#java.awt.event - java.awt 의 모든 이벤트의 고유값 리스트
public class KeyBoardManager extends KeyAdapter {
    int[] key;
    private final List<GameKeyListener> listeners;

    public KeyBoardManager(GameKeyListener listener, int... key) {
        listeners = new ArrayList<>();

        this.listeners.add(listener);

        this.key = key;
        //매개변수로 받은 key 가 null 일경우를 핸들링한다.
        if(key == null)
            key = new int[]{KeyEvent.VK_UNDEFINED};
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //키가 눌려졌을때 로직
        for(int i = 0; i < key.length; i++) {
            if(e.getKeyCode() == key[i]) //미리 등록해놓은 키 ID와 눌려진 키의 ID가 같을경우
                for(GameKeyListener listener : listeners) //모든 리스너에 이벤트를 호출
                    listener.gameKeyPressed(e.getID());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //키가 때였을때 로직
        for(int i = 0; i < key.length; i++) {
            if(e.getKeyCode() == key[i]) //미리 등록해놓은 키 ID와 눌려진 키의 ID가 같을경우
                for(GameKeyListener listener : listeners) //모든 리스너에 이벤트를 호출
                    listener.gameKeyReleased(e.getID());
        }
    }

    public void addListener(GameKeyListener listener) {
        listeners.add(listener);
    }
}
