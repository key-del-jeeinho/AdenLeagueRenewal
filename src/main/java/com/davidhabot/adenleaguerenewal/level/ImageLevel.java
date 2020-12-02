package com.davidhabot.adenleaguerenewal.level;

import com.davidhabot.adenleaguerenewal.exception.WrongCoordinateException;
import com.davidhabot.adenleaguerenewal.graphics.Screen;
import com.davidhabot.adenleaguerenewal.level.tile.Tile;
import com.davidhabot.adenleaguerenewal.level.tile.TileLoader;
import com.davidhabot.adenleaguerenewal.level.tile.TileType;
import lombok.NonNull;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLevel extends Level {
    //이미지의 주소를 초기화하는 이미지 레벨 클래스의 기본 생성자
    public ImageLevel (String path) {
        super(path);
    }

    //이미지의 주소를 매개변수로 받아 해당 주소에있는 이미지를 통해 레벨을 불러온다
    @Override
    protected void loadLevel(String path) {
        System.out.println("레벨파일 로딩중...");
        try {
            BufferedImage img = ImageIO.read(ImageLevel.class.getResource(path));
            int width = img.getWidth();
            int height = img.getHeight();
            super.setWidth(width);
            super.setHeight(height);
            level = new int[width * height];
            img.getRGB(0, 0, width, height, level, 0, width);
            //for(int i = 0; i < level.length; i++)
            //    level[i] = 0xFFFFFF & level[i];
            System.out.println("레벨파일 로딩성공.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception 발생! 레벨 파일을 불러올 수 없습니다.");
        }
    }

    @Override
    protected void generateLevel() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render(@NonNull Screen screen) throws WrongCoordinateException {
        int posAX = (super.x - (screen.getWidth()/2)); //해당 좌표를 중심으로하는 스크린의 좌측 상단의 X 좌표
        int posAY = (super.y - (screen.getHeight()/2)); //해당 좌표를 중심으로 하는 스크린 좌측 상단의 Y 좌표
        int posBX = (super.x + (screen.getWidth()/2)); //해당 좌표를 중심으로하는 스크린의 좌측 상단의 X 좌표
        int posBY = (super.y + (screen.getHeight()/2)); //해당 좌표를 중심으로 하는 스크린 좌측 상단의 Y 좌표


        if(super.x < 0 && super.y < 0) //맵 중앙의 좌표가 0 미만(음수)일경우 = 플레이어가 맵 밖으로 벗어났을경우
            throw new WrongCoordinateException("맵의 중앙좌표가 음수입니다!"); //좌표오류 예외를 던져 핸들링을 호출 클래스에 위임한다

        for(int y = 0; y < screen.getHeight(); y++) {
            for(int x = 0; x < screen.getWidth(); x++) {
                /*getTile 메서드로 타일 좌표를 넘겨 타일을 가져온뒤 실제좌표값을 타일의 크기로 나누어 나온 나머지
                즉, 실제로 해당 스크린 픽셀에 그려질 타일의 한 픽셀의 색상을 가져와 스크린에 차례차례 저장한다*/
                screen.getScreen()[x + y * screen.getHeight()] =
                        getTile((posAX + x)/tileWidth+1,(posAY + y)/tileHeight+1).getSprite().getPixels()
                                [(((x + posAX) % 16 + 16) % 16) + (((y + posAY) % 16 + 16) % 16) * tileHeight];
            }
        }

    }

    //해당 맵의 y행 x열에 있는 타일을 불러온다 만약 타일을 찾지 못할경우 void 타일을 리턴한다
    public Tile getTile(int x, int y) {
        if(x > 0 && y > 0) { //좌표가 올바를 경우에만 타일을 검사하고, 그렇지 않을경우(좌표가 음수일경우) VoidTile 을 반환한다
            for(Tile tile : TileLoader.getTiles()) { //게임내 존재하는 모든 타일을 타일로더에서 불러와 타일에 집어넣는다
                if ((level[x + y * getWidth()]) == tile.getColor()) { //게임 맵에서 타일 식별용으로 저장된 색상을 가져와 타일의 식별색과 비교한다
                    return tile;//만약 해당 좌표에 있는 식별색이 해당 타일의 식별색과 같다면 해당 타일을 반환한다
                }
            }
        }
        return TileLoader.getTile(TileType.VOID);//식별색을 인식하지 못하거나 좌표가 올바르지 않는등의 예외상황에는 VoidTile 을 반환한다.
    }
}
