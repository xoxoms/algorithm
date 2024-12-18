package dp

import kotlin.math.max

class MaximumSubArraySum {

    private var max = Int.MIN_VALUE
    fun maxSubArray(nums: IntArray): Int {
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

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MaximumSubArraySum().maxSubArray(intArrayOf(-1)))
            println(MaximumSubArraySum().maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
        }
    }
}