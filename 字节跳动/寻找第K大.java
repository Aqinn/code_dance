package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/1/30 5:40 下午
 */
public class 寻找第K大 {

    /**
     * 题目描述:
     * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
     * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/e016ad9b7f0b45048c58a9f27ba618bf
     */

    public int findKth(int[] a, int n, int K) {
        return suit(a,0,n-1,K);
    }

    private int suit(int[] arr, int start, int end, int K){
        int temp = arr[start];
        int l=start,r=end;
        while(l < r){
            while(l<r && arr[r] <= temp) {
                r--;
            }
            arr[l] = arr[r];
            while(l<r && arr[l] >= temp) {
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = temp;
        if (l==K-1) {
            return temp;
        } else if(l<K-1) {
            return suit(arr, l+1, end, K);
        } else {
            return suit(arr, start, l-1, K);
        }
    }

}
