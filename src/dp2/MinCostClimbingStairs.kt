package dp2

import kotlin.math.min

/**
 * 746. Min Cost Climbing Stairs
 * 50m
 * easy인데 어려웠다..
 * =============================
 * cost[i] + dp[i]는 dp[i + 1]과 dp[i + 2]로 갈수있다.
 * cost를 순환하며 위 값들을 더작은 값으로 할당해주고 최종 마지막 값을 반환한다.
 */
class MinCostClimbingStairs {

    fun minCostClimbingStairs(cost: IntArray): Int {
        val dp = IntArray(cost.size + 2) { Int.MAX_VALUE }
        dp[0] = 0
        dp[1] = 0
        dp[2] = cost[0]

        for (i in 0 ..< cost.size) {
            val current = cost[i] + dp[i]
            dp[i + 2] = current
            dp[i + 1] = min(dp[i + 1], current)
        }

        return dp[cost.size]
    }
}

fun main() {
    println(MinCostClimbingStairs().minCostClimbingStairs(intArrayOf(10,15,20)))
}