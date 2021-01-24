package 牛客网.搜索;

/**
 * @Author Aqinn
 * @Date 2021/1/24 12:11 上午
 */
public class 机器人的运动范围 {

    /**
     * 题目描述:
     * 地上有一个m行和n列的方格。
     * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
     * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
     * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
     */

    public static void main(String[] args) {
        机器人的运动范围 main = new 机器人的运动范围();
        System.out.println(main.movingCount(5, 10, 10));
    }

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] been = new boolean[rows+1][cols+1];
        return moving(threshold, rows, cols, 0, 0, been);
    }

    public int moving(int threshold, int rows, int cols, int r, int c, boolean[][] been) {
        if (been[r][c] || r >= rows || c >= cols || splitAndSum(r) + splitAndSum(c) > threshold)
            return 0;
        // 朝右
        int right = moving(threshold, rows, cols, r + 1, c, been);
        // 朝下
        int down = moving(threshold, rows, cols, r, c + 1, been);
        been[r][c] = true;
        return right + down + 1;
    }

    private int splitAndSum(int a) {
        int sum = 0;
        while (a / 10 != 0) {
            sum += a % 10;
            a /= 10;
        }
        return sum + a;
    }

}
