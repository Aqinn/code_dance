package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/28 3:29 下午
 */
public class 数组中的最长连续子序列 {

    /**
     * 题目描述:
     * 给定无序数组 arr，返回其中最长的连续序列的长度 (要求值连续，位置可以不连续，例如 3,4,5,6 为连续的自然数）
     */

    public int MLS(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        heapSort(arr);
        int i = 0, len = arr.length;
        int temp = 1;
        int max = 1;
        while (i < len) {
            if (i + 1 < len) {
                if (arr[i] + 1 == arr[i + 1]) {
                    temp++;
                } else if (arr[i] != arr[i + 1]) {
                    temp = 1;
                }
            }
            max = Math.max(max, temp);
            i++;
        }
        return max;
    }

    private void heapSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        int len = arr.length;
        for (int i = (len - 1) / 2; i >= 0; i--) {
            adjust(arr, i, len);
        }
        for (int i = len - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjust(arr, 0, i);
        }
    }

    private void adjust(int[] arr, int root, int len) {
        int temp = arr[root];
        int lChild = root * 2 + 1;
        while (lChild < len) {
            // 左右孩子比大小
            if (lChild + 1 < len && arr[lChild] < arr[lChild + 1])
                lChild++;
            if (temp >= arr[lChild])
                break;
            arr[root] = arr[lChild];
            root = lChild;
            lChild = lChild * 2 + 1;
        }
        arr[root] = temp;
    }

}
