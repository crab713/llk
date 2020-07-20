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
    }
}