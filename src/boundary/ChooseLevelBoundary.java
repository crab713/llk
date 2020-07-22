package boundary;

import level.Level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseLevelBoundary extends BaseBoundary {
	ImageIcon background;
	ImageIcon back_bt;
	ImageIcon buttonimage1;
	ImageIcon buttonimage2;
	ImageIcon buttonimage3;
	ImageIcon buttonimage4;
	ImageIcon buttonimage5;
	ImageIcon buttonimage6;
	ImageIcon buttonimage7;
	ImageIcon buttonimage8;
	ImageIcon buttonimage9;

	public ChooseLevelBoundary(JFrame frame) {
		super(frame);
		background = new ImageIcon("images/level/level-bg.png");
		back_bt = new ImageIcon("images/bt_back.png");
		buttonimage1 = new ImageIcon("images/level/1.png");
		buttonimage2 = new ImageIcon("images/level/2.png");
		buttonimage3 = new ImageIcon("images/level/3.png");
		buttonimage4 = new ImageIcon("images/level/4.png");
		buttonimage5 = new ImageIcon("images/level/5.png");
		buttonimage6 = new ImageIcon("images/level/6.png");
		buttonimage7 = new ImageIcon("images/level/7.png");
		buttonimage8 = new ImageIcon("images/level/8.png");
		buttonimage9 = new ImageIcon("images/level/9.png");

		JButton jb1 = new JButton("1");
		jb1.setForeground(Color.white);
		jb1.setBackground(Color.orange);
		jb1.setBounds(180, 100, 100, 100);
		Image temp1 = buttonimage1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		buttonimage1 = new ImageIcon(temp1);
		jb1.setIcon(buttonimage1);
		jb1.addActionListener(new MyListener(this));
		jb1.setContentAreaFilled(false);//按钮边框隐藏
		jb1.setBorderPainted(false);
		add(jb1);

		JButton jb2 = new JButton("2");
		jb2.setForeground(Color.white);
		jb2.setBackground(Color.orange);
		jb2.setBounds(350, 100, 100, 100);
		Image temp2 = buttonimage2.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		buttonimage2 = new ImageIcon(temp2);
		jb2.setIcon(buttonimage2);
		jb2.addActionListener(new MyListener(this));
		jb2.setContentAreaFilled(false);//按钮边框隐藏
		jb2.setBorderPainted(false);
		add(jb2);

		JButton jb3 = new JButton("3");
		jb3.setForeground(Color.white);
		jb3.setBackground(Color.orange);
		jb3.setBounds(520, 100, 100, 100);
		Image temp3 = buttonimage3.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		buttonimage3 = new ImageIcon(temp3);
		jb3.setIcon(buttonimage3);
		jb3.addActionListener(new MyListener(this));
		jb3.setContentAreaFilled(false);//按钮边框隐藏
		jb3.setBorderPainted(false);
		add(jb3);

		JButton jb4 = new JButton("4");
		jb4.setForeground(Color.white);
		jb4.setBackground(Color.orange);
		jb4.setBounds(180, 270, 100, 100);
		Image temp4 = buttonimage4.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		buttonimage4 = new ImageIcon(temp4);
		jb4.setIcon(buttonimage4);
		jb4.addActionListener(new MyListener(this));
		jb4.setContentAreaFilled(false);//按钮边框隐藏
		jb4.setBorderPainted(false);
		add(jb4);

		JButton jb5 = new JButton("5");
		jb5.setForeground(Color.white);
		jb5.setBackground(Color.orange);
		jb5.setBounds(350, 270, 100, 100);
		Image temp5 = buttonimage5.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		buttonimage5 = new ImageIcon(temp5);
		jb5.setIcon(buttonimage5);
		jb5.addActionListener(new MyListener(this));
		jb5.setContentAreaFilled(false);//按钮边框隐藏
		jb5.setBorderPainted(false);
		add(jb5);

		JButton jb6 = new JButton("6");
		jb6.setForeground(Color.white);
		jb6.setBackground(Color.orange);
		jb6.setBounds(520, 270, 100, 100);
		Image temp6 = buttonimage6.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		buttonimage6 = new ImageIcon(temp6);
		jb6.setIcon(buttonimage6);
		jb6.addActionListener(new MyListener(this));
		jb6.setContentAreaFilled(false);//按钮边框隐藏
		jb6.setBorderPainted(false);
		add(jb6);

		JButton jb7 = new JButton("7");
		jb7.setForeground(Color.white);
		jb7.setBackground(Color.orange);
		jb7.setBounds(180, 450, 100, 100);
		Image temp7 = buttonimage7.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		buttonimage7 = new ImageIcon(temp7);
		jb7.setIcon(buttonimage7);
		jb7.addActionListener(new MyListener(this));
		jb7.setContentAreaFilled(false);//按钮边框隐藏
		jb7.setBorderPainted(false);
		add(jb7);

		JButton jb8 = new JButton("8");
		jb8.setForeground(Color.white);
		jb8.setBackground(Color.orange);
		jb8.setBounds(350, 450, 100, 100);
		Image temp8 = buttonimage8.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		buttonimage8 = new ImageIcon(temp8);
		jb8.setIcon(buttonimage8);
		jb8.addActionListener(new MyListener(this));
		jb8.setContentAreaFilled(false);//按钮边框隐藏
		jb8.setBorderPainted(false);
		add(jb8);

		JButton jb9 = new JButton("9");
		jb9.setForeground(Color.white);
		jb9.setBackground(Color.orange);
		jb9.setBounds(520, 450, 100, 100);
		Image temp9 = buttonimage9.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		buttonimage9 = new ImageIcon(temp9);
		jb9.setIcon(buttonimage9);
		jb9.addActionListener(new MyListener(this));
		jb9.setContentAreaFilled(false);//按钮边框隐藏
		jb9.setBorderPainted(false);
		add(jb9);

		JButton back = new JButton("返回");
		back.setBounds(0, 0, 235, 85);
		back_bt.getImage();
		Image temp = back_bt.getImage().getScaledInstance(235,85, Image.SCALE_DEFAULT);
		back_bt = new ImageIcon(temp);
		back.setIcon(back_bt);
		back.addActionListener(new BackListener(this));
		back.setContentAreaFilled(false);//按钮边框隐藏
		back.setBorderPainted(false);
		add(back);

	}



	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
	}

	static class BackListener implements ActionListener{
		BaseBoundary boundary;
		public BackListener(BaseBoundary boundary) {
			this.boundary = boundary;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if("返回".equals(e.getActionCommand())) {
				boundary.frame.remove(boundary);
				boundary.frame.add(new StartBoundary(boundary.frame));
				boundary.frame.setVisible(true);
			}
		}
	}

	static class MyListener implements ActionListener{
		BaseBoundary boundary;
		public MyListener(BaseBoundary boundary) {
			this.boundary = boundary;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			boundary.frame.remove(boundary);
			boundary.frame.add(new Level(boundary.frame,Integer.parseInt(e.getActionCommand())));
			boundary.frame.setVisible(true);
		}
	}
}
