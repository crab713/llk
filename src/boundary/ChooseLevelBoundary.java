package boundary;

import javax.swing.*;

public class ChooseLevelBoundary extends BaseBoundary{

    public ChooseLevelBoundary(JFrame frame) {
        super(frame);
        System.out.println("ljko");

        JButton jb1 = new JButton("1");
        jb1.setBounds(130, 130, 60, 40);
        this.add(jb1);

        JButton jb2 = new JButton("2");
        jb2.setBounds(220, 130, 60, 40);
        this.add(jb2);

        JButton jb3 = new JButton("3");
        jb3.setBounds(310, 130, 60, 40);
        this.add(jb3);

        JButton jb4 = new JButton("4");
        jb4.setBounds(400, 130, 60, 40);
        this.add(jb4);

        JButton jb5 = new JButton("5");
        jb5.setBounds(490, 130, 60, 40);
        this.add(jb5);

        JButton jb6 = new JButton("6");
        jb6.setBounds(130, 220, 60, 40);
        this.add(jb6);

        JButton jb7 = new JButton("7");
        jb7.setBounds(220, 220, 60, 40);
        this.add(jb7);

        JButton jb8 = new JButton("8");
        jb8.setBounds(310, 220, 60, 40);
        this.add(jb8);

        JButton jb9 = new JButton("9");
        jb9.setBounds(400, 220, 60, 40);
        this.add(jb9);
    }


}
