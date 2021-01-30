package 排序算法;

import java.util.Arrays;

/**
 * @Author Aqinn
 * @Date 2021/1/24 2:47 下午
 */
public class 归并排序 extends Base {

    public static void main(String[] args) {
        int[] arr = {884688278, 387052570, 77481420, 537616843, 659978110, 215386675, 604354651, 64838842, 830623614, 544526209, 292446044, 570872277, 946770900, 411203381, 445747969, 480363996, 31693639, 303753633, 261627544, 884642435, 978672815, 427529125, 111935818, 109686701, 714012242, 691252458, 230964510, 340316511, 917959651, 544069623, 193715454, 631219735, 219297819, 151485185, 986263711, 805374069, 915272981, 493886311, 970466103, 819959858, 733048764, 393354006, 631784130, 70309112, 513023688, 17092337, 698504118, 937296273, 54807658, 353487181, 82447697, 177571868, 830140516, 536343860, 453463919, 998857732, 280992325, 13701823, 728999048, 764532283, 693597252, 433183457, 157540946, 427514727, 768122842, 782703840, 965184299, 586696306, 256184773, 984427390, 695760794, 738644784, 784607555, 433518449, 440403918, 281397572, 546931356, 995773975, 738026287, 861262547, 119093579, 521612397, 306242389, 84356804, 42607214, 462370265, 294497342, 241316335, 158982405, 970050582, 740856884, 784337461, 885254231, 633020080, 641532230, 421701576, 298738196, 918973856, 472147510, 169670404};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) >> 1;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 左序列的指针
        int i = left;
        // 右序列的指针
        int j = mid + 1;
        int idx = left;
        // 左右两个序列各拿指针位置的数出来，比较大小，小的先放到 temp 里 + 挪动该序列的指针，大的继续与另一序列的下一个数比对
        while (i <= mid || j <= right) {
            // 情况 1: 如果 j > right 却进了循环，那只能说明 i 序列剩下的一股脑丢过去就好了
            // 情况 2: 如果 i 序列的指针未到底部 且 i序列指针 小于 j序列指针
            if (j > right || (i <= mid && arr[i] < arr[j])) {
                temp[idx++] = arr[i++];
                continue;
            }
            // 情况 3: 上述情况若都不满足，那就是要对 j 序列动手了
            temp[idx++] = arr[j++];
        }
        // 拷贝最新数据到原数组中
        while (--idx >= left) {
            arr[idx] = temp[idx];
        }
    }

}
