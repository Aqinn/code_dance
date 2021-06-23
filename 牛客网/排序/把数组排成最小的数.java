package 牛客网.排序;

/**
 * @Author Aqinn
 * @Date 2021/1/24 1:21 下午
 */
public class 把数组排成最小的数 {

    /**
     * 题目描述:
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
     * 打印能拼接出的所有数字中最小的一个。
     * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     * <p>
     * 输入
     * [3,32,321]
     * <p>
     * 输出
     * "321323"
     *
     * 来源：牛客
     * 链接：
     */

    public static void main(String[] args) {
        把数组排成最小的数 main = new 把数组排成最小的数();
        System.out.println(main.PrintMinNumber(new int[]{3334, 3, 3333332}));
    }

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum1 = numbers[i] * getPow(numbers[j]) + numbers[j];
                int sum2 = numbers[j] * getPow(numbers[i]) + numbers[i];
                System.out.println(sum1 + ", " + sum2);
                if (sum1 > sum2) {
                    int temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]);
        }
        return sb.toString();
    }

    private int getPow(int a) {
        int size = getSize(a);
        int pow = 1;
        for (int i = 0; i < size; i++) {
            pow *= 10;
        }
        return pow;
    }

    private int getSize(int a) {
        int size = 0;
        while (a / 10 != 0) {
            a /= 10;
            size++;
        }
        return size + 1;
    }

}
