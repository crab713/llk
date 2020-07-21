package boundary;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameOverBoundary extends BaseBoundary{
	ImageIcon block4;
	JButton back;
    public GameOverBoundary(JFrame frame,int score) {
        super(frame);
        JLabel label = new JLabel("得分："+score);
        label.setBounds(300,200,100,40);
        add(label);
        
        back = new JButton("返回");
        block4 = new ImageIcon("images/block4.png");
		back = new JButton("返回");
		back.setBounds(0, 0, 80, 40);
		block4.getImage();
		Image temp = block4.getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT);
		block4 = new ImageIcon(temp);
		back.setIcon(block4);
		back.addActionListener(new MyListener(this));
		add(back);
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
