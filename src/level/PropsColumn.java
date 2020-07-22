package level;

import prop.BaseProp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * 该类为关卡道具栏
 * 在受到点击时调用对应prop的run方法
 */
public class PropsColumn extends JLabel{
    int count=0;
    ArrayList<JLabel> labels=new ArrayList<>();
    ArrayList<BaseProp> baseProps=new ArrayList<>();

    public PropsColumn(BaseProp ...props) {
        setBounds(100,0,450,40);
        for (BaseProp prop :props) {
            ImageIcon image = new ImageIcon(prop.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
            JLabel label = new JLabel();
            label.setBounds(100+100*count,5,100,35);
            count++;
            label.setIcon(image);
            label.setText(prop.getName()+"*"+prop.getCount());
            labels.add(label);
            baseProps.add(prop);
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

    /**
     * 更新道具栏信息
     */
    public void updateColumn(){
        for (int i=0;i<labels.size();i++){
            labels.get(i).setText(baseProps.get(i).getName()+"*"+baseProps.get(i).getCount());
        }
    }
}
