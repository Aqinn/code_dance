package 牛客网.二分;

/**
 * @Author Aqinn
 * @Date 2021/1/23 8:21 下午
 */
public class 旋转数组的最小数字 {

    /**
     * 题目描述:
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * <p>
     * 输入
     * [3,4,5,1,2]
     * <p>
     * 输出
     * 1
     */

    public static void main(String[] args) {
        System.out.println(new 旋转数组的最小数字().minNumberInRotateArray(new int[]{3, 4, 5, 5, 1, 2}));
    }

    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int l = 0;
        int r = array.length - 1;
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (array[mid] >= array[l]) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return array[r];
    }

}
