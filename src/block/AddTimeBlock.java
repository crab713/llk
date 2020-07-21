package block;

import level.Level;

public class AddTimeBlock extends Block{
    public AddTimeBlock(Level level, int x, int y) {
        super(level, x, y);
    }

    @Override
    public void delete() {
        super.delete();
        level.addTime.setCount(level.addTime.getCount() + 1);
    }
}
