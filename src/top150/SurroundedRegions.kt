package top150

import java.util.*

/**
 * 130. Surrounded Regions
 * 가장자리를 순회하면서 O인 값을 구해놓는다.
 * 해당 값들을 순회하며 상하좌우로 O가 아닐때까지 반복한다.
 * 해당되는 값들은 결과에 넣는다.
 * 전부 X로 칠한다.
 */
class SurroundedRegions {
    fun solve(board: Array<CharArray>): Unit {
        val result = mutableListOf<Pair<Int, Int>>()
        val targets = mutableSetOf<Pair<Int, Int>>()

        for (i in 0 ..< board[0].size) {
            if (board[0][i] == 'O') { targets.add(Pair(0, i)) }
            if (board[board.size - 1][i] == 'O') { targets.add(Pair(board.size - 1, i)) }
        }

        for (i in 0 ..< board.size) {
            if (board[i][0] == 'O') { targets.add(Pair(i, 0)) }
            if (board[i][board[0].size - 1] == 'O') { targets.add(Pair(i, board[0].size - 1)) }
        }

        val queue = LinkedList<Pair<Int, Int>>()
        val visited = mutableSetOf<Pair<Int, Int>>()
        for (target in targets) {
            queue.add(Pair(target.first - 1, target.second))
            queue.add(Pair(target.first + 1, target.second))
            queue.add(Pair(target.first, target.second - 1))
            queue.add(Pair(target.first, target.second + 1))
            while (queue.isNotEmpty()) {
                val polled = queue.poll()
                if (polled.first < 1 ||
                    polled.second < 1 ||
                    polled.first >= board.size - 1 ||
                    polled.second >= board[0].size - 1 ||
                    board[polled.first][polled.second] == 'X' ||
                    visited.contains(polled)
                ) {
                    continue
                }

                visited.add(polled)
                result.add(polled)
                queue.add(Pair(polled.first - 1, polled.second))
                queue.add(Pair(polled.first + 1, polled.second))
                queue.add(Pair(polled.first, polled.second - 1))
                queue.add(Pair(polled.first, polled.second + 1))
            }
        }


        for (i in 1 ..< board.size - 1) {
            for (j in 1 ..< board[0].size - 1) {
                if (!result.contains(Pair(i, j))) {
                    board[i][j] = 'X'
                }
            }
        }
    }
}

fun main() {
    val board = arrayOf(
        charArrayOf('X','X','X','X',),
        charArrayOf('X','O','O','X',),
        charArrayOf('X','X','O','X',),
        charArrayOf('X','O','X','X',),
    )

    SurroundedRegions().solve(board)
    println(board)
}