package com.davidhabot.adenleaguerenewal;

import com.davidhabot.adenleaguerenewal.entity.Actor;
import com.davidhabot.adenleaguerenewal.graphics.ScreenController;
import com.davidhabot.adenleaguerenewal.level.Level;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class GameConfiguration {
    @Getter
    private final int width, height, scale; //각각 가로길이, 세로길이, 디스플레이 배율
    private final double displayRatio; //디스플레이 비율

    @Getter @Setter
    private String title; //게임의 제목 (게임 상단 바에 표시됨)

    private Dimension size; //실제 디스플레이 사이즈 (가로*배율, 세로*배율)

    private ScreenController screenControl; //BufferedImage 를 통한 화면 출력 컨트롤러
    private JFrame frame; //Image 에 텍스트 등의 부가 정보를 넣기 위해 생성
    private List<Actor> actors; //게임에서 키보드를 통해 실제로 움직일 수 있는 개체(Entity)들
    private List<Level> levels; //게임에 존재하는 모든 맵

    private boolean isRunning = false; //게임이 진행중인지 여부
    private static final String DEFAULT_GAME_TITLE = "Game";

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
        initReferenceVar();
        this.width = width;
        this.height = height;
        this.displayRatio = height / (double)width;
        this.scale = scale;
        this.title = title;
        //만약 size 의 높이와 너비가 정해지지 않았을경우
        if(size.getHeight() == 0 || size.getHeight() == 0)
        this.size.setSize(width * scale, height * scale);
    }

    //initReferenceVar() - 게임에 쓰이는 모든 클래스 변수를 초기화한다.
    private void initReferenceVar() {
        this.size = new Dimension();
        this.screenControl = new ScreenController();
        this.frame = new JFrame();
        this.actors = new ArrayList<>();
        this.levels = new ArrayList<>();
    }

}
