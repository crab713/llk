package prop;

import level.BaseLevel;

/**
 * 加时道具：剩余时间加10s
 */
public class AddTime extends BaseProp {

    public AddTime(BaseLevel level) {
        super(level);
    }

    @Override
    public void run() {
        super.run();
        level.surplusTime +=10000;
    }
}
