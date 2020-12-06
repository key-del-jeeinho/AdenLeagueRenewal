package com.davidhabot.adenleaguerenewal.input;

import com.davidhabot.adenleaguerenewal.game.Game;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
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
        if(key == null) {
            System.out.println("Key is Null");
            key = new int[]{KeyEvent.VK_UNDEFINED};
        } else System.out.println("Key is " + Arrays.toString(key));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //키가 눌려졌을때 로직
        //System.out.println("키 눌림 감지 : " + e.getKeyCode());
        for (int j : key) {
            if (e.getKeyCode() == j) //미리 등록해놓은 키 ID와 눌려진 키의 ID가 같을경우
                for (GameKeyListener listener : listeners) //모든 리스너에 이벤트를 호출
                    listener.gameKeyPressed(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //키가 때였을때 로직
        //System.out.println("키 떼임 감지 : " + e.getKeyCode());
        for (int j : key) {
            if (e.getKeyCode() == j) //미리 등록해놓은 키 ID와 눌려진 키의 ID가 같을경우
                for (GameKeyListener listener : listeners) //모든 리스너에 이벤트를 호출
                    listener.gameKeyReleased(e.getKeyCode());
        }
    }

    public void addListener(GameKeyListener listener) {
        listeners.add(listener);
    }
}
