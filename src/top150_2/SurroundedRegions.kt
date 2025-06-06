package top150_2

/**
 * 130. Surrounded Regions
 * 1h
 * 연산 시간이 높게 나왔다.
 * ========================
 * 보드를 순회한다.
 * 현재값이 O일때 함수(DFS)를 호출한다.
 * 방문처리 한다.
 * 함수호출된 대상 현재 값이 'O'이면 상하좌우도 함수 호출한다.
 * 함수호출된 대상 현재 포지션이 보더(가장자리)이면 true를 반환한다.
 */
class SurroundedRegions {
    private val visited = mutableSetOf<Pair<Int, Int>>()

    fun solve(board: Array<CharArray>) {
        for (i in 1 ..< board.size - 1) {
            for (j in 1 ..< board[i].size - 1) {
                if (board[i][j] == 'O' && visited.contains(Pair(i, j)) == false) {
                    val related = mutableSetOf<Pair<Int, Int>>()
                    val result = isRegion(board, Pair(i,j), related)
                    visited.addAll(related)
                    if (result == false) {
                        related.forEach {
                            board[it.first][it.second] = 'X'
                        }
                    }
                }
            }
        }
    }

    private fun isRegion(board: Array<CharArray>, position: Pair<Int, Int>, related: MutableSet<Pair<Int, Int>>): Boolean {
        if (related.contains(position)) {
            return false
        } else {
            related.add(position)
        }

        if (board[position.first][position.second] == 'X') {
            return false
        }

        if (position.first == 0 ||
            position.first == board.size - 1 ||
            position.second == 0 ||
            position.second == board[0].size - 1) {
            return true
        } else {
            val items = mutableListOf<Pair<Int, Int>>()
            items.add(Pair(position.first - 1, position.second))
            items.add(Pair(position.first + 1, position.second))
            items.add(Pair(position.first, position.second - 1))
            items.add(Pair(position.first, position.second + 1))

            return items.any {
                isRegion(board, it, related) == true
            }
        }
    }
}