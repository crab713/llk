package utils;

import java.io.*;
import java.sql.Struct;

public class RankIOUtil {
    private static File file = new File("src/level/levelScore.dat");
    /**
     * 读取某一关的最高分数
     * @param level 要读取的关卡数据
     * @return score
     */
    public static int readOneLevel(int level) {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            for (int i = 0; i < level - 1; i++) {
                reader.readLine();
            }
            tempString = reader.readLine();
            return Integer.parseInt(tempString);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return 0;
    }

    public static void writeOneLevel(int level,int score){
        BufferedReader reader = null;
        String[] scores=new String[9];
        try {
            reader = new BufferedReader(new FileReader(file));
            for (int i = 0; i < 9; i++) {
                scores[i] = reader.readLine();
            }
            scores[level-1]=String.valueOf(score);
            FileWriter fileWriter = new FileWriter(file.getPath());
            for(String string : scores){
                fileWriter.write(string+'\n');
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }


    }
}
