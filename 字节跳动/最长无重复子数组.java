package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/1/30 8:09 下午
 */
public class 最长无重复子数组 {

    /**
     * 题目描述:
     * 给定一个数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
     * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/b56799ebfd684fb394bd315e89324fb4
     */

    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {
        int max = 1;
        int temp = 1;
        for(int i=1; i<arr.length; i++){
            boolean flag = true;
            int j=1;
            for(; j<=temp; j++){
                if(arr[i] == arr[i-j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                temp++;
                max = Math.max(max, temp);
            } else {
                temp = j;
            }
        }
        return max;
    }

}
