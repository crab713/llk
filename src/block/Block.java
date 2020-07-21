package block;

import level.Level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class Block extends JButton {
    Level level;

    int mapX;
    int mapY;

    public Block(Level level, int x, int y) {
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
        setLocation(level.startX+level.BLOCK_WIDTH *mapX,level.startY+level.BLOCK_HEIGHT *mapY);
    }

    public void delete(){
        level.map[mapY][mapX] = 0;
        level.blocks.remove(this);
        this.setVisible(false);
        level.remove(this);
        if(this.equals(level.block)){
            level.block = null;
        }
    }

    public boolean isConnect(Block block){
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Block)) return false;
        Block block = (Block) o;
        return mapX == block.mapX &&
                mapY == block.mapY &&
                Objects.equals(level, block.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, mapX, mapY);
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
        if(block.level.block == null){
            block.level.block = block;
            block.setEnabled(false);
        }else {
            // TODO : 被选中后变亮或回调
            // 如果两次点击均为相同方块时，则取消选中
            if(block.equals(block.level.block)){
                block.level.block = null;
                block.setEnabled(true);
                return;
            }
            if(block.isConnect(block.level.block)){
                //两个都删
                block.level.score += 10;
                block.level.block.delete();
                block.delete();
            }else {
                block.level.block.setEnabled(true);
                block.level.block = null;
            }
        }

    }
}