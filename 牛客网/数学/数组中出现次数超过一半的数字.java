package 牛客网.数学;

/**
 * @Author Aqinn
 * @Date 2021/1/26 10:19 下午
 */
public class 数组中出现次数超过一半的数字 {

    /**
     * 题目描述:
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
     * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163
     */

    public int MoreThanHalfNum_Solution(int [] array) {
        int target = -1;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (count == 0) {
                target = array[i];
                count++;
            } else {
                if (target == array[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (target == array[i]) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return target;
        } else {
            return 0;
        }
    }

}
