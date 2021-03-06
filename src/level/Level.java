package level;

import block.Block;
import block.ConnectLine;
import boundary.GameOverBoundary;
import prop.AddTime;
import prop.Boom;
import prop.Refresh;
import start.Game;
import utils.RankIOUtil;

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

public class Level extends JPanel {
    public static int BLOCK_WIDTH=40;
    public static int BLOCK_HEIGHT=40;
    public static int startX=0;
    public static int startY=40;

    JFrame frame;
    public Block block;
    public ArrayList<Block> blocks=new ArrayList<>();
    public ArrayList<ConnectLine> connectLines=new ArrayList<>();
    Timer timer;
    final int time=120*1000; //初始时长
    public int surplusTime=time; //剩余时长
    public int scoreTime =0; //两次消除间过去的时长
    public int scoreLevel=1; //得分级数，基于连击
    public int[][] map;

    public int level;
    public int score=0;
    JLabel scoreLabel;
    public Boom boom;
    public Refresh refresh;
    public AddTime addTime;

    private static BufferedImage background;
    static BufferedImage[] blockImages=new BufferedImage[36];
    static BufferedImage timeImage;
    public static BufferedImage[] lineImages=new BufferedImage[6];
    static {
        try {
            background = ImageIO.read(new File("images/game_bg/g-bg1.png"));
            for(int i=0;i<blockImages.length;i++){
                blockImages[i] = ImageIO.read(new File("images/block/block"+i+".png"));
            }
            for(int i=0;i<lineImages.length;i++){
                lineImages[i] = ImageIO.read(new File("images/line/line"+i+".png"));
            }
            timeImage = ImageIO.read(new File("images/level/time.png"));
        }catch (Exception var1){
            var1.printStackTrace();
        }
    }

