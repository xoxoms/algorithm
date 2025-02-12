package medium

import kotlin.math.max

/**
 * 2342. Max Sum of a Pair With Equal Sum of Digits
 * 10으로 계속 나눠서 sum을 구한다.
 * set에 넣는다.
 * set에 이미 있으면 글로벌 맥스를 갱신해본다.
 */
class MaxSumOfAPairWithEqualSumOfDigits {
    private var max = -1
    private val map = mutableMapOf<Int, Int>()

    fun maximumSum(nums: IntArray): Int {
        nums.sortDescending()

        for (num in nums) {
            var sum = 0
            var target = num
            while (target > 0) {
                sum += target % 10
                target /= 10
            }

            if (map.contains(sum)) {
                max = max(max, map[sum]!! + num)
            } else {
                map[sum] = num
            }
        }

        return max
    }
}

fun main() {
    println(MaxSumOfAPairWithEqualSumOfDigits().maximumSum(intArrayOf(229,398,269,317,420,464,491,218,439,153,482,169,411,93,147,50,347,210,251,366,401)))
}