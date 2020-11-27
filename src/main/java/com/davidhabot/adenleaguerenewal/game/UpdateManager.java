package com.davidhabot.adenleaguerenewal.game;

import java.util.ArrayList;
import java.util.List;

public class UpdateManager implements Updatable{
    List<Updatable> updatables;

    public UpdateManager() {
        updatables = new ArrayList<>();
    }

    public void addUpdatable(Updatable updatable) {
        updatables.add(updatable);
    }



    @Override
    public void update() {

    }
}
