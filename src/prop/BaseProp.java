package prop;

import level.BaseLevel;

import java.awt.image.BufferedImage;

public class BaseProp {
    BaseLevel level;
    BufferedImage image;
    String name;
    int count=10;

    public BaseProp(BaseLevel level) {
        this.level = level;
    }

    public void run(){

    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
