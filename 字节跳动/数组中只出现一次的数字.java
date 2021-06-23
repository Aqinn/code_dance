package 字节跳动;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author Aqinn
 * @Date 2021/2/3 3:21 下午
 */
public class 数组中只出现一次的数字 {

    /**
     * 题目描述:
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/389fc1c3d3be4479a154f63f495abff8
     */

    public static void main(String[] args) {
        数组中只出现一次的数字 main = new 数组中只出现一次的数字();
//        int[] num1 = new int[1];
//        int[] num2 = new int[1];
//        main.FindNumsAppearOnce(new int[]{1,1,3,6}, num1, num2);
//        System.out.println(num1[0] + ", " + num2[0]);
        System.out.println(1 & 10);
    }

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp ^= array[i];
        }
        int index = 1;
        while((index & temp)==0) {
            index = index <<1;
        }
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if ((index & array[i]) == 0) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    public void low_FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        boolean flag = true;
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> e = it.next();
            if (e.getValue() == 1) {
                if (flag) {
                    num1[0] = e.getKey();
                    flag = false;
                } else {
                    num2[0] = e.getKey();
                    return;
                }
            }
        }
    }

}
