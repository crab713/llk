package boundary;

import level.Level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utils.MusicStuff;

public class SettingBoundary extends BaseBoundary {
    ImageIcon settingBG;//设置页面背景
    ImageIcon bgmON;//music
    ImageIcon bgmOFF;//music
    ImageIcon tipsBT;//tips
    ImageIcon tipsWD;//tips界面
    ImageIcon back;//返回
    ImageIcon tipsBack;//提示的返回
    JButton musicON;//音乐按键
    JButton musicOFF;//音乐按键
    JButton tips;//提示按键
    JButton backBT;//返回按键
    JButton tipsBackBT;//提示的返回按键
    JLabel tipsWord;//提示页面


    public SettingBoundary(JFrame frame) {
        super(frame);

        settingBG = new ImageIcon("images/setting/setting-bg.png");
        bgmON = new ImageIcon("images/setting/bgm-on.png");
        bgmOFF = new ImageIcon("images/setting/bgm-off.png");
        tipsBT = new ImageIcon("images/setting/tips-1.png");
        tipsWD =new ImageIcon("images/setting/tips-2.png");
        back=new ImageIcon("images/bt-back.png");
        tipsBack=new ImageIcon("images/bt-back.png");
        // 返回按钮
        backBT = new JButton("backBT");
        backBT.setBounds(0, 0, 200, 100);
        back.getImage();
        Image tempBack = back.getImage().getScaledInstance(300, 150, Image.SCALE_DEFAULT);
        back = new ImageIcon(tempBack);
        backBT.setIcon(back);
        backBT.addActionListener(new MyActionListener(this));
        backBT.setContentAreaFilled(false);//按钮边框隐藏
        backBT.setBorderPainted(false);
        add(backBT);

        tipsBackBT = new JButton("tipsBackBT");
        tipsBackBT.setBounds(461, 50, 200, 100);
        tipsBack.getImage();
        Image tempTipsBack = tipsBack.getImage().getScaledInstance(300, 150, Image.SCALE_DEFAULT);
        tipsBack = new ImageIcon(tempTipsBack);
        tipsBackBT.setIcon(tipsBack);
        tipsBackBT.addActionListener(new MyActionListener(this));
        tipsBackBT.setContentAreaFilled(false);//按钮边框隐藏
        tipsBackBT.setBorderPainted(false);
        add(tipsBackBT);
        tipsBackBT.setVisible(false);

        // 音乐开关
        musicON = new JButton("musicON");
        musicON.setBounds(100, 200, 170, 180);
        bgmON.getImage();
        Image temp1 = bgmON.getImage().getScaledInstance(170, 180, Image.SCALE_DEFAULT);
        bgmON = new ImageIcon(temp1);
        musicON.setIcon(bgmON);
        musicON.addActionListener(new MyActionListener(this));
        musicON.setContentAreaFilled(false);//按钮边框隐藏
        musicON.setBorderPainted(false);
        add(musicON);

        musicOFF = new JButton("musicOFF");
        musicOFF.setBounds(100, 200, 170, 180);
        bgmOFF.getImage();
        Image temp2 = bgmOFF.getImage().getScaledInstance(170, 180, Image.SCALE_DEFAULT);
        bgmOFF = new ImageIcon(temp2);
        musicOFF.setIcon(bgmOFF);
        musicOFF.addActionListener(new MyActionListener(this));
        musicOFF.setContentAreaFilled(false);//按钮边框隐藏
        musicOFF.setBorderPainted(false);
        add(musicOFF);
        musicOFF.setVisible(false);

        /**
         * 游戏提示
         */
        //按钮
        tips = new JButton("tips");
        tips.setBounds(400, 200, 170, 180);
        tipsBT.getImage();
        Image temp3 = tipsBT.getImage().getScaledInstance(170, 180, Image.SCALE_DEFAULT);
        tipsBT = new ImageIcon(temp3);
        tips.setIcon(tipsBT);
        tips.addActionListener(new MyActionListener(this));
        tips.setContentAreaFilled(false);//按钮边框隐藏
        tips.setBorderPainted(false);
        add(tips);

        //页面
        tipsWord=new JLabel();
        tipsWord.setBounds(10,20,561,500);
        tipsWD.getImage();
        Image temp4 = tipsWD.getImage().getScaledInstance(561, 500, Image.SCALE_DEFAULT);
        tipsWD=new ImageIcon(temp4);
        tipsWord.setIcon(tipsWD);

        add(tipsWord);
        tipsWord.setVisible(false);


    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(settingBG.getImage(), 0, 0, null);
    }
    /**
     * 按钮事件监听器
     */
    class MyActionListener implements ActionListener {
        BaseBoundary boundary;

        public MyActionListener(BaseBoundary boundary) {
            this.boundary = boundary;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            MusicStuff MS=new MusicStuff();
            if("musicON".equals(e.getActionCommand())) {
                musicOFF.setVisible(true);//off界面 亮
                musicON.setVisible(false);//on界面 暗
                //关闭声音
                MS.stop();

            }

            if("musicOFF".equals(e.getActionCommand())) {
                musicON.setVisible(true);//on界面 亮
                musicOFF.setVisible(true);//off界面 暗
                //开启声音
                MS.play("music/bgm.wav");
            }

            if("tips".equals(e.getActionCommand())){
                tipsWord.setVisible(true);//提示信息 亮
                tipsBackBT.setVisible(true);//提示返回按钮 亮
            }

            if("backBT".equals(e.getActionCommand())){
                boundary.frame.remove(boundary);
                boundary.frame.add(new StartBoundary(boundary.frame));
                boundary.frame.setVisible(true);
            }

            if("tipsBackBT".equals(e.getActionCommand())){
                tipsBackBT.setVisible(false);//提示 的返回按钮移除
                tipsWord.setVisible(false);//提示 移除
                //frame.remove(tipsBackBT); //提示 的返回按钮移除
                //frame.remove(tipsWord);   //提示 移除

            }
        }
    }

}
