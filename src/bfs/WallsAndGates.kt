package bfs

import java.util.*
import kotlin.math.min

/**
 * 286. Walls and Gates
 */
class WallsAndGates {
    private val visited = mutableMapOf<Pair<Int, Int>, Int?>()

    fun solution(rooms: Array<IntArray>): Unit {
        if (rooms.isEmpty()) { return }
        val queue = LinkedList<Triple<Int, Int, Int>>()

        for (i in 0..<rooms.size) {
            for (j in 0..<rooms[0].size) {
                if (rooms[i][j] == 0) {
                    queue.add(Triple(i, j, 0))
                    val set = mutableSetOf<Pair<Int, Int>>()
                    while (queue.isNotEmpty()) {
                        val polled = queue.poll()
                        if (set.contains(Pair(polled.first, polled.second))) { continue }

                        set.add(Pair(polled.first, polled.second))
                        if (visited[Pair(polled.first, polled.second)] == null) {
                            visited[Pair(polled.first, polled.second)] = polled.third
                        } else {
                            visited[Pair(polled.first, polled.second)] = min(visited[Pair(polled.first, polled.second)]!!, polled.third)
                        }

                        if (polled.first - 1 > -1 && rooms[polled.first - 1][polled.second] > 0) { queue.add(Triple(polled.first - 1, polled.second, polled.third + 1)) }
                        if (polled.second - 1 > -1 && rooms[polled.first][polled.second - 1] > 0) { queue.add(Triple(polled.first, polled.second - 1, polled.third + 1)) }
                        if (polled.first + 1 < rooms.size && rooms[polled.first + 1][polled.second] > 0) { queue.add(Triple(polled.first + 1, polled.second, polled.third + 1)) }
                        if (polled.second + 1 < rooms[0].size && rooms[polled.first][polled.second + 1] > 0) { queue.add(Triple(polled.first, polled.second + 1, polled.third + 1)) }
                        rooms[polled.first][polled.second] = visited[Pair(polled.first, polled.second)]!!
                    }
                }
            }
        }

        return
    }
}

fun main() {
    println(
        WallsAndGates().solution(
            arrayOf(
                intArrayOf(2147483647,-1,0,2147483647),
                intArrayOf(2147483647,2147483647,2147483647,-1),
                intArrayOf(2147483647,-1,2147483647,-1),
                intArrayOf(0,-1,2147483647,2147483647),
            )
        )
    )
}