package top150_2

import java.util.LinkedList

/**
 * 200. Number of Islands
 * 해결했으나, 효율이 구리다.
 * 하위 5%
 * 50m
 * ======================
 * i,j 각 칸을 순회한다.
 * grid[i][j]가 0이아니면, result++한다.
 * i,j를 큐에 넣는다.
 * 큐를 순회하며 상하좌우를 넣는다.
 * 0이아니면 반복한다.
 * 방문처리도 처리한다.
 */
class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        val visited = mutableSetOf<Pair<Int, Int>>()
        val queue = LinkedList<Pair<Int, Int>>()

        var result = 0
        for (i in 0 ..< grid.size) {
            for (j in 0 ..< grid[0].size) {
                if (visited.contains(Pair(i, j))) {
                    continue
                } else {
                    visited.add(Pair(i, j))
                    if (grid[i][j] == '0') { continue }
                    result++
                    queue.add(Pair(i, j))

                    while (queue.isNotEmpty()) {
                        val poll = queue.poll()
                        if (grid[poll.first][poll.second] == '0') { continue }

                        if (poll.first > 0) {
                            if (!visited.contains(Pair(poll.first - 1, poll.second))) {
                                visited.add(Pair(poll.first - 1, poll.second))
                                queue.add(Pair(poll.first - 1, poll.second))
                            }
                        }
                        if (poll.first < grid.size - 1) {
                            if (!visited.contains(Pair(poll.first + 1, poll.second))) {
                                visited.add(Pair(poll.first + 1, poll.second))
                                queue.add(Pair(poll.first + 1, poll.second))
                            }
                        }
                        if (poll.second > 0) {
                            if (!visited.contains(Pair(poll.first, poll.second - 1))) {
                                visited.add(Pair(poll.first, poll.second - 1))
                                queue.add(Pair(poll.first, poll.second - 1))
                            }
                        }
                        if (poll.second < grid[0].size - 1) {
                            if (!visited.contains(Pair(poll.first, poll.second + 1))) {
                                visited.add(Pair(poll.first, poll.second + 1))
                                queue.add(Pair(poll.first, poll.second + 1))
                            }
                        }
                    }
                }
            }
        }

        return result
    }
}

fun main() {
    println(NumberOfIslands()
        .numIslands(
            arrayOf(
                charArrayOf('1','1','1','1','0'),
                charArrayOf('1','1','0','1','0'),
                charArrayOf('1','1','0','0','0'),
                charArrayOf('0','0','0','0','0'),
            ),
        )
    )
}