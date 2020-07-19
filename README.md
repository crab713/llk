# 《连 连 看》

### 项目说明

本项目为一个简陋的连连看，包括历史排行，关卡选择等功能

### 概要设计

1. 界面
   - 初始界面
     - 开始游戏->选择关卡
     - 历史榜单
     - 选项帮助
   - 选择关卡
     - 关卡列表
     - 返回->初始界面
   - 游戏界面
     - 主界面
     - 倒计时
     - 得分
     - 道具栏
   - 游戏结束
     - 分数
     - 返回->选择关卡
   - 历史榜单
     - 历史排行topN（N=10）
     - 返回->初始界面
2. 游戏逻辑
   - 两方块是否可消除，消除特殊方块获得道具
   - 道具使用
   - 倒计时归零或全部消完游戏结束
   - 结束后分数判断是否上榜储存
3. 历史成绩等数据存储 ？
   - 数据库 or .dat
4. 素材
   - 各场景背景图
   - 方块，道具图片
   - 消方块特效及音乐？
   - BGM



### 详细设计



#### 文件目录

- llk  //工程总文件夹
  + images  //图片文件夹
    - block //命名规则为block+序号+.png，例block1.png
    - background
  + src  //工程文件
    - block  //方块
      - Block.java 
      - SpecialBlock.java //特殊方块，爆道具啥的，继承block，IPropBlock
    - start  //启动
      - Game.java  //frame && main
    - utils  //工具类
    - level  //关卡
      - BaseLevel.java
    - prop  //道具
      - BaseProp.java
    - boundary //界面
      - BaseBoundary.java

注：Base打头为抽象类，I打头为接口

#### 类的设计

1. Block extends JButton

   - Level level //获取所在关卡的信息

   - int x //在map中的x，y位置
   - int y 

   | 方法                                  | 说明                                                         |
   | :------------------------------------ | :----------------------------------------------------------- |
   | public void delete()                  | 从关卡中移除(level.blocks.remove(this))此方块,进行其余操作   |
   | addMouseAction中的onclick             | 如果level中block为空则赋值，如果有则判断能不能消，能消都delete，加分 |
   | public boolean isConnect(Block block) | 判断两物块是否可相消，如果可返回true                         |

2. Game extends JFrame //声明各界面，main函数位置等

3. BaseLevel extends JPanel

   - JFrame frame  //获取画板中的信息

   - Block block //存放第一个选中的方块，当选中第二个方块时进行逻辑判断

   - Block[] blocks //存放场上所有方块

   - public final static int BLOCK_WIDTH

   - public final static int BLOCK_HEIGHT

   - Timer timer

   - int time //剩余时间，单位毫秒

   - int [] [] map //地图信息,初始化后记录各位置方块id

     | 方法                                   | 说明                                        |
     | -------------------------------------- | ------------------------------------------- |
     | public void BaseLevel(JFrame frame)    | 初始化关卡，添加鼠标监听,计时器任务(重绘等) |
     | public void paintComponent(Graphics g) | 绘制关卡(背景，方块等整个关卡界面)          |
     | public void gameOver()                 | 结束关卡时的操作，并跳转至游戏结束界面      |

4. BaseProp

   - BaseLevel level //获取关卡中信息

     | 方法                                  | 说明               |
     | ------------------------------------- | :----------------- |
     | public void BaseProp(BaseLevel level) | 初始化道具信息     |
     | public void run()                     | 使用道具产生的效果 |

5. BaseBoundary extends JPanel

   - JFrame frame  //获取画板中的信息

     | 方法                                   | 说明                 |
     | -------------------------------------- | -------------------- |
     | public void BaseBoundary(JFrame frame) | 初始化界面，添加监听 |
     | public void paintComponent(Graphics g) | 绘制界面,类似paint   |

     

### 补充

1. 针对于关卡中方块的位置，可以通过在坐标乘方块的宽高获得

2. 界面间的跳转，可以通过以下代码完成跳转，记得要结束计时器任务

   ```java
   frame.add(要跳转的panel);
   frame.remove(当前panel，也就是this);
   frame.setVisible(true); //刷新界面
   ```

3. 在测试单个界面时可以直接在Game的main函数里add(panel)

4. getScaledInstance(WIDTH,HEIGHT,Image.SCALE_DEFAULT)函数可缩放图片