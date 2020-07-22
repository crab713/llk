package boundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartBoundary extends BaseBoundary {
	JButton star;
	JButton history;
	JButton setup;
	ImageIcon background;
	ImageIcon block1;
	ImageIcon block2;
	ImageIcon block3;

	public StartBoundary(JFrame frame) {
		super(frame);
		background = new ImageIcon("images/game_bg/g-bg1.png");
		block1 = new ImageIcon("images/block1.png");
		block2 = new ImageIcon("images/block2.png");
		block3 = new ImageIcon("images/block3.png");

		star = new JButton("开始游戏");
		star.setBounds(300, 100, 200, 50);
		block1.getImage();
		Image temp = block1.getImage().getScaledInstance(235,200, Image.SCALE_DEFAULT);
		block1 = new ImageIcon(temp);
		star.setIcon(block1);
		star.addActionListener(new MyActionListener(this));
		add(star);

		history = new JButton("历史榜单");
		history.setBounds(300, 190, 200, 50);
		block2.getImage();
		Image temp2 = block2.getImage().getScaledInstance(235, 200, Image.SCALE_DEFAULT);
		block2 = new ImageIcon(temp2);
		history.setIcon(block2);
		history.addActionListener(new MyActionListener(this));
		add(history);

		setup = new JButton("设置");
		setup.setBounds(300, 280, 200, 50);
		block2.getImage();
		Image temp3 = block3.getImage().getScaledInstance(235, 200, Image.SCALE_DEFAULT);
		block3 = new ImageIcon(temp3);
		setup.setIcon(block3);
		add(setup);
	}



	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
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
        if("历史榜单".equals(e.getActionCommand())){
        	boundary.frame.remove(boundary);
        	boundary.frame.add(new History(boundary.frame));
            boundary.frame.setVisible(true);
        }
		if("设置".equals(e.getActionCommand())){
			boundary.frame.remove(boundary);
			boundary.frame.add(new SettingBoundary(boundary.frame));
			boundary.frame.setVisible(true);
		}
    }
}
}
