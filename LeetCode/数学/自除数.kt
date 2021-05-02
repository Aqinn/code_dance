package LeetCode.数学

/**
 * @Author Aqinn
 * @Date 2021/5/2 3:29 下午
 */
class 自除数 {

    fun selfDividingNumbers(left: Int, right: Int): List<Int> {
        val res = mutableListOf<Int>();
        for (i in left..right) {
            if (isSelfDiv(i)) {
                res.add(i)
            }
        }
        return res;
    }

    fun isSelfDiv(num: Int): Boolean {
        var temp = num
        while (temp > 0) {
            val remain = temp % 10
            if (remain == 0 || num % remain != 0)
                return false
            temp /= 10
        }
        return true
    }

}