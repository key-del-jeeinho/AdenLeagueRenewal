package com.davidhabot.adenleaguerenewal.game;

import com.davidhabot.adenleaguerenewal.entity.Actor;
import com.davidhabot.adenleaguerenewal.entity.entities.Player;
import com.davidhabot.adenleaguerenewal.entity.entities.Shadow;
import com.davidhabot.adenleaguerenewal.graphics.ScreenController;
import com.davidhabot.adenleaguerenewal.graphics.SpriteLoader;
import com.davidhabot.adenleaguerenewal.level.ImageLevel;
import com.davidhabot.adenleaguerenewal.level.Level;
import com.davidhabot.adenleaguerenewal.level.tile.TileLoader;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameData implements Serializable {
    private static final long serialVersionUID = 1L; //직렬화 명시
    @Getter
    private ScreenController screenControl; //BufferedImage 를 통한 화면 출력 컨트롤러
    @Getter
    private JFrame frame; //Image 에 텍스트 등의 부가 정보를 넣기 위해 생성
    @Getter @Setter
    Player player;
    @Getter
    private List<Shadow> shadows; //게임에서 키보드를 통해 실제로 움직일 수 있는 개체(Entity)들
    @Getter
    private List<Level> levels; //게임에 존재하는 모든 맵

    //GameData 내의 모든 변수를 초기화한다.
    public GameData() {
        this.frame = new JFrame();
        //actor 와 level 은 거의 삭제되지 않으므로 ArrayList 를 채용
        this.shadows = new ArrayList<>();
        this.levels = new ArrayList<>();
        GameConfiguration cfg = Game.configuration;
        this.screenControl = new ScreenController(cfg.getWidth() * cfg.getScale(), cfg.getHeight() * cfg.getScale());
        SpriteLoader spriteLoader = new SpriteLoader();
        TileLoader tileLoader = new TileLoader(spriteLoader);
        levels.add(new ImageLevel("/texture/level.png"));
        /*SpriteGroup[] playerSprSet = new SpriteGroup[]{
                new SpriteGroup("player-stand-up", 10,
                        new Sprite(1, 0, 0, spriteLoader.character_player_move)),
                new SpriteGroup("player-stand-down", 10,
                        new Sprite(1, 2, 0, spriteLoader.character_player_move)),
                new SpriteGroup("player-stand-left", 10,
                        new Sprite(1, 1, 0, spriteLoader.character_player_move, true)),
                new SpriteGroup("player-stand-right", 10,
                        new Sprite(1, 1, 0, spriteLoader.character_player_move)),

                new SpriteGroup("player-move-up", 10,
                        new Sprite(1, 0, 1, spriteLoader.character_player_move),
                        new Sprite(1, 0, 2, spriteLoader.character_player_move)),
                new SpriteGroup("player-move-down", 10,
                        new Sprite(1, 2, 1, spriteLoader.character_player_move),
                        new Sprite(1, 0, 2, spriteLoader.character_player_move)),
                new SpriteGroup("player-move-left", 10,
                        new Sprite(1, 1, 1, spriteLoader.character_player_move),
                        new Sprite(1, 0, 2, spriteLoader.character_player_move)),
                new SpriteGroup("player-move-right", 10,
                        new Sprite(1, 1, 1, spriteLoader.character_player_move),
                        new Sprite(1, 0, 2, spriteLoader.character_player_move)),
        };*/
        player = (new Player(spriteLoader.player, 0, 0, 1,
                KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_SHIFT,
                KeyEvent.VK_Q,KeyEvent.VK_E, KeyEvent.VK_R,
                KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3));
        Random r = new Random();
        for(int i = 0; i < 15; i++) {
            Shadow shadow = new Shadow(r.nextInt(1000)+16, r.nextInt(1000)+16, spriteLoader.shadow);
            shadows.add(shadow);
        }
    }

    //Actor 를 추가한다
    public void addShadow(Shadow shadow) {
        this.shadows.add(shadow);
    }

    //Level 을 추가한다
    public void addLevel(Level level) {
        this.levels.add(level);
    }
}
