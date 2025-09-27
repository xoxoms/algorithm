package dp2

import kotlin.math.max

/**
 * 300. Longest Increasing Subsequence
 * 1h 40m
 * ===================================
 * dp를 초기화한다.
 * 초기화 값은 서브시퀀스 최소 값인 1로 할당한다.
 * for문 i 루핑한다.
 * i부터 0까지 역순으로 j 루핑한다
 * dp[i]보다 dp[j]가 크면, max 값 갱신할 수 있다.
 * 최종 dp.max() 값으로 응답
 */
class LongestIncreasingSubsequence {

    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size) { 1 }

        for (i in 1 ..< nums.size) {
            for (j in i - 1 downTo 0) {
                if (nums[j] < nums[i]) {
                    dp[i] = max(
                        dp[i],
                        dp[j] + 1,
                    )
                }
            }
        }

        return dp.max()
    }
}