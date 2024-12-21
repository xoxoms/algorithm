package bfs

import java.util.LinkedList

/**
 * 200. Number of Islands
 * 모든 셀을 순회하면서, 해당 셀에 연결된 모든 셀들을 방문처리한다.
 * 이미 방문처리된 것은 카운팅되지 않으므로 섬의 갯수를 반환가능하다.
 */
class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        var result = 0
        val memoization = mutableSetOf<Pair<Int, Int>>()
        val queue = LinkedList<Pair<Int, Int>>()

        for (i1 in grid.indices) {
            for (j1 in grid[0].indices) {
                if (grid[i1][j1] == '1' && !memoization.contains(i1 to j1)) {
                    result++
                    queue.add(i1 to j1)

                    while (queue.isNotEmpty()) {
                        val polled = queue.poll()
                        val i = polled.first
                        val j = polled.second
                        if (grid[i][j] == '0') { continue }
                        if (!memoization.contains(i to j)) {
                            memoization.add(i to j)
                            if (i - 1 >= 0) { queue.add(i - 1 to j) }
                            if (j - 1 >= 0) { queue.add(i to j - 1) }
                            if (i + 1 < grid.size) { queue.add(i + 1 to j) }
                            if (j + 1 < grid[0].size) { queue.add(i to j + 1) }
                        }
                    }
                }
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    println(NumberOfIslands().numIslands(
        arrayOf(
            charArrayOf('0', '0', '0', '0'),
            charArrayOf('0', '1', '0', '0'),
            charArrayOf('0', '0', '0', '0'),
        )
    ))
    println(NumberOfIslands().numIslands(
        arrayOf(
            charArrayOf('1', '0', '1', '0'),
            charArrayOf('1', '1', '1', '0'),
            charArrayOf('1', '0', '1', '0'),
        )
    ))
    println(NumberOfIslands().numIslands(
        arrayOf(
            charArrayOf('1', '0', '1', '0'),
            charArrayOf('1', '0', '1', '0'),
            charArrayOf('1', '0', '1', '0'),
        )
    ))
}