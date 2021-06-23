package 牛客网.二分;

/**
 * @Author Aqinn
 * @Date 2021/1/23 8:55 下午
 */
public class 统计一个数字在升序数组中出现的次数 {

    /**
     * 题目描述:
     * 统计一个数字在升序数组中出现的次数。
     * <p>
     * 输入
     * [1,2,3,3,3,3,4,5],3
     * <p>
     * 输出
     * 4
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2
     */

    public static void main(String[] args) {
        System.out.println(new 统计一个数字在升序数组中出现的次数().GetNumberOfK(new int[]{1, 2, 3, 3, 3, 3, 4, 5},
                3));
    }

    public int GetNumberOfK(int[] array, int k) {
        if (array.length == 0) {
            return 0;
        }
        int l = 0, r = array.length;
        int leftBound, rightBound;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (array[mid] < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        leftBound = l;
        l = 0;
        r = array.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (array[mid] <= k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        rightBound = l;
        return rightBound - leftBound;
    }

}
