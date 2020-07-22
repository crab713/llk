package prop;

import block.Block;
import level.Level;
import start.Game;
import utils.MusicStuff;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.Random;

/**
 * 重列道具 ： 重新排列剩下的方块
 */
public class Refresh extends BaseProp {
    MusicStuff MS=new MusicStuff();
    public Refresh(Level level) {
        super(level);
        name = "重列";
        try {
            image = ImageIO.read(new File("images/prop/Refresh-1.jpg"));
        }catch (Exception var1){
            var1.printStackTrace();
        }
    }

    @Override
    public void run() {
        super.run();
        Random random=new Random();
        if(Game.isPlay){
            MS.playOnce("music/Refresh.wav");
        }
        for(int i=0;i<level.blocks.size();i++){
            Block block1 = level.blocks.get(random.nextInt(level.blocks.size()));
            Block block2 = level.blocks.get(random.nextInt(level.blocks.size()));
            swap(block1, block2);
        }
    }

    private void swap(Block block1,Block block2){
        int m,n,k;
        m = block1.getMapX();
        n = block1.getMapY();
        k = level.map[n][m];
        block1.setMapX(block2.getMapX());
        block1.setMapY(block2.getMapY());
        level.map[n][m] = level.map[block2.getMapY()][block2.getMapX()];
        level.map[block2.getMapY()][block2.getMapX()] = k;
        block2.setMapX(m);
        block2.setMapY(n);
        block1.update();
        block2.update();
    }
}
