package com.davidhabot.adenleaguerenewal.game;

import com.davidhabot.adenleaguerenewal.entity.Actor;
import com.davidhabot.adenleaguerenewal.entity.Player;
import com.davidhabot.adenleaguerenewal.graphics.ScreenController;
import com.davidhabot.adenleaguerenewal.graphics.Sprite;
import com.davidhabot.adenleaguerenewal.graphics.SpriteLoader;
import com.davidhabot.adenleaguerenewal.level.ImageLevel;
import com.davidhabot.adenleaguerenewal.level.Level;
import com.davidhabot.adenleaguerenewal.level.tile.TileLoader;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameData implements Serializable {
    private static final long serialVersionUID = 1L; //직렬화 명시
    @Getter
    private ScreenController screenControl; //BufferedImage 를 통한 화면 출력 컨트롤러
    @Getter
    private JFrame frame; //Image 에 텍스트 등의 부가 정보를 넣기 위해 생성
    @Getter @Setter
    Player player;
    @Getter
    private List<Actor> actors; //게임에서 키보드를 통해 실제로 움직일 수 있는 개체(Entity)들
    @Getter
    private List<Level> levels; //게임에 존재하는 모든 맵

    //GameData 내의 모든 변수를 초기화한다.
    public GameData() {
        this.frame = new JFrame();
        //actor 와 level 은 거의 삭제되지 않으므로 ArrayList 를 채용
        this.actors = new ArrayList<>();
        this.levels = new ArrayList<>();
        GameConfiguration cfg = Game.configuration;
        this.screenControl = new ScreenController(cfg.getWidth() * cfg.getScale(), cfg.getHeight() * cfg.getScale());
        SpriteLoader spriteLoader = new SpriteLoader();
        TileLoader tileLoader = new TileLoader(spriteLoader);
        levels.add(new ImageLevel("/texture/level.png"));
        player = (new Player(new Sprite[]{spriteLoader.player}, 0, 0, 1,
                KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_SHIFT,
                KeyEvent.VK_Q,KeyEvent.VK_E, KeyEvent.VK_R,
                KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3));
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
