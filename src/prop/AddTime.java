package prop;

import level.Level;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * 加时道具：剩余时间加10s
 */
public class AddTime extends BaseProp {

    public AddTime(Level level) {
        super(level);
        name = "加时";
        try {
            image = ImageIO.read(new File("images/background/Background01.jpg"));
        }catch (Exception var1){
            var1.printStackTrace();
        }
    }

    @Override
    public void run() {
        super.run();
        level.surplusTime +=10000;
    }
}
