package top150

import kotlin.math.min

/**
 * 322. Coin Change !!
 * dp는 아직 익숙하지 않음.
 */
class CoinChange {
    fun coinChange(coins: IntArray, amount: Int): Int {
        // 금액만큼 배열을 초기화한다.
        val dp = IntArray(amount + 1) { amount + 1 }
        dp[0] = 0

        for (a in 1 ..< dp.size) {
            // bottom-up dp를 사용하기 위해 1부터 dp 사이즈(금액)으로 for문 순회한다.
            for (c in coins) {
                // 최소값이 갱신될수 있으므로 모든 코인으로 dp 처리해야한다.
                if (a - c >= 0) {
                    // 현재금액 - 코인금액이 0보다 같거나 크면 dp[a]를 갱신한다.
                    dp[a] = min(dp[a], 1 + dp[a - c])
                }
            }
        }

        return if (dp[amount] != amount + 1) {
            dp[amount]
        } else {
            -1
        }
    }
}

fun main() {
    println(CoinChange().coinChange(intArrayOf(186,419,83,408), 6249))
    println(CoinChange().coinChange(intArrayOf(2,5,10,1), 27))
    println(CoinChange().coinChange(intArrayOf(1,2,5), 11))
    println(CoinChange().coinChange(intArrayOf(2), 3))
}