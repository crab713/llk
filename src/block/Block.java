package block;

import level.Level;
import level.LevelData;
import prop.Refresh;
import start.Game;
import utils.MusicStuff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class Block extends JButton {
    Level level;

    int mapX;
    int mapY;

    public final static int ADD_TIME =101;
    public final static int BOOM=102;
    public final static int REFRESH=103;

    public Block(Level level, int x, int y) {
        super();
        this.level = level;
        this.mapX = x;
        this.mapY = y;
        addMouseListener(new MyMouseAdapter(this));
    }

    /**
     * 更新方块坐标
     */
    public void update(){
        setLocation(Level.startX + Level.BLOCK_WIDTH *mapX, Level.startY + Level.BLOCK_HEIGHT *mapY);
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

    public boolean isConnect(int[][] copyMap,int beforeX,int beforeY,int x,int y,int inflection){
        if(x==mapX && y==mapY){
            return true;
        }
        if(y>copyMap.length-1 || y<0 || x>copyMap[0].length-1 || x<0){
            return false;
        }
        if(copyMap[y][x] == 0){
            copyMap[y][x] = -1;
            if(beforeX == x){
                if(inflection<=1 && isConnect(copyMap,x,y,x+1,y,inflection+(beforeY==y?0:1))){
                    return true;
                }else if(inflection<=1 && isConnect(copyMap,x,y,x-1,y,inflection+(beforeY==y?0:1))){
                    return true;
                }else if(inflection<=2 && beforeY != y+1 && isConnect(copyMap,x,y,x,y+1,inflection)){
                    return true;
                }else if(inflection<=2 && beforeY != y-1 && isConnect(copyMap,x,y,x,y-1,inflection)){
                    return true;
                }else {
                    copyMap[y][x]=0;
                }
            }
            if(beforeY == y){
                if(inflection<=2 && beforeX != x+1 && isConnect(copyMap,x,y,x+1,y,inflection)){
                    return true;
                }else if(inflection<=2 && beforeX != x-1 && isConnect(copyMap,x,y,x-1,y,inflection)){
                    return true;
                }else if(inflection<=1 && isConnect(copyMap,x,y,x,y+1,inflection+(beforeX==x?0:1))){
                    return true;
                }else if(inflection<=1 && isConnect(copyMap,x,y,x,y-1,inflection+(beforeX==x?0:1))){
                    return true;
                }else {
                    copyMap[y][x]=0;
                }
            }
        }
        return false;
    }

    public boolean isConnect(ArrayList<ConnectLine> lines,int[][] copyMap,int beforeX,int beforeY,int x,int y,int inflection){
        ConnectLine line;
        if(x==mapX && y==mapY){
            return true;
        }
        if(y>copyMap.length-1 || y<0 || x>copyMap[0].length-1 || x<0){
            return false;
        }
        if(copyMap[y][x] == 0){
            copyMap[y][x] = -1;
            if(beforeX == x){
                if(inflection<=1 && isConnect(lines,copyMap,x,y,x+1,y,inflection+(beforeY==y?0:1))){
                    line = new ConnectLine(level,y>beforeY?5:2,x,y);
                    lines.add(line);
                    return true;
                }else if(inflection<=1 && isConnect(lines,copyMap,x,y,x-1,y,inflection+(beforeY==y?0:1))){
                    line = new ConnectLine(level,y>beforeY?3:4,x,y);
                    lines.add(line);
                    return true;
                }else if(inflection<=2 && beforeY != y+1 && isConnect(lines,copyMap,x,y,x,y+1,inflection)){
                    line = new ConnectLine(level,0,x,y);
                    lines.add(line);
                    return true;
                }else if(inflection<=2 && beforeY != y-1 && isConnect(lines,copyMap,x,y,x,y-1,inflection)){
                    line = new ConnectLine(level,0,x,y);
                    lines.add(line);
                    return true;
                }else {
                    copyMap[y][x]=0;
                }
            }
            if(beforeY == y){
                if(inflection<=2 && beforeX != x+1 && isConnect(lines,copyMap,x,y,x+1,y,inflection)){
                    line = new ConnectLine(level,1,x,y);
                    lines.add(line);
                    return true;
                }else if(inflection<=2 && beforeX != x-1 && isConnect(lines,copyMap,x,y,x-1,y,inflection)){
                    line = new ConnectLine(level,1,x,y);
                    lines.add(line);
                    return true;
                }else if(inflection<=1 && isConnect(lines,copyMap,x,y,x,y+1,inflection+(beforeX==x?0:1))){
                    line = new ConnectLine(level,x>beforeX?4:2,x,y);
                    lines.add(line);
                    return true;
                }else if(inflection<=1 && isConnect(lines,copyMap,x,y,x,y-1,inflection+(beforeX==x?0:1))){
                    line = new ConnectLine(level,x>beforeX?3:5,x,y);
                    lines.add(line);
                    return true;
                }else {
                    copyMap[y][x]=0;
                }
            }
        }
        return false;
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
    static MusicStuff MS=new MusicStuff();
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
            // 如果两次点击均为相同方块时，则取消选中
            if(block.equals(block.level.block)){
                block.level.block = null;
                block.setEnabled(true);
                return;
            }
            // 初始化逻辑判断
            int secondX=block.level.block.mapX;
            int secondY=block.level.block.mapY;
            int[][] CopyMap = new int[LevelData.map[0].length][LevelData.map[0][0].length];
            for(int i=0;i<CopyMap.length;i++)
                for (int j=0;j<CopyMap[0].length;j++){
                    CopyMap[i][j]=block.level.map[i][j];
                }
            CopyMap[secondY][secondX]=0;
            ArrayList<ConnectLine> lines=new ArrayList<>();
            // 判断是否可以相连
            if(block.level.map[block.mapY][block.mapX] == block.level.map[secondY][secondX]){
                if(block.isConnect(lines,CopyMap,secondX,secondY,secondX,secondY,0)){
                    lines.remove(lines.size()-1);
                    // 画线
                    block.level.connectLines = lines;

                    //bgm
                    if (Game.isPlay) {
                        MS.playOnce("music/Connect.wav");
                    }
                    //得分 连击限时1.5s
                    if(block.level.scoreTime > 1500) {
                        block.level.scoreLevel = 0;
                    }
                    block.level.scoreTime = 0;
                    if(block.level.scoreLevel <= 4){
                        block.level.scoreLevel += 1;
                    }
                    block.level.score += 10*block.level.scoreLevel;

                    // 特殊方块
                    if(block.level.map[block.mapY][block.mapX] == Block.ADD_TIME){
                        block.level.addTime.addCount();
                    }
                    if(block.level.map[block.mapY][block.mapX] == Block.BOOM){
                        block.level.boom.addCount();
                    }
                    if(block.level.map[block.mapY][block.mapX] == Block.REFRESH){
                        block.level.refresh.addCount();
                    }
                    //两个都删
                    block.level.block.delete();
                    block.delete();
                    if (!block.level.checkConnection()){
                        Refresh refresh=new Refresh(block.level);
                        if(Game.isPlay){
                            Game.isPlay = false;
                            refresh.run();
                            Game.isPlay = true;
                        }
                    }
                }
            }
            if(block.level.block != null){
                block.level.block.setEnabled(true);
                block.level.block = null;
            }
        }
    }
}