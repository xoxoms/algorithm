package top150

import kotlin.math.max

/**
 * 121. Best Time to Buy and Sell Stock
 * O(n). 1h
 * 투포인터로 해결한다.
 * min과 max를 초기화한다.
 * 사이즈만큼 루핑한다.
 * max - min을 result와 비교하여 더 크면 기록한다.
 * 더 작은 min으로 갱신되면 max도 초기화한다.
 */
class BestTimeToBuyAndSellStock {
    fun maxProfit(prices: IntArray): Int {
        var min = prices[0]
        var max = prices[0]
        var result = 0
        for (j in 1 until prices.size) {
            if (min > prices[j]) {
                min = prices[j]
                max = prices[j]
            } else if (max < prices[j]) {
                max = prices[j]
            }

            result = max(max - min, result)
        }

        return result
    }
}

fun main() {
//    println(BestTimeToBuyAndSellStock().maxProfit(intArrayOf(0,1,2)))
    println(BestTimeToBuyAndSellStock().maxProfit(intArrayOf(2,1,2,1,0,1,2)))
//    println(BestTimeToBuyAndSellStock().maxProfit(intArrayOf(7,1,5,3,6,4)))
}