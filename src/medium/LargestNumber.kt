package medium

import java.math.BigDecimal

/**
 * 179. Largest Number !!
 * 2h
 * 숫자를 문자열로 치환하고, 앞자리 비교한다.
 * 앞자리가 같으면 두문자열을 합친 후 비교한다
 */
class LargestNumber {
    fun largestNumber(nums: IntArray): String {
        if (nums.all { it == 0 }) { return "0" }

        val sb = StringBuilder()
        nums
            .map { it.toString() }
            .sortedWith { s1, s2 ->
                if (s1[0] < s2[0]) {
                    1
                } else if (s1[0] > s2[0]) {
                    -1
                } else {
                    BigDecimal(s2 + s1).minus(BigDecimal(s1 + s2)).toInt()
                }
            }
            .forEach { item -> sb.append(item) }

        return sb.toString()
    }
}

fun main() {
    println(LargestNumber().largestNumber(intArrayOf(700000000,500000000)))
    println(LargestNumber().largestNumber(intArrayOf(1000000000, 1000000000)))
    println(LargestNumber().largestNumber(intArrayOf(432, 43243)))
    println(LargestNumber().largestNumber(intArrayOf(43243, 432)))
    println(LargestNumber().largestNumber(intArrayOf(3,30,34,5,9)))
}