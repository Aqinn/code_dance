package 排序算法;

/**
 * @Author Aqinn
 * @Date 2021/1/21 4:32 下午
 */
public class 堆排序 extends Base {

    public static void main(String[] args) {
        堆排序 main = new 堆排序();
        int[] target = new int[]{2, 3, 1, 5, 1, -1, 8, 4};
        main.heapSort(target);
        for (int i = 0; i < target.length; i++) {
            System.out.print(target[i] + " ");
        }
    }

    public void heapSort(int[] arr) {
        // 创建大顶堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            // 完全二叉树的层次遍历中，
            // i = (arr.length - 1) / 2 即是第一个非叶子节点
            adjustHeap(arr, i, arr.length);
        }

        // 调整堆结构 + 交换堆顶元素与末尾元素
        for (int i = arr.length - 1; i >0 ; i--) {
            // 交换堆顶和堆末元素
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            // 重新调整堆
            adjustHeap(arr, 0, i);
        }
    }

    private void adjustHeap(int[] arr, int parent, int length) {
        // temp保存父节点
        int temp = arr[parent];
        // 左孩子下标
        int lChild = parent * 2 + 1;
        while (lChild < length) {
            // 右孩子下标
            int rChild = lChild + 1;
            // 如果有右孩子且右孩子节点值大于左孩子，则选右孩子
            if (rChild < length && arr[lChild] < arr[rChild]) {
                lChild++;
            }
            if (temp >= arr[lChild])
                break;
            arr[parent] = arr[lChild];
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        arr[parent] = temp;
    }

}
