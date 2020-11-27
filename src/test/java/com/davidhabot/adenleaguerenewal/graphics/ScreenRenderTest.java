package com.davidhabot.adenleaguerenewal.graphics;

import com.davidhabot.adenleaguerenewal.game.Game;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

public class ScreenRenderTest {

    /* MISS REPORT 2020.11.27 04:37 AM | 버퍼스트레트지로 랜더를 하므로,
    render = A -> B -> C = 실제 출력
    식으로 출력된다. 그러므로 render 를 한번만 호출할시
    A(rendered) -> B(not rendered) -> C(not rendered) = 실제출력
    이므로, 랜더작업이 진행되지 않은 C가 랜더링이 된다
    그러므로, Test 에서는 Render 를 while 로 돌려서 C까지 계속 랜더링되게한다
     */

    public static void main(String[] args) {
        Screen sc = new Screen(900, 504); //테스트에 사용될 스크린을 더미데이터로 초기화한다
        initFrame(sc); //Frame 을 기본값으로 초기화한다

        //스크린을 랜더링시켜서 테스트를 진행한다
        while(true)
            sc.render();
    }

    //initFrame() 프레임의 기본 값을 초기화한다
    private static void initFrame(Screen sc) {
        Game.data.getFrame().setResizable(false);
        Game.data.getFrame().add(sc);
        Game.data.getFrame().pack();
        Game.data.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Game.data.getFrame().setLocationRelativeTo(null);
        Game.data.getFrame().setVisible(true);
    }
}
