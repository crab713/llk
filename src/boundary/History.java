package boundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class History extends BaseBoundary {
	ImageIcon block6;
	JButton back;
	ImageIcon block4;

	public History(JFrame frame) {
		super(frame);
		block6 = new ImageIcon("images/history_bg.jpg");
		block4 = new ImageIcon("images/block4.png");
		back = new JButton("返回");
		back.setBounds(0, 0, 80, 40);
		block4.getImage();
		Image temp = block4.getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT);
		block4 = new ImageIcon(temp);
		back.setIcon(block4);
		back.addActionListener(new Mylisener(this));
		add(back);

	}



    @Override
    public void paintComponent(Graphics g) {
	    g.drawImage(block6.getImage(), 0, 0, null);
    	g.setFont(new Font("宋体", Font.PLAIN, 30));
	    g.drawString("第1关： "+   "分", 150, 50);
	    g.drawString("第2关： "+   "分", 150, 150);
	    g.drawString("第3关： "+   "分", 150, 250);
	    g.drawString("第4关： "+   "分", 150, 350);
	    g.drawString("第5关： "+   "分", 150, 450);
	    g.drawString("第6关： "+   "分", 450, 50);
	    g.drawString("第7关： "+   "分", 450, 150);
	    g.drawString("第8关： "+   "分", 450, 250);
	    g.drawString("第9关： "+   "分", 450, 350);
    }
    class Mylisener implements ActionListener{
    	BaseBoundary boundary;
    	public Mylisener(BaseBoundary boundary) {
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