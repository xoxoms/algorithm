package top150_2

import kotlin.math.min

/**
 * 209. Minimum Size Subarray Sum !!
 * 1h 30m
 * ==================
 * 좋은 해법으로 해결하지 못했다.
 * sum이 target보다 적으면 j++
 * 아니라면 result를 기록한다.
 * target보다 작은경우가 계속될수있으므로 if 절에 j가 nums.size보다 작은경우까지를 명시해줬다.
 * 너무 주먹구구식으로해 결함.
 * 다시 푼 해법도 크게 뭐가 있지는 않고 sum >= target인 상황까지 j++하다가,
 * 아니게되는 상황까지 i++하여 j - i의 값을 사용하는 방식이었다.
 */
class MinimumSizeSubarraySum {
    /**
     *
     */
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var result = nums.size + 1
        var sum = 0
        // sum + nums[j]을 루핑한다.
        var i = 0

        for (j in 0 ..< nums.size) {
            sum += nums[j]
            while (i <= j) {
                if (sum < target) { break }
                result = min(result , j - i + 1)
                sum -= nums[i++]
            }
        }

        return if (result == nums.size + 1) {
            0
        } else {
            result
        }
    }

    fun minSubArrayLen2(target: Int, nums: IntArray): Int {
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