package boundary;

import level.Level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseLevelBoundary extends BaseBoundary {
	ImageIcon background;
	ImageIcon block4;
	ImageIcon block5;

	public ChooseLevelBoundary(JFrame frame) {
		super(frame);
		background = new ImageIcon("images/bg.png");
		block4 = new ImageIcon("images/block4.png");
		block5 = new ImageIcon("images/block5.png");

		JButton jb1 = new JButton("1");
		jb1.setForeground(Color.white);
		jb1.setBackground(Color.orange);
		jb1.setBounds(130, 130, 60, 40);
		jb1.addActionListener(new MyListener(this));
		add(jb1);

		JButton jb2 = new JButton("2");
		jb2.setForeground(Color.white);
		jb2.setBackground(Color.orange);
		jb2.setBounds(220, 130, 60, 40);
		jb2.addActionListener(new MyListener(this));
		add(jb2);

		JButton jb3 = new JButton("3");
		jb3.setForeground(Color.white);
		jb3.setBackground(Color.orange);
		jb3.setBounds(310, 130, 60, 40);
		jb3.addActionListener(new MyListener(this));
		add(jb3);

		JButton jb4 = new JButton("4");
		jb4.setForeground(Color.white);
		jb4.setBackground(Color.orange);
		jb4.setBounds(400, 130, 60, 40);
		jb4.addActionListener(new MyListener(this));
		add(jb4);

		JButton jb5 = new JButton("5");
		jb5.setForeground(Color.white);
		jb5.setBackground(Color.orange);
		jb5.setBounds(490, 130, 60, 40);
		jb5.addActionListener(new MyListener(this));
		add(jb5);

		JButton jb6 = new JButton("6");
		jb6.setForeground(Color.white);
		jb6.setBackground(Color.orange);
		jb6.setBounds(130, 220, 60, 40);
		jb6.addActionListener(new MyListener(this));
		add(jb6);

		JButton jb7 = new JButton("7");
		jb7.setForeground(Color.white);
		jb7.setBackground(Color.orange);
		jb7.setBounds(220, 220, 60, 40);
		jb7.addActionListener(new MyListener(this));
		add(jb7);

		JButton jb8 = new JButton("8");
		jb8.setForeground(Color.white);
		jb8.setBackground(Color.orange);
		jb8.setBounds(310, 220, 60, 40);
		jb8.addActionListener(new MyListener(this));
		add(jb8);

		JButton jb9 = new JButton("9");
		jb9.setForeground(Color.white);
		jb9.setBackground(Color.orange);
		jb9.setBounds(400, 220, 60, 40);
		jb9.addActionListener(new MyListener(this));
		add(jb9);
 
		JButton back = new JButton("返回");
		back.setBounds(0, 0, 80, 40);
		block4.getImage();
		Image temp = block4.getImage().getScaledInstance(250,200, Image.SCALE_DEFAULT);
		block4 = new ImageIcon(temp);
		back.setIcon(block4);
		
		back.addActionListener(new BackListener(this));
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
