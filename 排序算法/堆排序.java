package 排序算法;

/**
 * @Author Aqinn
 * @Date 2021/1/21 4:32 下午
 */
public class 堆排序 extends Base{

    public static void main(String[] args) {
        int[] target = new int[]{2, 3, 1, 5, 1, -1, 8, 4};
        heapSort(target);
        for (int i = 0; i < target.length; i++) {
            System.out.print(target[i] + " ");
        }
    }

    private static void heapSort(int[] arr) {

    }

}
