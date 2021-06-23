package 字节跳动;

import java.util.ArrayList;

/**
 * @Author Aqinn
 * @Date 2021/1/30 5:15 下午
 */
public class 最小的K个数 {

    /**
     * 题目描述:
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf
     */

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0 || k > input.length) {
            return res;
        }
        // 堆排序
        for(int i=(input.length-1)/2; i>=0; i--){
            adjustHeap(input, i, input.length);
        }
        for(int i=input.length-1; i>=0; i--){
            int max = input[0];
            input[0] = input[i];
            input[i] = max;
            adjustHeap(input, 0, i);
        }
        for(int i=0; i<k; i++){
            res.add(input[i]);
        }
        return res;
    }

    private void adjustHeap(int[] arr, int rootIdx, int length){
        int temp = arr[rootIdx];
        int lChild = rootIdx * 2 + 1;
        while (lChild < length){
            if(lChild + 1 < length && arr[lChild] < arr[lChild + 1]) {
                lChild++;
            }
            if (temp >= arr[lChild]) {
                break;
            }
            arr[rootIdx] = arr[lChild];
            rootIdx = lChild;
            lChild = lChild * 2 + 1;
        }
        arr[rootIdx] = temp;
    }

}
