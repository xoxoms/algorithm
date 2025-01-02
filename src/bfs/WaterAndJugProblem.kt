package bfs

import java.util.*
import kotlin.math.min

/**
 * 365. Water and Jug Problem
 * 경우의수만큼 반영된 금액을 큐에 넣는다.
 * target에 도달하면 true를 응답한다.
 * 모든 값이 visited됐는데 target에 도달하지 못했다면 false를 응답한다.
 *
 * 경우의수
 * x 채운다
 * y 채운다
 * x 비운다
 * y 비운다
 * x 따른다
 * y 따른다
 */
class WaterAndJugProblem {
    fun canMeasureWater(x: Int, y: Int, target: Int): Boolean {
        val fill = { jugs: IntArray, idx: Int ->
            val capacity = if (idx == 0) { x } else { y }
            jugs[idx] = capacity
            jugs
        }
        val empty = { jugs: IntArray, idx: Int ->
            jugs[idx] = 0
            jugs
        }
        val pour = { jugs: IntArray, from: Int ->
            val to: Int
            val poured: Int
            if (from == 0) {
                to = 1
                poured = min(jugs[from], y - jugs[to])
            } else {
                to = 0
                poured = min(jugs[from], x - jugs[to])
            }

            jugs[from] = jugs[from] - poured
            jugs[to] = jugs[to] + poured
            jugs
        }

        val queue = LinkedList<IntArray>()
        val visited = mutableSetOf<Pair<Int, Int>>()
        queue.add(intArrayOf(0, 0))
        while (queue.isNotEmpty()) {
            val polls = mutableListOf<IntArray>()
            while (queue.isNotEmpty()) {
                val polled = queue.poll()
                if (polled[0] + polled[1] == target) { return true }
                if (visited.contains(polled[0] to polled[1])) {
                    continue
                } else {
                    visited.add(polled[0] to polled[1])
                    polls.add(polled)
                }
            }

            for (polled in polls) {
                queue.add(fill(intArrayOf(polled[0], polled[1]), 0))
                queue.add(fill(intArrayOf(polled[0], polled[1]), 1))
                queue.add(pour(intArrayOf(polled[0], polled[1]), 0))
                queue.add(pour(intArrayOf(polled[0], polled[1]), 1))
                queue.add(empty(intArrayOf(polled[0], polled[1]), 0))
                queue.add(empty(intArrayOf(polled[0], polled[1]), 1))
            }
        }

        return false
    }
}

fun main() {
    println(WaterAndJugProblem().canMeasureWater(3, 5, 4))
}