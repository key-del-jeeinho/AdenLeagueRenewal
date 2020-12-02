package com.davidhabot.adenleaguerenewal.graphics;

import com.davidhabot.adenleaguerenewal.exception.WrongCoordinateException;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface Renderable {
    List<Renderable> renderables = new ArrayList<>();
    void render(@NonNull Screen screen) throws WrongCoordinateException;
}
