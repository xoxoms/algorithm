package top150

/**
 * 79. Word Search
 * 35m
 * 처음부터 backTracking으로 짜지 않아서 효율이 안좋게 된듯하다.
 * 이런 류에서는 백트래킹을 사용해보자.
 * =====================
 * 2중 포문을 돈다.
 * visited를 관리한다.
 * word와 현재 위치, 처리할 문자를 인자로 받는 함수를 만든다.
 * 현재 위치의 동서남북 중 다음 값과 동일한 경우 재귀 처리한다.
 * word의 끝까지 따라간 경우 true를 리턴한다.
 */
class WordSearch {
    private val visited = mutableSetOf<Pair<Int, Int>>()

    fun exist(board: Array<CharArray>, word: String): Boolean {
        for (i in board.indices) {
            for (j in board[i].indices) {
                visited.clear()
                if (board[i][j] == word[0]) {
                    val result = recursive(board, word, 0, i, j,)
                    if (result) {
                        return true
                    }
                }
            }
        }

        return false
    }

    private fun recursive(
        board: Array<CharArray>,
        word: String,
        currentIdx: Int,
        currentX: Int,
        currentY: Int,
    ): Boolean {
        if (currentX < 0 || currentY < 0 || currentX >= board.size || currentY >= board[0].size) { return false }

        if (visited.contains(Pair(currentX, currentY))) { return false }
        visited.add(Pair(currentX, currentY))
        if (board[currentX][currentY] == word[currentIdx]) {
            if (currentIdx == word.length - 1) {
                return true
            } else if (
                recursive(board, word, currentIdx + 1, currentX + 1, currentY) ||
                recursive(board, word, currentIdx + 1, currentX - 1, currentY) ||
                recursive(board, word, currentIdx + 1, currentX, currentY + 1) ||
                recursive(board, word, currentIdx + 1, currentX, currentY - 1)
            ) {
                return true
            }
        }
        visited.remove(Pair(currentX, currentY))

        return false
    }
}

fun main() {
    println(
        WordSearch().exist(
            arrayOf(
                charArrayOf('a', 'a')
            ),
            "aa"
        )
    )

    println(
        WordSearch().exist(
            arrayOf(
                charArrayOf('a')
            ),
            "a"
        )
    )

    println(
        WordSearch().exist(
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E'),
            ),
            "ABCCED"
        )
    )
}