package 牛客网.排序;

/**
 * @Author Aqinn
 * @Date 2021/1/24 11:48 上午
 */
public class 调整数组顺序使奇数位于偶数前面 {

    /**
     * 题目描述:
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
     * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */

    public static void main(String[] args) {
        调整数组顺序使奇数位于偶数前面 main = new 调整数组顺序使奇数位于偶数前面();
        int[] arr = new int[]{2, 4, 1, 3, 6, 7};
        main.reOrderArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void reOrderArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                // 如果是奇数
                if ((array[j] & 1) == 1) {
                    // 移动到 array[i]
                    for (int k = j; k > i; k--) {
                        swap(array, k, k - 1);
                    }
                    break;
                }
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
