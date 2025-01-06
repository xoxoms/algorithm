package top150

import java.util.*
import kotlin.math.max

/**
 * 122. Best Time to Buy and Sell Stock II
 * BFS O(N) 30m
 * DFS O(N) 10m
 */
class BestTimeToBuyAndSellStockII {

    /**
     * DFS
     * 현재인덱스를 받아서 내일과 차액을 반환하는 함수를 만든다.
     * 위를 재귀 호출한다.
     *
     */
    fun maxProfit(prices: IntArray): Int {
        return recursive(0, prices)
    }

    private fun recursive(idx: Int, prices: IntArray): Int {
        if (idx + 1 == prices.size) { return 0 }
        return max(prices[idx + 1] - prices[idx], 0) + recursive(idx + 1, prices)
    }

    /**
     * BFS
     * 큐를 꺼낸다.
     * profit에 반영한다.
     * 오늘보다 내일이 비싸면 큐에 넣는다.
     * 오늘보다 내일이 싸면 큐에 넣지 않는다.
     */
    fun maxProfitBFS(prices: IntArray): Int {
        var result = 0
        val queue = LinkedList<Int>()
        for (i in 0 until prices.size) {
            val polled = queue.poll()
            if (polled != null) {
                result += prices[i] - polled
            }

            if (i + 1 < prices.size && prices[i] < prices[i + 1]) {
                queue.add(prices[i])
            }
        }

        return result
    }
}

fun main() {
    println(BestTimeToBuyAndSellStockII().maxProfit(intArrayOf(1,2,3,4,5)))
    println(BestTimeToBuyAndSellStockII().maxProfit(intArrayOf(7,1,5,3,6,4)))
}