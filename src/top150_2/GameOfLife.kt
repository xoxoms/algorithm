package top150_2

/**
 * 289. Game of Life
 * 간단한 문제. 과거 못풀어서 북마크해뒀던 이력을 지우게 됐다.
 * ====================
 * 주위 8칸의 값을 합한 값을 갖는 배열을 새로만든다.
 * 위 배열의 값에 따라 본 셀의 값을 업데이트한다.
 */
class GameOfLife {

    fun gameOfLife(board: Array<IntArray>): Unit {
        // 살아있는칸은 =>
        // 주위에 1인칸이 2칸 이상 없으면 죽는다.
        // 주위에 살아있는 경우가 2칸이나 3칸이면 모두 살아남는다.
        // 4이상은 죽는다.
        // 죽은칸은 =>
        // 주위 3칸이 살아있다면 살아난다.

        val acc = Array<IntArray>(board.size) { IntArray(board[0].size) { 0 } }

        for (i in 0 ..< board.size) {
            for (j in 0 ..< board[i].size) {
                if (board[i][j] == 1) {
                    for (y in i - 1 .. i + 1) {
                        for (x in j - 1 .. j + 1) {
                            if (x == -1 || x == board[0].size) { continue }
                            if (y == -1 || y == board.size) { continue }
                            if (x == j && y == i) { continue }
                            acc[y][x]++
                        }
                    }
                }
            }
        }

        for (i in 0 ..< board.size) {
            for (j in 0 ..< board[i].size) {
                if (board[i][j] == 1) {
                    if (acc[i][j] < 2) { board[i][j] = 0 }
                    else if (acc[i][j] > 3) { board[i][j] = 0 }
                } else {
                    if (acc[i][j] == 3) { board[i][j] = 1 }
                }
            }
        }
    }
}