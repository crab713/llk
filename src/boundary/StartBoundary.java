package boundary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartBoundary extends BaseBoundary {
    JButton star;
    JButton history;
    JButton setup;

    public StartBoundary(JFrame frame) {
        super(frame);
        star = new JButton("开始游戏");
        star.setBounds(300, 100, 200, 50);
        star.addActionListener(new MyActionListener(this));
        add(star);


//        history = new JButton("历史榜单");
//        history.setBounds(300, 190, 200, 50);
//        history.addActionListener(actionlisener);
//
//
//        setup = new JButton("设置");
//        setup.setBounds(300, 280, 200, 50);
//        setup.addActionListener(actionlisener);
    }
}

/**
 * 按钮事件监听器
 */
class MyActionListener implements ActionListener{
    BaseBoundary boundary;

    public MyActionListener(BaseBoundary boundary) {
        this.boundary = boundary;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("开始游戏".equals(e.getActionCommand())) {
            //移除当前界面，跳转至选择关卡界面
            boundary.frame.remove(boundary);
            boundary.frame.add(new ChooseLevelBoundary(boundary.frame));
            boundary.frame.setVisible(true);
        }
    }
}
