package 排序算法;

/**
 * @Author Aqinn
 * @Date 2021/1/21 12:30 下午
 */
public class 快速排序 extends Base {

    public static void main(String[] args) {
        int[] target = new int[]{2, 3, 1, 5, 1, -1, 8, 4};
        quickSort(target);
        for (int i = 0; i < target.length; i++) {
            System.out.print(target[i] + " ");
        }
    }

    private static void quickSort(int[] arr) {
        searchAndSwap(arr, 0, arr.length - 1);
    }

    private static void searchAndSwap(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int left = begin;
        int right = end;
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        searchAndSwap(arr, begin, left - 1);
        searchAndSwap(arr, left + 1, end);
    }

}
