package 排序算法;

/**
 * @Author Aqinn
 * @Date 2021/1/21 11:40 上午
 */
public class Base {

    /**
     * 参考网站
     * https://www.cnblogs.com/onepixel/articles/7674659.html
     */

    protected static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    protected static void swap(float[] arr, int i, int j) {
        float temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    protected static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
