package com.davidhabot.adenleaguerenewal.entity;

import lombok.Getter;

public enum Direction {
    //연산자 메소드가 있으므로 ordinal 을 시계방향으로 한다.
    UP(0), RIGHT(1), DOWN(2), LEFT(3);

    @Getter
    private final int dir;

    Direction(int dir) {
        this.dir = dir;
    }

    public Direction add(Direction dir) {
        //1. values 를 통해 Direction 내부의 모든 인스턴스를 ordinal 순으로 배열로 불러온다
        //2. 자기자신과 매개변수로 받은 방향의 ID(=ordinal) 를 더한다
        //3. 3(Last ordinal) 이상의 수 (ex. DOWN + LEFT)가 배열의 idx로 들어갈 수 있으니 4로 나눈 나머짓값을 넣어 이를 방지한다
        return values()[((this.getDir()) + dir.getDir()) % 4];
    }

    public Direction minus(Direction dir) {
        //1. values 를 통해 Direction 내부의 모든 인스턴스를 ordinal 순으로 배열로 불러온다
        //2. 자기자신과 매개변수로 받은 방향의 ID(=ordinal) 를 뺀다
        //3. 음수(ex. RIGHT - LEFT)가 배열의 idx로 들어갈 수 있으니 좌항에 4를 더하여 이를 방지한다
        //4. 좌항에 4를 더랬으므로 4 이상의 수(ex. UP - UP)가 배열의 idx로 들어갈 수 있으니 4로 나눈 나머짓값을 넣어 이를 방지한다
        return values()[((4 + this.getDir()) + dir.getDir()) % 4];
    }
}
