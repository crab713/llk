package level;

import block.Block;
import prop.BaseProp;
import start.Game;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;

public class BaseLevel extends JPanel {
    public final static int BLOCK_WIDTH=1;
    public final static int BLOCK_HEIGHT=1;

    JFrame frame;
    Block block;
    ArrayList<Block> blocks=new ArrayList<>();
    Timer timer;
    int time=120*1000;
    int surplusTime=time;
    int[][] map={
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
    static BufferedImage[] blockImages=new BufferedImage[0];

    static {
        try {
            background = ImageIO.read(new File("images/level/background.jpg"));
            for(int i=0;i<blockImages.length;i++){
                blockImages[i] = ImageIO.read(new File("images/block/block"+i+".png"));
            }
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
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

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
        int index=0;
        Random random=new Random();
        for(i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(map[i][j] != 0){
                    Block block = new Block(this,j,i);
                    index = random.nextInt(blockKind);
                    while(notCreate[index] <= 0){
                        index = (index+1)%notCreate.length;
                    }
                    block.setSize(BLOCK_WIDTH, BLOCK_HEIGHT);
                    block.setIcon(new ImageIcon(blockImages[index].getScaledInstance(BLOCK_WIDTH,BLOCK_HEIGHT,Image.SCALE_DEFAULT)));
                    map[i][j]=index;
                    blocks.add(block);
                }
            }
        }
        // TODO : 绘制(另起一方法）
    }

    public void gameOver(){

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.drawImage(image,0,40,Game.WIDTH,Game.HEIGHT,null);
    }
}
