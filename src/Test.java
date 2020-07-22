import utils.MusicStuff;
import utils.RankIOUtil;

import java.util.Timer;
import java.util.TimerTask;

public class Test {

    public static void main(String[] args) {

        MusicStuff musicStuff=new MusicStuff();
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                musicStuff.playOnce("music/refresh.wav");
            }
        },0,400);
    }
}
