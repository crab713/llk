public class Test {
    public static void main(String[] args) {
        int[][] map = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 3, 0},
                {0, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        int n = 0;
        for (int[] a : map) {
            for (int b : a) {
                if (b == 1)
                    n++;
            }
        }
        System.out.println(n);
    }
}
