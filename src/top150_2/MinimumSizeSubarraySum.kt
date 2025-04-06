package top150_2

import kotlin.math.min

/**
 * 209. Minimum Size Subarray Sum !!
 * 1h 30m
 * ==================
 * 좋은 해법으로 해결하지 못했다.
 */
class MinimumSizeSubarraySum {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        // i,j를 둔다.
        // sum < target이면 j++한다.
        // 아니면 result에 값을 할당하고 i++한다.
        var result = nums.size + 1
        var sum = nums[0]
        var i = 0
        var j = 1
        while (i < j) {
            if (sum < target && j < nums.size) {
                sum += nums[j++]
            } else {
                if (sum >= target) {
                    result = min(result, j - i)
                }

                sum -= nums[i++]
            }
        }

        return if (result == nums.size + 1) {
            0
        } else {
            result
        }
    }
}

fun main() {
    MinimumSizeSubarraySum().minSubArrayLen(7, intArrayOf(2,3,1,2,4,3))
}