    /**
     *
     * @param frame 主窗体
     * @param level 要运行的关卡
     */
    public Level(JFrame frame, int level) {
        super(null);
        this.frame = frame;
        this.level = level;

        // 得分栏
        scoreLabel = new JLabel();
        Font font = new Font("微软雅黑",Font.BOLD,16);
        scoreLabel.setFont(font);
        scoreLabel.setText("得分： "+score);
        scoreLabel.setBounds(0,0,100,40);
        add(scoreLabel);

        // 道具栏
        boom=new Boom(this);
        addTime=new AddTime(this);
        refresh=new Refresh(this);
        PropsColumn propsColumn = new PropsColumn(boom,addTime,refresh);
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
        countdown.setIcon(new ImageIcon(timeImage.getScaledInstance(500,20,Image.SCALE_DEFAULT)));
        add(countdown);
        JLabel surplus = new JLabel();
        surplus.setBounds(620,500,120,35);
        surplus.setFont(font);
        surplus.setText("剩余方块： "+blocks.size());
        add(surplus);

        // 初始化地图
        map = new int[LevelData.map[0].length][LevelData.map[0][0].length];
        for(int i=0;i<map.length;i++)
            for (int j=0;j<map[0].length;j++){
                map[i][j]=LevelData.map[level-1][i][j];
            }
        try {
            initBlock(LevelData.initBlockKind[level-1]);
        }catch (Exception e){
            e.printStackTrace();
        }
        // 计时器任务
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                surplusTime-=10;
                scoreTime +=10;
                if (surplusTime <= time){
                    countdown.setSize(500*surplusTime/time,20);
                }else {
                    countdown.setSize(500,20);
                }
                surplus.setText("剩余方块： "+blocks.size());
                scoreLabel.setText("得分： "+score);
                propsColumn.updateColumn();
                repaint();
                if (surplusTime<=0 || blocks.size()==0){
                    gameOver();
                }
            }
        },100L,10L);
    }

    /**
     *
     * @param blockKind 多少种图片,需在子类关卡构造函数中调用
     * @throws Exception 奇数方块
     */
    public void initBlock(int blockKind) throws Exception {
        Random random=new Random();
        int n=0;
        for (int[] a : map) {
            for (int b : a) {
                if (b == 1)
                    n++;
            }
        }
        if(n%2 != 0){
            throw new Exception("can not init block");
        }

        initSpecialBlock(Block.ADD_TIME,2);
        initSpecialBlock(Block.BOOM,2);
        initSpecialBlock(Block.REFRESH,2);
        n -=6;
        int[] notCreate = new int[blockKind];
        int i=0;
        while (n > 0){
            notCreate[i] += 2;
            n -= 2;
            i = (i+1)%blockKind;
        }

        // 随机分配序号，坐标，入list
        int index;
        for(i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(map[i][j] == 1){
                    Block block = new Block(this,j,i);
                    index = random.nextInt(blockKind);
                    while(notCreate[index] <= 0){
                        index = (index+1)%notCreate.length;
                    }
                    notCreate[index]--;
                    block.setSize(BLOCK_WIDTH, BLOCK_HEIGHT);
                    block.update();
                    block.setIcon(new ImageIcon(blockImages[index].getScaledInstance(BLOCK_WIDTH,BLOCK_HEIGHT,Image.SCALE_DEFAULT)));
                    map[i][j]=index+1;
                    blocks.add(block);
                    add(block);
                }
            }
        }
    }

    private void initSpecialBlock(int index,int amount){
        Random random=new Random();
        int x=random.nextInt(map[0].length);
        int y=random.nextInt(map.length);
        for(int i=0;i<amount;i++){
            while (map[y][x] != 1){
                x=random.nextInt(map[0].length);
                y=random.nextInt(map.length);
            }
            Block block = new Block(this,x,y);
            block.setSize(BLOCK_WIDTH, BLOCK_HEIGHT);
            block.update();
            BufferedImage image = null;
            switch (index){
                case Block.ADD_TIME:image=addTime.getImage();break;
                case Block.BOOM:image=boom.getImage();break;
                case Block.REFRESH:image=refresh.getImage();break;
                default:
                    image=blockImages[0];
                    index=1;
                    break;
            }
            block.setIcon(new ImageIcon(image.getScaledInstance(BLOCK_WIDTH,BLOCK_HEIGHT,Image.SCALE_DEFAULT)));
            map[y][x] = index;
            blocks.add(block);
            add(block);
        }
    }

    /**
     *  判断场上是否还有方块可以消除
     * @return boolean
     */
    public boolean checkConnection() {
        for (int i = 0; i < blocks.size(); i++)
            for (int j = i + 1; j < blocks.size(); j++) {
                int X = blocks.get(j).getMapX();
                int Y = blocks.get(j).getMapY();
                int secondX = blocks.get(i).getMapX();
                int secondY = blocks.get(i).getMapY();
                int[][] CopyMap = new int[LevelData.map[0].length][LevelData.map[0][0].length];
                for (int m = 0; m < CopyMap.length; m++)
                    for (int n = 0; n < CopyMap[0].length; n++) {
                        CopyMap[m][n] = map[m][n];
                    }
                CopyMap[secondY][secondX] = 0;
                if (map[Y][X] == map[secondY][secondX]) {
                    if(blocks.get(j).isConnect(CopyMap, secondX, secondY, secondX, secondY, 0))
                        return true;
                }
            }
        return false;
    }


    public void gameOver(){
        frame.remove(this);
        timer.cancel();
        if(score > RankIOUtil.readOneLevel(level)){
            RankIOUtil.writeOneLevel(level,score);
        }
        frame.add(new GameOverBoundary(frame,score));
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background,0,40,Game.WIDTH,Game.HEIGHT-40,null);
        for(int i=0;i<connectLines.size();i++){
            connectLines.get(i).drawSelf(g);
        }
    }

    /**
     * 退出游戏按钮事件监听
     */
    private class MyButtonAction implements ActionListener {
        Level level;
        MyButtonAction(Level level){
            super();
            this.level = level;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            level.gameOver();
        }
    }
}