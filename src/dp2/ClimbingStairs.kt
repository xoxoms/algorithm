package dp2

/**
 * 70. Climbing Stairs
 * 25m
 * ===================
 * 0, 1, 2일때 미리 코인 수 정해둔다.
 * 1씩 증가하면서 이전 값을 더해준다.
 */
class ClimbingStairs {

    fun climbStairs(n: Int): Int {
        val dp = IntArray(n + 2)
        dp[0] = 0
        dp[1] = 1
        dp[2] = 2
        for (i in 3 ..< dp.size) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }

        return dp[n]
    }
}