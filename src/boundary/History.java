package boundary;

import utils.RankIOUtil;

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
		block6 = new ImageIcon("images/history_bg/his-bg.png");
		block4 = new ImageIcon("images/bt_back.png");
		back = new JButton("返回");
		back.setBounds(0, 0, 157, 57);
		block4.getImage();
		Image temp = block4.getImage().getScaledInstance(157, 57, Image.SCALE_DEFAULT);
		block4 = new ImageIcon(temp);
		back.setIcon(block4);
		back.addActionListener(new Mylisener(this));
		back.setContentAreaFilled(false);//按钮边框隐藏
		back.setBorderPainted(false);
		add(back);

	}



    @Override
    public void paintComponent(Graphics g) {
	    g.drawImage(block6.getImage(), 0, 0, null);
    	g.setFont(new Font("微软雅黑", Font.PLAIN, 30));
	    g.drawString("第1关： "+ RankIOUtil.readOneLevel(1)+"分", 150, 50);
	    g.drawString("第2关： "+ RankIOUtil.readOneLevel(2)+"分", 150, 150);
	    g.drawString("第3关： "+ RankIOUtil.readOneLevel(3)+"分", 150, 250);
	    g.drawString("第4关： "+ RankIOUtil.readOneLevel(4)+"分", 150, 350);
	    g.drawString("第5关： "+ RankIOUtil.readOneLevel(5)+"分", 150, 450);
	    g.drawString("第6关： "+ RankIOUtil.readOneLevel(6)+"分", 450, 50);
	    g.drawString("第7关： "+ RankIOUtil.readOneLevel(7)+"分", 450, 150);
	    g.drawString("第8关： "+ RankIOUtil.readOneLevel(8)+"分", 450, 250);
	    g.drawString("第9关： "+ RankIOUtil.readOneLevel(9)+"分", 450, 350);
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