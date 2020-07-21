package utils;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class MusicStuff {
    Clip clip;

    /**
     *
     * @param musicLocation 音乐路径，只能wav
     */
    public void play(String musicLocation) {
        try {
            File musicPath = new File(musicLocation);
            if(musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param n 音量改变量
     */
    public void setValue(float n){

        FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(n);
    }

    public void stop(){
        clip.stop();
    }

    public void start(){
        clip.start();
    }
}


