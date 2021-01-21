package 排序算法;

/**
 * @Author Aqinn
 * @Date 2021/1/21 11:55 上午
 */
public class 插入排序 extends Base {

    public static void main(String[] args) {
        int[] target = new int[]{2, 3, 1, 5, 1, -1, 8, 4};
        insertionSort(target);
        for (int i = 0; i < target.length; i++) {
            System.out.print(target[i] + " ");
        }
    }

    private static void insertionSort(int[] arr) {
        int preIndex, current;
        for (int i = 1; i < arr.length; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current){
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }

}
