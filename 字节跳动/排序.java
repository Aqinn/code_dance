package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/1/30 3:08 下午
 */
public class 排序 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     *
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public int[] MySort(int[] arr) {
        // 堆排序
        // 构建大根堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjustHeap(arr, 0, i);
        }
        return arr;
    }

    private void adjustHeap(int[] arr, int rootIdx, int length) {
        int temp = arr[rootIdx];
        int lChild = rootIdx * 2 + 1;
        while (lChild < length) {
            // 找到左右孩子中较大值
            if (lChild + 1 < length && arr[lChild] < arr[lChild + 1]) {
                lChild++;
            }
            // 与父节点比
            if (arr[lChild] <= temp) {
                break;
            }
            // 交换父子位置
            arr[rootIdx] = arr[lChild];
            rootIdx = lChild;
            lChild = lChild * 2 + 1;
        }
        arr[rootIdx] = temp;
    }

}
