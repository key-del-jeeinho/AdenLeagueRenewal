package com.davidhabot.adenleaguerenewal.game;

import com.davidhabot.adenleaguerenewal.entity.Actor;
import com.davidhabot.adenleaguerenewal.graphics.ScreenController;
import com.davidhabot.adenleaguerenewal.level.Level;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameData {
    private static final long serialVersionUID = 1L; //직렬화 명시
    @Getter
    private ScreenController screenControl; //BufferedImage 를 통한 화면 출력 컨트롤러
    @Getter
    private JFrame frame; //Image 에 텍스트 등의 부가 정보를 넣기 위해 생성
    @Getter
    private List<Actor> actors; //게임에서 키보드를 통해 실제로 움직일 수 있는 개체(Entity)들
    @Getter
    private List<Level> levels; //게임에 존재하는 모든 맵

    //GameData 내의 모든 변수를 초기화한다.
    public GameData() {
        this.screenControl = new ScreenController();
        this.frame = new JFrame();
        //actor 와 level 은 거의 삭제되지 않으므로 ArrayList 를 채용
        this.actors = new ArrayList<>();
        this.levels = new ArrayList<>();
    }

    //Actor 를 추가한다
    public void addActor(Actor actor) {
        this.actors.add(actor);
    }

    //Level 을 추가한다
    public void addLevel(Level level) {
        this.levels.add(level);
    }
}
