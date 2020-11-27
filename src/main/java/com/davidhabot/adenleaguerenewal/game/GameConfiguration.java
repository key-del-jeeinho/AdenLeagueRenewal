package com.davidhabot.adenleaguerenewal.game;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public class GameConfiguration {
    private static final long serialVersionUID = 1L; //직렬화 명시

    @Getter @Setter
    private Dimension size; //실제 디스플레이 사이즈 (가로*배율, 세로*배율)
    @Getter
    private final int width, height, scale; //각각 가로길이, 세로길이, 디스플레이 배율
    private final double displayRatio; //디스플레이 비율

    @Getter @Setter
    private String title; //게임의 제목 (게임 상단 바에 표시됨)
    private static final String DEFAULT_GAME_TITLE = "New Game";//기본적인 게임의 제목

    //게임 컨피그의 가장 단순한 생성자, 가로 세로의 길이가 length 이며 scale 이 1인 정사각형
    public GameConfiguration(int length) {
        this(length, length);
    }

    //가로, 세로를 설정할 수 있는 게임컨피그의 생성자
    //scale 은 자동으로 1로 지정되며, 배율 또한 자동지정
    public GameConfiguration(int width, int height) {
        this(width, height, 1);
    }

    //가로, 화면 비율, 화면 배율을 설정할 수 있는 게임 컨피그의 생성자
    //가로길이와 화면 배율을 통하여 화면의 세로길이를 계산해 생성자 호출
    public GameConfiguration(int width, double displayRatio, int scale) {
        this(width, displayRatio, scale, GameConfiguration.DEFAULT_GAME_TITLE);
    }

    //가로, 세로 및 화면 배율을 설정할 수 있는 게임 컨피그의 생성자
    public GameConfiguration(int width, int height, int scale) {
        this(width, height, scale, GameConfiguration.DEFAULT_GAME_TITLE);
    }

    //가로, 세로, 화면비율 을 설정할 수 있고 게임 타이틀을 지정할 수 있는 게임 컨피그의 생성자
    //화면 비율과 가로의 곱을 통해 세로를 구해 타 생성자 호출
    public GameConfiguration(int width, double displayRatio, int scale, String title) {
        this(width, (int)(width * displayRatio), scale, title);
    }

    //가로, 세로, 화면배율 을 설정할 수 있고 게임 타이틀을 지정할 수 있는 게임 컨피그의 생성자
    public GameConfiguration(int width, int height, int scale, String title) {
        this.width = width;
        this.height = height;
        this.displayRatio = height / (double)width;
        this.scale = scale;
        this.title = title;
        this.size = new Dimension(width * scale, height * scale);
    }
}
