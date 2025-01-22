package top150

import java.util.*


/**
 * 200. Number of Islands
 * 가변하는 섬 갯수 변수를 둔다.
 * 이중 포문으로 i, j 를 순회한다.
 * 원소가 1이면 해당 값을 기준으로 상하좌우의 값을 큐에 넣는다.
 * 방문처리한다.
 * 더이상 새로운 1이 없을때까지 반복한다.
 * 위 이중 포문 루프를 반복한다.
 */
class NumberOfIslands {

    fun numIslands(grid: Array<CharArray>): Int {
        val visited = mutableSetOf<Pair<Int, Int>>()
        val queue = LinkedList<Pair<Int, Int>>()
        var result = 0

        for (i in 0 ..< grid.size) {
            for (j in 0 ..< grid[0].size) {
                if (grid[i][j] == '1' && !visited.contains(Pair(i, j))) {
                    queue.add(Pair(i + 1, j))
                    queue.add(Pair(i - 1, j))
                    queue.add(Pair(i, j + 1))
                    queue.add(Pair(i, j - 1))
                    result++
                    while (queue.isNotEmpty()) {
                        val polled = queue.poll()
                        if (visited.contains(Pair(polled.first, polled.second))) {
                            continue
                        } else {
                            if (polled.first < 0 ||
                                polled.second < 0 ||
                                polled.first >= grid.size ||
                                polled.second >= grid[0].size ||
                                grid[polled.first][polled.second] == '0'
                            ) { continue }

                            visited.add(Pair(polled.first, polled.second))
                            queue.add(Pair(polled.first - 1, polled.second))
                            queue.add(Pair(polled.first + 1, polled.second))
                            queue.add(Pair(polled.first, polled.second - 1))
                            queue.add(Pair(polled.first, polled.second + 1))
                        }
                    }
                }
            }
        }

        return result
    }
}

fun main() {
    println(
        NumberOfIslands().numIslands(
            arrayOf(
                charArrayOf('1','1','1','1','0',),
                charArrayOf('1','1','0','1','0',),
                charArrayOf('1','1','0','0','0',),
                charArrayOf('0','0','0','0','0',),
            ),
        )
    )
}