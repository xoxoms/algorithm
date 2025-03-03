package top150_2

import kotlin.math.max

/**
 * 121. Best Time to Buy and Sell Stock
 * 이지인데 왜이렇게 안풀리는지..
 * 0번째를 min값에 넣어둔다.
 * i를 순회하면서 min보다 작으면 min을 갱신한다.
 * min보다 크다면 result를 더 큰 값으로 치환한다.
 */
class BestTimeToBuyAndSellStock {

    fun maxProfit(prices: IntArray): Int {
        var min = prices[0]
        var result = 0

        for (i in 1 ..< prices.size) {
            if (prices[i] < min) {
                min = prices[i]
            } else {
                result = max(result, prices[i] - min)
            }
        }

        return result
    }
}