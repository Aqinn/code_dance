package 牛客网.双指针;

import java.util.ArrayList;

/**
 * @Author Aqinn
 * @Date 2021/1/21 4:54 下午
 */
public class 和为S的两个数字 {

    // cost time => 16:16

    /**
     * 题目描述:
     * 在有序数组中找出两个数，使得和为给定的数 S。如果有多对数字的和等于 S，输出两个数的乘积最小的。
     *
     * 来源：牛客
     * 链接：
     */

    public static void main(String[] args) {
        和为S的两个数字 main = new 和为S的两个数字();
        int[] arr = new int[]{1, 2, 4, 7, 11, 15};
        for (Integer i : main.FindNumbersWithSum(arr, 15)) {
            System.out.print(i + " ");
        }
    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int left, right;
        int mul = Integer.MAX_VALUE;
        for (left = 0; left < array.length; left++) {
            right = array.length - 1;
            while (left < right) {
                if (array[left] + array[right] == sum) {
                    if (array[left] * array[right] < mul) {
                        res.clear();
                        res.add(array[left]);
                        res.add(array[right]);
                        mul = array[left] * array[right];
                    }
                } else if (array[left] + array[right] < sum) {
                    break;
                }
                right--;
            }
        }
        return res;
    }

}
