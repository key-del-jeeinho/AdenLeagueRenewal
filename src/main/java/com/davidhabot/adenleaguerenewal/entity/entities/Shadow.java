package com.davidhabot.adenleaguerenewal.entity.entities;

import com.davidhabot.adenleaguerenewal.entity.Direction;
import com.davidhabot.adenleaguerenewal.entity.Entity;
import com.davidhabot.adenleaguerenewal.exception.WrongCoordinateException;
import com.davidhabot.adenleaguerenewal.game.Game;
import com.davidhabot.adenleaguerenewal.game.Updatable;
import com.davidhabot.adenleaguerenewal.game.UpdateManager;
import com.davidhabot.adenleaguerenewal.graphics.Renderable;
import com.davidhabot.adenleaguerenewal.graphics.Screen;
import com.davidhabot.adenleaguerenewal.graphics.Sprite;
import lombok.Getter;
import lombok.NonNull;

public class Shadow implements Entity, Updatable, Renderable {
    @Getter
    private Direction dir;
    @Getter
    private Sprite[] sprites;
    @Getter
    private final int x, y;
    private int anim;
    private int[] level;
    private boolean isActive;

    public Shadow(int x, int y, Sprite... sprites) {
        System.out.println(x + " | " + y);
        this.level = new int[64*64];
        this.sprites = sprites;
        this.x = x;
        this.y = y;
        this.isActive = true;
        UpdateManager.addUpdatable(this);//해당 클래스를 업데이트 매니저에 넣는다.
        Renderable.renderables.add(this);//해당 클래스를 렌더러블 리스트에 넣는다
    }

    @Override
    public void rotate(Direction dir) {
        this.dir = dir;
    }

    @Override
    public void update() {
        if(anim < 1200)
            anim++;
        else
            anim = 0;
        //System.out.println(x/16-1 + " | " + Game.data.getPlayer().getX()/16  + " - " + (y/16-1) + " | " + Game.data.getPlayer().getY()/16);
        if(isActive) {
            if (x/16-1 == Game.data.getPlayer().getX()/16 && y/16-1 == Game.data.getPlayer().getY()/16) {
                Game.addScore();
                isActive = false;
            }
        }
    }

    @Override
    public void render(@NonNull Screen screen) throws WrongCoordinateException {
        if(isActive) {
            int idx = 0;
            int playerX = Game.data.getPlayer().getX();
            int playerY = Game.data.getPlayer().getY();
            int screenLeftTopX = playerX - (screen.getWidth() / 2);//스크린 왼쪽 위 모서리의 X 절대좌표
            int screenLeftTopY = playerY - (screen.getHeight() / 2);//스크린 왼쪽 위 모서리의 Y 절대좌표;
            int screenRightBottomX = playerX + (screen.getWidth() / 2);//스크린 오른쪽 아래 모서리의 X 절대좌표
            int screenRightBottomY = playerY + (screen.getHeight() / 2);//스크린 오른쪽 아래 모서리의 Y 절대좌표

            if (screenLeftTopX < x-16 && screenRightBottomX > x+16 && screenLeftTopY < y-16 && screenRightBottomY > y+16) {
                for (int y = 0; y < sprites[idx].getHeight(); y++) {
                    for (int x = 0; x < sprites[idx].getWidth(); x++) {
                        int xx = this.x + x - screenLeftTopX;
                        int yy = this.y + y - screenLeftTopY;
                        int tile = sprites[idx].getPixels()[x + y * sprites[idx].getWidth()];
                        if (tile != 0xFF00FF) {
                            //System.out.println(xx + " - " + yy);
                            screen.getScreen()[xx + yy * screen.getWidth()] = tile;
                        }
                    }
                }
            }
        }
    }
}
