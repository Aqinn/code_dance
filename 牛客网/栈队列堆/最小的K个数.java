package 牛客网.栈队列堆;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Aqinn
 * @Date 2021/1/21 3:35 下午
 */
public class 最小的K个数 {

    /**
     * 题目描述:
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
     */

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        for (Integer i: GetLeastNumbers_Solution(arr, 4)) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length)
            return list;
        quickSort(input, 0, input.length-1);
        for(int i = 0; i < k; i++){
            list.add(input[i]);
        }
        return list;
    }

    private static void quickSort(int[] arr, int begin, int end){
        if (begin >= end)
            return;
        int left = begin;
        int right = end;
        int key = arr[left];
        while(left < right){
            while(left < right && arr[right] >= key)
                right--;
            arr[left] = arr[right];
            while(left < right && arr[left] <= key)
                left++;
            arr[right] = arr[left];
        }
        arr[left] = key;
        quickSort(arr, begin, left - 1);
        quickSort(arr, left + 1, end);
    }

}
