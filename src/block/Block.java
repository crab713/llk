package block;

import level.BaseLevel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Block extends JButton {
    BaseLevel level;

    int mapX;
    int mapY;

    public Block(BaseLevel level,int x,int y) {
        super();
        this.level = level;
        this.mapX = x;
        this.mapY = y;
        addMouseListener(new MyMouseAdapter(this));
    }

    public Block() {
    }

    /**
     * 更新方块坐标
     */
    public void update(){
        setLocation(80+ level.BLOCK_WIDTH *mapX,80+ level.BLOCK_HEIGHT *mapY);
    }

    public void delete(){
        // TODO : 消除方块并且更新level.map里对应坐标的id为0
    }

    public boolean isConnect(Block block){
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public int getMapX() {
        return mapX;
    }

    public void setMapX(int mapX) {
        this.mapX = mapX;
    }

    public int getMapY() {
        return mapY;
    }

    public void setMapY(int mapY) {
        this.mapY = mapY;
    }
}

class MyMouseAdapter extends MouseAdapter {
    Block block;
    MyMouseAdapter(Block block){
        this.block = block;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
    }
}