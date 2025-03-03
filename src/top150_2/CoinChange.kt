package top150_2

import kotlin.math.min

/**
 * 322. Coin Change
 * DP 활용해서 해결
 * 접근하는 방식을 몰라서 어려웠다.
 * 1원부터 amount까지 a 금액이 되기 위한 최소 값을 저장한다.
 * a - c는 a금액에서 c 코인 하나를 뺀 금액이 되기 위한 최소 코인 갯수이므로 값이 있다면 해당값 + 1일 취한다.
 * 값이 없다면 인수로 받은 amount+1을 넣어줌으로 맨뒤에서 -1 리턴할때 사용한다.
 */
class CoinChange {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { amount + 1 }
        dp[0] = 0

        for (c in coins) {
            for (a in 1 .. amount) {
                if (c > a) { continue }
                dp[a] = min(dp[a], dp[a - c] + 1)
            }
        }

        return if (dp.last() > amount) {
            -1
        } else {
            dp.last()
        }
    }
}