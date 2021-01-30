package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/1/30 8:09 下午
 */
public class 最长无重复字符串 {

    /**
     * 题目描述:
     * 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
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
