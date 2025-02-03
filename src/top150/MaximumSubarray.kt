package top150

import kotlin.math.max

/**
 * 53. Maximum Subarray
 * 이전까지의 합보다 현재값이 크면 start 갱신
 * currentSum, max도 갱신
 * =======================
 * 예전에는 dp로 현재기준 다음 원소중 가장 큰값을 더해서 비교하는 방식으로 해결함
 */
class MaximumSubarray {
    fun maxSubArray(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var max = nums[0]
        var currentSum = max

        for (i in 1 ..< nums.size) {
            if (currentSum + nums[i] < nums[i]) {
                currentSum = 0
            }

            currentSum += nums[i]
            if (currentSum > max) {
                max = currentSum
            }
        }

        return max
    }

    private var max = Int.MIN_VALUE

    fun maxSubArrayOld(nums: IntArray): Int {
        dp(nums, 0)
        return max
    }

    private fun dp(nums: IntArray, idx: Int): Int {
        if (idx == nums.size) {
            return 0
        }

        val right = dp(nums, idx + 1)
        val current = nums[idx]
        val newSum = max(right + current, current)
        max = max(newSum, max)
        return newSum
    }
}

fun main() {
    println(MaximumSubarray().maxSubArray(intArrayOf(-2,1,-3,4-1,2,1,-5,4)))
}