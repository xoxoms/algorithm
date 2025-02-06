package top150

import kotlin.math.max

/**
 * 918. Maximum Sum Circular Subarray
 * globalMax, currentMax, globalMin, currentMin으로 값을 기록한다.
 * totalSum - globalMin vs globalMax 중 큰 값을 리턴한다.
 */
class MaximumSumCircularSubarray {
    private var globalMax = 0
    private var globalMin = 0
    private var currentMin = 0

    fun maxSubarraySumCircular(nums: IntArray): Int {
        globalMax = nums[0]
        globalMin = nums[0]
        maxSubarraySumCircular(nums, 0)
        if (globalMax < 0) { return globalMax }
        return max(globalMax, nums.sum() - globalMin)
    }

    private fun maxSubarraySumCircular(nums: IntArray, currentIdx: Int): Int {
        if (currentIdx == nums.size) { return 0 }
        val current = nums[currentIdx]
        val next = maxSubarraySumCircular(nums, currentIdx + 1)

        val currentMax = if (current + next > current) {
            current + next
        } else {
            current
        }

        globalMax = max(currentMax, globalMax)
        currentMin = if (current > current + currentMin) {
            current + currentMin
        } else {
            current
        }

        if (currentMin < globalMin) {
            globalMin = currentMin
        }

        return currentMax
    }
}

fun main() {
    println(MaximumSumCircularSubarray().maxSubarraySumCircular(intArrayOf(4, -1, 1, -2, 3, -2)))
    println(MaximumSumCircularSubarray().maxSubarraySumCircular(intArrayOf(-3,-2,-3)))
    println(MaximumSumCircularSubarray().maxSubarraySumCircular(intArrayOf(9,-4,-7,9)))
    println(MaximumSumCircularSubarray().maxSubarraySumCircular(intArrayOf(1,-2,3,-2)))
    println(MaximumSumCircularSubarray().maxSubarraySumCircular(intArrayOf(-2,-3,-1)))
}