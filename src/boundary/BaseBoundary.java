package boundary;

import javax.swing.*;
import java.awt.*;

public class BaseBoundary extends JPanel {
    JFrame frame;

    public BaseBoundary(JFrame frame) {
        this.frame = frame;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
