import utils.RankIOUtil;

public class Test {

    public static void main(String[] args) {
        RankIOUtil.writeOneLevel(4,200);
        System.out.println(RankIOUtil.readOneLevel(3));
    }
}
