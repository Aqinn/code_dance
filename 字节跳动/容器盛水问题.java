package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/2/3 9:05 上午
 */
public class 容器盛水问题 {

    /**
     * 题目描述:
     * 给定一个整形数组arr，已知其中所有的值都是非负的，将这个数组看作一个容器，请返回容器能装多少水。
     * 具体请参考样例解释
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/31c1aed01b394f0b8b7734de0324e00f
     */

    /**
     * max water
     * @param arr int整型一维数组 the array
     * @return long长整型
     */
    public long maxWater (int[] arr) {
        if (arr == null || arr.length <= 2) {
            return 0L;
        }
        int l=0, r=arr.length-1, mark=arr[l]<arr[r]?arr[l]:arr[r];
        long sum=0;
        while (l<r){
            if (arr[l] < arr[r]){
                l++;
                if (arr[l] < mark) {
                    sum += mark - arr[l];
                } else {
                    mark = arr[l]<arr[r]?arr[l]:arr[r];
                }
            } else {
                r--;
                if (arr[r] < mark) {
                    sum += mark - arr[r];
                } else {
                    mark = arr[l]<arr[r]?arr[l]:arr[r];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        boolean dp[][] = new boolean[1][1];
        System.out.println(dp[0][0]);
    }

}
