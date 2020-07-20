package level;


import javax.swing.*;

public class level1 extends BaseLevel {

    public level1(JFrame frame) {
        super(frame);
        map = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        try {
            initBlock(1);
        }catch (Exception ignored){

        }
    }

}
