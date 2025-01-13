package top150

/**
 * 73. Set Matrix Zeroes
 * 0 값인 원소 포지션을 큐에 넣는다.
 * 큐 전부 꺼내서 각각 열과 행 모두 0으로 변경한다.
 */
class SetMatrixZeroes {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val positions = mutableSetOf<Pair<Int, Int>>()
        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[0].size) {
                if (matrix[i][j] == 0) {
                    positions.add(Pair(i, j))
                }
            }
        }

        for (position in positions) {
            for (i in 0 until matrix.size) {
                matrix[i][position.second] = 0
            }
            for (j in 0 until matrix[0].size) {
                matrix[position.first][j] = 0
            }
        }
    }
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(1,1,1),
        intArrayOf(1,0,1),
        intArrayOf(1,1,1),
    )
    SetMatrixZeroes().setZeroes(matrix)
    matrix.forEach { item -> item.forEach { print("$it ") } }
    println()
}