package 排序算法;

/**
 * @Author Aqinn
 * @Date 2021/1/21 11:32 上午
 */
public class 冒泡排序 extends Base {

    public static void main(String[] args) {
        int[] target = new int[]{2, 3, 1, 5, 1, -1, 8, 4};
        bubbleSort(target);
        for (int i = 0; i < target.length; i++) {
            System.out.print(target[i] + " ");
        }
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }

}
