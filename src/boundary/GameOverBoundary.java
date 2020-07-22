package boundary;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameOverBoundary extends BaseBoundary{
	ImageIcon block4;
	ImageIcon bg;
	JButton back;
    public GameOverBoundary(JFrame frame,int score) {
        super(frame);
        bg=new ImageIcon("images/game_bg/g-bg2.png");
        JLabel label = new JLabel("得分："+score);
        label.setBounds(310,350,200,150);
        label.setFont(new Font("微软雅黑", Font.BOLD, 35));
        label.setForeground(Color.PINK);
        add(label);
        
        back = new JButton("返回");
        block4 = new ImageIcon("images/bt_back.png");
		back = new JButton("返回");
		back.setBounds(0, 0, 235, 85);
		block4.getImage();
		Image temp = block4.getImage().getScaledInstance(235, 85, Image.SCALE_DEFAULT);
		block4 = new ImageIcon(temp);
		back.setIcon(block4);
		back.addActionListener(new MyListener(this));
		back.setContentAreaFilled(false);//按钮边框隐藏
		back.setBorderPainted(false);
		add(back);
    }
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(bg.getImage(), 0, 0, null);
	}

    static class MyListener implements ActionListener{
    	BaseBoundary boundary;
    	public MyListener(BaseBoundary boundary) {
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

}
