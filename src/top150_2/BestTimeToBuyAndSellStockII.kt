package top150_2

/**
 * 122. Best Time to Buy and Sell Stock II
 * i, j(i+1)로 초기화해서 이윤이 발생하면 결과에 더하고 최종 결과를 응답한다.
 */
class BestTimeToBuyAndSellStockII {

    fun maxProfit(prices: IntArray): Int {
        var result = 0
        var i = 0
        while (i < prices.size - 1) {
            var j = i + 1
            while (j < prices.size) {
                if (prices[j] > prices[i]) {
                    result += prices[j] - prices[i]
                    i = j
                    break
                } else {
                    i++
                }
                j++
            }
        }

        return result
    }
}