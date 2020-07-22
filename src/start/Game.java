package start;

import boundary.StartBoundary;
import level.Level;
import utils.MusicStuff;

import javax.swing.*;

public class Game extends JFrame {
    public final static int WIDTH=800;
    public final static int HEIGHT=600;
    public static boolean isPlay=true;

    public static MusicStuff MS=new MusicStuff();
    Game(){
        super("flying shoot");
        setSize(WIDTH,HEIGHT);

        add(new StartBoundary(this));

        MS.play("music/bgm.wav");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        Game game = new Game();
    }
}
