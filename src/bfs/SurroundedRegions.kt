package bfs

/**
 * 130. Surrounded Regions
 * 상하좌우로 모든 경우의수 확인하는 방식으로 접근함 보완필요
 */
class SurroundedRegions {


    private val memoization = mutableMapOf<Pair<Int, Int>, Boolean>()
    fun solve(board: Array<CharArray>): Unit {

        for (i in 0 until board.size) {
            for (j in 0 until board[0].size) {
                if (board[i][j] == 'X') { continue }
                val current = mutableSetOf<Pair<Int, Int>>()
                val markAndReturn = markAndReturn(board, i, j, current)
                current.forEach { memoization[it] = markAndReturn }
                memoization[i to j] = markAndReturn
                if (!markAndReturn) {
                    board[i][j] = 'X'
                }
            }
        }
    }

    private fun markAndReturn(board: Array<CharArray>, i: Int, j: Int, current: MutableSet<Pair<Int, Int>>): Boolean {
        if (memoization[Pair(i, j)] != null) {
            return memoization[Pair(i, j)]!!
        }
        current.add(Pair(i, j))

        val result = if (i < 0 || i > board.lastIndex || j < 0 || j > board[0].lastIndex || board[i][j] == 'X') {
            false
        } else {
            val subResult = mutableListOf<Boolean>()
            if (i + 1 < board.size && board[i+1][j] == 'O' && !current.contains(i+1 to j)) { subResult.add(markAndReturn(board, i + 1, j, current)) }
            if (j + 1 < board[0].size && board[i][j+1] == 'O' && !current.contains(i to j+1)) { subResult.add(markAndReturn(board, i, j + 1, current)) }
            if (i - 1 >= 0 && board[i-1][j] == 'O' && !current.contains(i-1 to j)) { subResult.add(markAndReturn(board, i - 1, j, current)) }
            if (j - 1 >= 0 && board[i][j-1] == 'O' && !current.contains(i to j-1)) { subResult.add(markAndReturn(board, i, j - 1, current)) }

            val isEnd = i == 0 || j == 0 || i == board.lastIndex || j == board[0].lastIndex
            subResult.firstOrNull { it } ?: false || (board[i][j] == 'O' && isEnd)
        }
        return result
    }
}

fun main() {
    val request = arrayOf(
//        charArrayOf('O','X','X','O','X'),
//        charArrayOf('X','O','O','X','O'),
//        charArrayOf('X','O','X','O','X'),
//        charArrayOf('O','X','O','O','O'),
//        charArrayOf('X','X','O','X','O'),

//        charArrayOf('O', 'O', 'O', 'O', 'X', 'X'),
//        charArrayOf('O', 'O', 'O', 'O', 'O', 'O'),
//        charArrayOf('O', 'X', 'O', 'X', 'O', 'O'),
//        charArrayOf('O', 'X', 'O', 'O', 'X', 'O'),
//        charArrayOf('O', 'X', 'O', 'X', 'O', 'O'),
//        charArrayOf('O', 'X', 'O', 'O', 'O', 'O'),

//        charArrayOf('O','X','O','O','X','X'),
//        charArrayOf('O','X','X','X','O','X'),
//        charArrayOf('X','O','O','X','O','O'),
//        charArrayOf('X','O','X','X','X','X'),
//        charArrayOf('O','O','X','O','X','X'),
//        charArrayOf('X','X','O','O','O','O'),
//

//        charArrayOf('O','O','O','O','X','X'),
//        charArrayOf('O','O','O','O','O','O'),
//        charArrayOf('O','X','O','X','O','O'),
//        charArrayOf('O','X','O','O','X','O'),
//        charArrayOf('O','X','O','X','O','O'),
//        charArrayOf('O','X','O','O','O','O'),

//
//        charArrayOf('X', 'X', 'X', 'X'),
//        charArrayOf('X', 'O', 'O', 'X'),
//        charArrayOf('X', 'X', 'O', 'X'),
//        charArrayOf('X', 'O', 'X', 'X'),

//        charArrayOf('O','X','O','O','O','X'),
//        charArrayOf('O','O','X','X','X','O'),
//        charArrayOf('X','X','X','X','X','O'),
//        charArrayOf('O','O','O','O','X','X'),
//        charArrayOf('X','X','O','O','X','O'),
//        charArrayOf('O','O','X','X','X','X'),
//        charArrayOf('O','X','O','O','O','X'),
//        charArrayOf('O','O','X','X','X','O'),
//        charArrayOf('X','X','X','X','X','O'),
//        charArrayOf('O','O','O','O','X','X'),
//        charArrayOf('X','X','O','O','X','O'),
//        charArrayOf('O','O','X','X','X','X'),


        charArrayOf('O', 'O', 'O'),
        charArrayOf('O', 'O', 'O'),
        charArrayOf('O', 'O', 'O'),
//        charArrayOf('O', 'X', 'O'),
//        charArrayOf('X', 'O', 'X'),
//        charArrayOf('O', 'X', 'O'),
    )

    request.forEach { it ->
        for (c in it) {
            print("$c ")
        }
        println()
    }

    println(
        SurroundedRegions().solve(
//            board = arrayOf(
//                charArrayOf('O', 'O', 'O'),
//                charArrayOf('O', 'O', 'O'),
//                charArrayOf('O', 'O', 'O'),
//            )
            board = request
        )
    )

    request.forEach { it ->
        for (c in it) {
            print("$c ")
        }
        println()
    }
}