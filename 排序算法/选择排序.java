package 排序算法;

/**
 * @Author Aqinn
 * @Date 2021/1/21 11:46 上午
 */
public class 选择排序 extends Base{

    public static void main(String[] args) {
        int[] target = new int[]{2, 3, 1, 5, 1, -1, 8, 4};
        selectionSort(target);
        for (int i = 0; i < target.length; i++) {
            System.out.print(target[i] + " ");
        }
    }

    private static void selectionSort(int[] arr) {
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

}
