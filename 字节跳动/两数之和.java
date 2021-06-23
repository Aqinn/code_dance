package 字节跳动;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Aqinn
 * @Date 2021/1/30 6:13 下午
 */
public class 两数之和 {

    /**
     * 题目描述:
     * 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
     * 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
     * 假设给出的数组中只存在唯一解
     * 例如：
     * 给出的数组为 {20, 70, 110, 150},目标值为90
     * 输出 index1=1, index2=2
     *
     * 来源：牛客
     * 链接：https://www.nowcoder.com/practice/20ef0972485e41019e39543e8e895b7f
     */

    /**
     *
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<numbers.length; i++){
            map.put(numbers[i], i);
        }
        for(int i=0; i<numbers.length; i++){
            if(map.containsKey(target-numbers[i]) && i != map.get(target-numbers[i])){
                int[] res = new int[]{
                        i<map.get(target-numbers[i])?i:map.get(target-numbers[i]),
                        i>map.get(target-numbers[i])?i:map.get(target-numbers[i])
                };
                res[0]++;
                res[1]++;
                return res;
            }
        }
        return null;
    }

}
