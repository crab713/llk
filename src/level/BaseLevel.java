package level;

import block.Block;
import boundary.BaseBoundary;
import prop.BaseProp;
import start.Game;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;

public class BaseLevel extends JPanel {
    public int BLOCK_WIDTH=50;
    public int BLOCK_HEIGHT=50;

    JFrame frame;
    public Block block;
    public ArrayList<Block> blocks=new ArrayList<>();
    Timer timer;
    int time=120*1000;
    public int surplusTime=time;
    public int[][] map={
            {0,0,0,0,0,0,0,0},
            {0,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,0},
            {0,0,0,0,0,0,0,0}
    };

    int score=0;
    JLabel scoreLabel;

    private static BufferedImage background;
//    static BufferedImage[] blockImages=new BufferedImage[0];
    // TODO : 图片资源
    static {
        try {
            background = ImageIO.read(new File("images/level/background.jpg"));
//            for(int i=0;i<blockImages.length;i++){
//                blockImages[i] = ImageIO.read(new File("images/block/block"+i+".png"));
//            }
        }catch (Exception var1){
            var1.printStackTrace();
        }
    }

    public BaseLevel(JFrame frame) {
        super(null);
        this.frame = frame;

        // 得分栏
        scoreLabel = new JLabel();
        Font font = new Font("微软雅黑",Font.BOLD,16);
        scoreLabel.setFont(font);
        scoreLabel.setText("得分： "+score);
        scoreLabel.setBounds(0,0,100,40);
        add(scoreLabel);

        // 道具栏
        BaseProp prop=new BaseProp(this);
        prop.setImage(background);
        prop.setName("hello");
        PropsColumn propsColumn = new PropsColumn(prop);
        add(propsColumn);

        // 退出游戏
        JButton button = new JButton("结束关卡");
        button.setBounds(680,10,100,30);
        add(button);
        button.addActionListener(new MyButtonAction(this));

        // 倒计时 && 剩余方块
        JLabel label = new JLabel();
        label.setFont(font);
        label.setBounds(20,500,80,35);
        label.setText("倒计时： ");
        add(label);
        JLabel countdown = new JLabel();
        countdown.setBounds(100,510,500,20);
        countdown.setIcon(new ImageIcon(background));
        add(countdown);
        JLabel surplus = new JLabel();
        surplus.setBounds(620,500,120,35);
        surplus.setFont(font);
        surplus.setText("剩余方块： "+blocks.size());
        add(surplus);

        // 计时器任务
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                surplusTime--;
                if (surplusTime <= time){
                    countdown.setSize(500*surplusTime/time,20);
                }else {
                    countdown.setSize(500,20);
                }

                surplus.setText("剩余方块： "+blocks.size());

            }
        },0L,1L);
    }

    /**
     *
     * @param blockKind 多少种图片,需在子类关卡构造函数中调用
     * @throws Exception 奇数方块
     */
    public void initBlock(int blockKind) throws Exception {
        int n=0;
        for (int[] a : map) {
            for (int b : a) {
                if (b == 1)
                    n++;
            }
        }
        if(n%2 != 0){
            System.out.println("can not init block");
            throw new Exception("can not init block");
        }
        int[] notCreate = new int[blockKind];
        int i=0;
        while (n > 0){
            notCreate[i] += 2;
            n -= 2;
            i = (i+1)%blockKind;
        }

        // 随机分配序号，坐标，入list
        int index;
        Random random=new Random();
        for(i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(map[i][j] != 0){
                    Block block = new Block(this,j,i);
                    index = random.nextInt(blockKind);
                    while(notCreate[index] <= 0){
                        index = (index+1)%notCreate.length;
                    }
                    notCreate[index]--;
                    block.setSize(BLOCK_WIDTH, BLOCK_HEIGHT);
                    block.update();
                    block.setIcon(new ImageIcon(background.getScaledInstance(BLOCK_WIDTH,BLOCK_HEIGHT,Image.SCALE_DEFAULT)));
                    map[i][j]=index;
                    blocks.add(block);
                    add(block);
                    System.out.println(block.getX()+" "+block.getY());
                }
            }
        }
    }



    public void gameOver(){
        // TODO : 结束关卡，进入关卡结算界面
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.drawImage(image,0,40,Game.WIDTH,Game.HEIGHT,null);
    }

    /**
     * 退出游戏按钮事件监听
     */
    private class MyButtonAction implements ActionListener {
        BaseLevel level;
        MyButtonAction(BaseLevel level){
            super();
            this.level = level;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            frame.remove(level);
            level.timer.cancel();
            frame.add(new BaseBoundary(frame));
            frame.setVisible(true);
        }
    }
}
