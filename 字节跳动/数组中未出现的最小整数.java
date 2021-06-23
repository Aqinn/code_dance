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
     *
     * 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/8cc4f31432724b1f88201f7b721aa391
     */

    /**
     * 最佳思路:
     * 1. 由于是最小的正整数，所以长度为 len 的数组中缺失的最小的正整数所在的范围是: [1, len+1]，不可能大于 len+1
     *      Tips: 第一步的思路是解题关键
     * 2. 本题另一个关键点在于时空间复杂度的限制，代表着不能使用额外的容器来存储数组，所以只能在本数组上想想办法，看怎样可以在数组上“打标记”
     * 3. 打标记的方式是: 正数和负数，负数代表打上标记。
     * 4. 然而数组中也存在负数，所以第一步可以使用一个循环把数组中的负数全部替换成 len+1
     *      为什么是 len+1？因为数组中能出现的所有最小正整数最大的那一个为 len，不可能为 len+1，
     *      a. 所以如果数组中从 1 到 len 的数全部出现了，就代表着缺失的最小的正整数就是 len+1；
     *      b. 而如果数组中中从 1 到 len 的数之间出现了缺失（我们后面通过打标记的方式可以知道缺失的是哪个数字），那么结果就是该数字
     * 5. 算法第二步就是假如把数组中出现的数（记为idx吧）小于等于 len，则把这个数对应的数组下标减 1 上的数设置为负数
     *      即假如 idx=10，则设置 nums[idx-1] = -Math.abs(nums[idx-1]); => nums[9] = -Math.abs(nums[9]);
     *      a. 为什么要这样？
     *          记录出现过的在 1. 中范围内（除了 len+1，原因见上述 4.）的正整数，超过了这个范围的数不需要管，保持它是正数（注意，这里一定是正数，因为我们上面已经对负数做过处理了）
     *      b. 为什么要是下标减 1？
     *          因为 0 不属于正整数，我们希望将出现过的在 1. 中范围内（除了 len+1，原因见上述 4.）的正整数都打上标记
     * 6. 在遍历一次数组，当某一个下标上的值为正数，就代表这个下标加 1 这个值即为缺失的最小正整数
     *      比如原数组 [3, 4, -1, 1]，到达此步骤之前的处理结果是 [-3, 4, -4, -1]，明显得知下标为 1 的位置上为正数，所以 1+1=2，2就是缺失的最小正整数
     * 7. 如果数组中没有正数，则缺失的最小正整数为 len+1
     */
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i=0; i<len; i++){
            if(nums[i] <= 0) {
                nums[i] = len+1;
            }
        }
        for(int i=0; i<len; i++){
            int abs = Math.abs(nums[i]);
            if(abs <= len){
                nums[abs-1] = -Math.abs(nums[abs-1]);
            }
        }
        int res = len+1;
        for(int i=0; i<len; i++){
            if(nums[i] > 0)
                return i+1;
        }
        return res;
    }

    /**
     * return the min number
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int minNumberdisappered(int[] arr) {
        int len = arr.length;
        for (int i = (len - 1) / 2; i >= 0; i--) {
            adjust(arr, i, len);
        }
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
            if (arr[i] > 0 && res < arr[i]) {
                return res;
            }
        }
        return res;
    }

    private void adjust(int[] arr, int root, int length) {
        int tmp = arr[root];
        int lChild = root * 2 + 1;
        while (lChild < length) {
            if (lChild + 1 < length && arr[lChild] < arr[lChild + 1]) {
                lChild++;
            }
            if (tmp >= arr[lChild]) {
                break;
            }
            arr[root] = arr[lChild];
            root = lChild;
            lChild = lChild * 2 + 1;
        }
        arr[root] = tmp;
    }

}
