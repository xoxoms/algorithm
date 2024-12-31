package bfs

import java.util.*

/**
 * 322. Coin Change
 * 남은 금액이 0원이면 리턴한다.
 * 코인을 차감하고 남은 금액을 큐에 넣는다.
 * 방문했는지 체크하여 재계산하지 않는다.
 */
class CoinChange {
    fun coinChange(coins: IntArray, amount: Int): Int {

        val queue = LinkedList<Int>()
        val seen = mutableSetOf<Int>()
        queue.add(amount)

        var round = 0
        while (queue.isNotEmpty()) {
            val polls = mutableListOf<Int>()
            while (queue.isNotEmpty()) {
                val polled = queue.poll()
                if (polled == 0) { return round }
                else if (!seen.contains(polled)) {
                    seen.add(polled)
                    polls.add(polled)
                }
            }

            polls.forEach { polled ->
                val usableCoins = coins.filter { coin ->
                    coin <= polled
                }
                if (usableCoins.isNotEmpty()) {
                    usableCoins.forEach { queue.add(polled - it) }
                }
            }

            round++
        }

        return -1
    }
}

fun main() {
    println(
        CoinChange().coinChange(
            coins = intArrayOf(1),
            amount = 1
        )
    )
    println(
        CoinChange().coinChange(
            coins = intArrayOf(1, 2, 5),
            amount = 100
        )
    )
    println(
        CoinChange().coinChange(
            coins = intArrayOf(1, 2, 5),
            amount = 11
        )
    )
    println(
        CoinChange().coinChange(
            coins = intArrayOf(2),
            amount = 3
        )
    )
}