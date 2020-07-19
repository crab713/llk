package block;

import level.BaseLevel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Block extends JButton {
    BaseLevel level;

    int x;
    int y;

    public Block(BaseLevel level,int x,int y) {
        this.level = level;
        this.x = x;
        this.y = y;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
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
}
