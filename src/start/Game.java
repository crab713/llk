package start;

import boundary.StartBoundary;
import level.Level;

import javax.swing.*;

public class Game extends JFrame {
    public final static int WIDTH=800;
    public final static int HEIGHT=600;

    Game(){
        super("flying shoot");
        setSize(WIDTH,HEIGHT);

        add(new StartBoundary(this));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println();
    }
}
