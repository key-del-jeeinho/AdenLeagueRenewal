package com.davidhabot.adenleaguerenewal.graphics;

import com.davidhabot.adenleaguerenewal.game.UpdateManager;
import org.junit.Test;

public class UpdateManagerTest {
    @Test
    public void testUpdateManager() {
         Thread thread = new Thread(new UpdateManager(), "update");
         thread.start();
    }

    public static void main(String[] args) {

        Thread thread = new Thread(new UpdateManager(), "update");
        thread.start();
    }
}
