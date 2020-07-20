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

    public void delete(){

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