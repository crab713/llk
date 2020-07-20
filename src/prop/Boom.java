package prop;

import block.Block;
import level.BaseLevel;

import java.util.Random;

/**
 * “炸弹”道具:消除两个相同的block
 */
public class Boom extends BaseProp {

    public Boom(BaseLevel level) {
        super(level);
    }

    @Override
    public void run() {
        super.run();
        Random random=new Random();
        int index=random.nextInt(level.blocks.size());
        Block block = level.blocks.get(index);
        for(int i=0;i<level.blocks.size();i++){
            if(i == index) {
                continue;
            }
            Block block1 = level.blocks.get(i);
            if(level.map[block.getMapY()][block.getMapX()] == level.map[block1.getMapY()][block1.getMapX()]){
                block.delete();
                block1.delete();
                return;
            }
        }
    }
}