package bfs

import java.util.*

/**
 * 279. Perfect Squares !!
 * 큐에 남은수를 넣고, 0이될때까지 반복한다.
 * 0이 나오면 즉시 현재 라운드를 리턴하는데, 반쪽짜리 풀이같다.
 */
class PerfectSquares {
    fun numSquares(n: Int): Int {
        val queue = LinkedList<Pair<Int, Int>>()
        queue.add(n to 0)

        while (queue.isNotEmpty()) {
            val polled = queue.poll()
            val remaining = polled.first
            val max = Math.sqrt(remaining.toDouble()).toInt()

            for (i in max downTo 1) {
                val value = i * i
                if (remaining == value) {
                    return polled.second + 1
                } else {
                    queue.add(remaining - value to polled.second + 1)
                }
            }
        }

        return n
    }
}

fun main() {
    println(PerfectSquares().numSquares(12))
    println(PerfectSquares().numSquares(13))
    println(PerfectSquares().numSquares(9))
}