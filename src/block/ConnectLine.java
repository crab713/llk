package block;

import level.Level;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ConnectLine {
    static final int STRAIGHT_X =0;
    static final int STRAIGHT_Y =1;
    BufferedImage image;
    int x;
    int y;
    int state;

    public ConnectLine() {
    }

    /**
     *
     * @param state 横或竖
     * @param x map中横坐标
     * @param y map中纵坐标
     */
    public ConnectLine(int state, int x, int y){
        //todo state决定朝向
    }
    public void drawSelf(Graphics g){
        g.drawImage(image, Level.startX+x*Level.BLOCK_WIDTH+Level.BLOCK_WIDTH/2,
                Level.startY+y*Level.BLOCK_HEIGHT+Level.BLOCK_HEIGHT/2,null);
    }
}
