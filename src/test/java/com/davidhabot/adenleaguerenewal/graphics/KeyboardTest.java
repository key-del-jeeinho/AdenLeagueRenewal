package com.davidhabot.adenleaguerenewal.graphics;

import com.davidhabot.adenleaguerenewal.entity.Player;
import org.junit.Test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class KeyboardTest {

    private Player p = new Player(null, 100, 50, 1.0,
            KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_SHIFT,
            KeyEvent.VK_Q,KeyEvent.VK_E, KeyEvent.VK_R,
            KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3
    );
    @Test
    public void TestPlayer() {
        p.gameKeyPressed(KeyEvent.VK_W);
    }

    @Test
    public void TestKeyboard() {
        Random r = new Random();
        for(int i = 0; i < 100; i++) {
            int key;
            switch (r.nextInt(4)) {
                case 0:
                    key = KeyEvent.VK_W;
                    break;
                case 1:
                    key = KeyEvent.VK_S;
                    break;
                case 2:
                    key = KeyEvent.VK_A;
                    break;
                case 3:
                    key = KeyEvent.VK_D;
                    break;
                default:
                    key = KeyEvent.VK_Q;
                    break;
            }
            KeyEvent keyEvent = new KeyEvent(new JFrame(), key, 0, KeyEvent.VK_W, KeyEvent.VK_W, 'w');
            p.getKb().keyPressed(keyEvent);
            p.update();
            p.getKb().keyReleased(keyEvent);
        }
    }
}
