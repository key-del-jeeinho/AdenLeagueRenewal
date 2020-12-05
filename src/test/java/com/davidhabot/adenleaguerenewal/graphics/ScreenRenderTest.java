package com.davidhabot.adenleaguerenewal.graphics;

import org.junit.Test;

public class ScreenRenderTest {
    @Test
    public void testRender() {
        Renderable renderable = (Screen screen)-> System.out.println("renderA");
        Renderable renderable1 = (Screen screen)-> System.out.println("renderB");
        Renderable renderable2 = (Screen screen)-> System.out.println("renderC");
        Renderable renderable3 = (Screen screen)-> System.out.println("renderD");
        Renderable renderable4 = (Screen screen)-> System.out.println("renderE");

        Renderable.renderables.add(renderable);
        Renderable.renderables.add(renderable1);
        Renderable.renderables.add(renderable2);
        Renderable.renderables.add(renderable3);
        Renderable.renderables.add(renderable4);

        Screen sc = new Screen(1, 1);
        TestModule.testFPS(sc::renderAll); //더블콜론 람다를 사용해 Testable 인스턴스를 testFPS 에 인자로 보낸다
    }
}
