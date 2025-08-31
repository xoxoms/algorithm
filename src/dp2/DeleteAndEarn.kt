package dp2

import kotlin.math.max

/**
 * 740. Delete and Earn
 * 30m
 * ====================
 * nums.max 값을 구해서 dp 사이즈로 초기화한다.
 * dp[i]에 nums에 i값의 포인트 합 + dp[i - 2]와 dp[i - 1] 중 큰 값을 할당한다.
 * 마지막 값을 리턴한다.
 * 피보나치 방식이므로 마지막 두값반 기억하면된다고한다.
 */
class DeleteAndEarn {

    fun deleteAndEarn(nums: IntArray): Int {
        // nums.max값을 dp 초기화한다.
        // dp[n]에는 dp[n-1] or 에[n-2] + map[nums[n]]이 저장된다.
        // dp.last() 응답한다.

        val max = nums.max()
        val dp = IntArray(max + 2)
        val group = nums.groupBy { it }
        dp[1] = (group[1]?.size ?: 0)

        for (i in 2 ..< dp.size) {
            dp[i] = max(
                dp[i - 2] + (group[i]?.size ?: 0) * i,
                dp[i - 1]
            )
        }

        return dp.last()
    }
}