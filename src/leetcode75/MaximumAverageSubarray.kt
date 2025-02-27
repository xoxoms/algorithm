package leetcode75

import kotlin.math.max

/**
 * 643. Maximum Average Subarray I
 * k만큼 순회하며 합을 구한다.
 * k부터 시작해서 서브어레이의 합을 구한다.
 * 평균값이 글로벌값보다 크면 업데이트한다.
 * sum - pre - current <=를 하면 현재 배열의 합이다.
 */
class MaximumAverageSubarray {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var current = 0.0

        for (i in 0 ..< k) {
            current += nums[i]
        }

        var result = current / k
        for (i in k ..< nums.size) {
            current = current - nums[i - k] + nums[i]
            result = max(result, current / k)
        }

        return result
    }
}

fun main() {
    println(MaximumAverageSubarray().findMaxAverage(intArrayOf(1,12,-5,-6,50,3), 4))
}