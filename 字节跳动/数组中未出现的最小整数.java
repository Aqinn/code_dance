package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/14 4:54 下午
 */
public class 数组中未出现的最小整数 {

    /**
     * 题目描述:
     * 给定一个无序数组 arr，找到数组中未出现的最小正整数
     * 例如 arr = [-1, 2, 3, 4]。返回 1
     * arr = [1, 2, 3, 4]。返回 5
     */

    /**
     * return the min number
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int minNumberdisappered(int[] arr) {
        int len = arr.length;
        for (int i = (len - 1) / 2; i >= 0; i--)
            adjust(arr, i, len);
        for (int i = len - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjust(arr, 0, i);
        }
        int res = 1;
        for (int i = 0; i < len; i++) {
            if (res == arr[i]) {
                res++;
                continue;
            }
            if (arr[i] > 0 && res < arr[i])
                return res;
        }
        return res;
    }

    private void adjust(int[] arr, int root, int length) {
        int tmp = arr[root];
        int lChild = root * 2 + 1;
        while (lChild < length) {
            if (lChild + 1 < length && arr[lChild] < arr[lChild + 1])
                lChild++;
            if (tmp >= arr[lChild])
                break;
            arr[root] = arr[lChild];
            root = lChild;
            lChild = lChild * 2 + 1;
        }
        arr[root] = tmp;
    }

}
