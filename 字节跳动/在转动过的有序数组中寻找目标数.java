package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/1 11:30 下午
 */
public class 在转动过的有序数组中寻找目标数 {

    /**
     * 题目描述:
     * 给出一个转动过的有序数组，你事先不知道该数组转动了多少
     * (例如,0 1 2 4 5 6 7可能变为4 5 6 7 0 1 2).
     * 在数组中搜索给出的目标值，如果能在数组中找到，返回它的索引，否则返回-1。
     * 假设数组中不存在重复项。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/87c0e7abcbda41e7963660fa7d020995
     */

    /**
     * @param A      int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search(int[] A, int target) {
        // write code here
        return binSearch(A, 0, A.length - 1, target);
    }

    private int binSearch(int[] arr, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int mid = (l + r) >> 1;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[l] <= arr[mid]) {
            if (target < arr[mid] && arr[l] <= target) {
                return binSearch(arr, l, mid - 1, target);
            } else {
                return binSearch(arr, mid + 1, r, target);
            }
        } else {
            if (target >= arr[l] || target < arr[mid]) {
                return binSearch(arr, l, mid - 1, target);
            } else {
                return binSearch(arr, mid + 1, r, target);
            }
        }
    }

}
