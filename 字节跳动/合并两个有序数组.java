package 字节跳动;

/**
 * @Author Aqinn
 * @Date 2021/1/30 8:18 下午
 */
public class 合并两个有序数组 {

    /**
     * 题目描述:
     * 给出两个有序的整数数组 和 ，请将数组 合并到数组 中，变成一个有序的数组
     * 注意：
     * 可以假设 数组有足够的空间存放 数组的元素， 和 中初始的元素数目分别为 和
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/89865d4375634fc484f3a24b7fe65665
     */

    public void merge(int A[], int m, int B[], int n) {
        int i=m-1,j=n-1;
        for(int p=m+n-1; p>=0 ;p--){
            if (j<0 || (i>=0 && A[i] > B[j])){
                A[p] = A[i--];
            } else {
                A[p] = B[j--];
            }
        }
    }

}
