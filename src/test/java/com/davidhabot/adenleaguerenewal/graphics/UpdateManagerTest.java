package com.davidhabot.adenleaguerenewal.graphics;

import com.davidhabot.adenleaguerenewal.game.Updatable;
import com.davidhabot.adenleaguerenewal.game.UpdateManager;
import org.junit.Test;

public class UpdateManagerTest {
    @Test
    public void testUpdateManager() {
        Updatable updatable = () -> System.out.println("SecondUpdate" + UpdateManager.getUpdateCnt());
        Updatable updatable2 = () -> System.out.println("ThirdUpdate" + UpdateManager.getUpdateCnt());
        Updatable updatable3 = () -> System.out.println("4thUpdate" + UpdateManager.getUpdateCnt());
        Updatable updatable4 = () -> System.out.println("5thUpdate" + UpdateManager.getUpdateCnt());
        UpdateManager.addUpdatable(updatable2);
        UpdateManager mng = new UpdateManager();
        UpdateManager.addUpdatable(updatable);
        UpdateManager.addUpdatable(updatable3);
        UpdateManager.updateAll();
        mng.addUpdatable(updatable4);
        UpdateManager.updateAll();
    }
}
