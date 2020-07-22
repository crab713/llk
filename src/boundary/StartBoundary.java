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
		block1 = new ImageIcon("images/bt_start.png");
		block2 = new ImageIcon("images/bt_record.png");
		block3 = new ImageIcon("images/bt_setting.png");

		star = new JButton("开始游戏");
		star.setBounds(270, 110, 235, 85);
		block1.getImage();
		Image temp = block1.getImage().getScaledInstance(235,85, Image.SCALE_DEFAULT);
		block1 = new ImageIcon(temp);
		star.setIcon(block1);
		star.addActionListener(new MyActionListener(this));
		star.setContentAreaFilled(false);//按钮边框隐藏
		star.setBorderPainted(false);
		add(star);

		history = new JButton("历史榜单");
		history.setBounds(100, 220, 235, 85);
		block2.getImage();
		Image temp2 = block2.getImage().getScaledInstance(235, 85, Image.SCALE_DEFAULT);
		block2 = new ImageIcon(temp2);
		history.setIcon(block2);
		history.addActionListener(new MyActionListener(this));
		history.setContentAreaFilled(false);//按钮边框隐藏
		history.setBorderPainted(false);
		add(history);

		setup = new JButton("设置");
		setup.setBounds(450, 212, 235, 85);
		block2.getImage();
		Image temp3 = block3.getImage().getScaledInstance(235, 85, Image.SCALE_DEFAULT);
		block3 = new ImageIcon(temp3);
		setup.setIcon(block3);
		setup.addActionListener(new MyActionListener(this));
		setup.setContentAreaFilled(false);//按钮边框隐藏
		setup.setBorderPainted(false);
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
