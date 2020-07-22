package block;

import level.Level;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ConnectLine {
    Level level;
    static final int STRAIGHT_X =0;
    static final int STRAIGHT_Y =1;
    BufferedImage image;
    int x;
    int y;
    int state;
    int time=0;

    /**
     *
     * @param state 横或竖
     * @param x map中横坐标
     * @param y map中纵坐标
     */
    public ConnectLine(Level level,int state, int x, int y){
        //todo state决定朝向
        this.level = level;
        image=Level.lineImages[state];
        this.x=x;
        this.y=y;
    }
    public void drawSelf(Graphics g){
        time+=10;
        g.drawImage(image, Level.startX+x*Level.BLOCK_WIDTH,
                Level.startY+y*Level.BLOCK_HEIGHT,null);
        if(time == 1000){
            level.connectLines.remove(this);
        }
    }
}
