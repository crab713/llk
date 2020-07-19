package level;

import prop.BaseProp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * 该类为关卡道具栏
 * 在受到点击时调用对应prop的run方法
 */
public class PropsColumn extends JLabel{
    int count=0;

    public PropsColumn(BaseProp ...props) {
        setBounds(100,0,400,40);
        for (BaseProp prop :props) {
            ImageIcon image = new ImageIcon(prop.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
            JLabel label = new JLabel();
            label.setBounds(100+80*count,5,80,35);
            count++;
            label.setIcon(image);
            label.setText(prop.getName()+"*"+prop.getCount());
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    if(prop.getCount() > 0){
                        prop.setCount(prop.getCount() - 1);
                        label.setText(prop.getName()+"*"+prop.getCount());
                        prop.run();
                    }
                }
            });
            add(label);
        }
    }


}
