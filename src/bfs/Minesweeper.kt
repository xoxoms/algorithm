package bfs

import java.util.*

/**
 * 529. Minesweeper
 * 클릭한 곳이
 * M이면 X로 변경한다.
 * E이면 주변 칸을 밝힌다.
 * 만약 폭탄 인근이면 밝힘이 전파되지 않는다.
 */
class Minesweeper {
    private val MINE = 'M'
    private val UNREVEALED_EMPTY_SQUARE = 'E'
    private val REVEALED_EMPTY_SQUARE = 'B'
    private val GAME_OVER = 'X'

    fun updateBoard(board: Array<CharArray>, click: IntArray): Array<CharArray> {
        val queue = LinkedList<Pair<Int, Int>>()
        if (board[click[0]][click[1]] == MINE) {
            board[click[0]][click[1]] = GAME_OVER
            return board
        }

        val reveal = { position: IntArray ->
            listOf(
                position[0] - 1 to position[1] - 1,
                position[0] - 1 to position[1],
                position[0] - 1 to position[1] + 1,
                position[0] to position[1] - 1,
                position[0] to position[1] + 1,
                position[0] + 1 to position[1] - 1,
                position[0] + 1 to position[1],
                position[0] + 1 to position[1] + 1,
            ).filter {
                it.first >= 0 && it.second >= 0 && it.first < board.size && it.second < board[0].size
            }
        }

        queue.add(click[0] to click[1])
        val visited = mutableSetOf<Pair<Int, Int>>()
        while (queue.isNotEmpty()) {
            val polled = queue.poll()
            val revealed = reveal(intArrayOf(polled.first, polled.second))
            val mines = revealed.filter { board[it.first][it.second] == MINE }

            if (mines.isEmpty()) {
                board[polled.first][polled.second] = REVEALED_EMPTY_SQUARE
                revealed.forEach {
                    if (!visited.contains(it)) {
                        visited.add(it)
                        queue.add(it)
                    }
                }
            } else {
                board[polled.first][polled.second] = mines.size.digitToChar()
            }
        }

        return board
    }
}

fun main() {
    val result =
        Minesweeper().updateBoard(
            board = arrayOf(
                charArrayOf('E','E','E','E','E'),
                charArrayOf('E','E','M','E','E'),
                charArrayOf('E','E','E','E','E'),
                charArrayOf('E','E','E','E','E'),
            ),
            click = intArrayOf(3, 0)
//            click = intArrayOf(1, 2)
        )

    for (i in 0 until result.size) {
        for (j in 0 until result[0].size) {
            print("${result[i][j]} ")
        }
        println()
    }
}