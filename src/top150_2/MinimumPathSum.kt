package top150_2

/**
 * 64. Minimum Path Sum
 * 39m
 * ====================
 * 오른쪽과 아래로만 이동할 수 있다.
 * dp로 해결한다.
 * dp[][]의 값은 왼쪽과 위쪽의 더 작은값이 할당된다.
 * db.last.last를 응답한다.
 */
class MinimumPathSum {

    fun minPathSum(grid: Array<IntArray>): Int {
        if (grid.isEmpty()) {
            return 0
        }

        val items = Array(grid.size) { IntArray(grid.first().size) { 0 } }
        items[0][0] = grid[0][0]

        for (i in 0 ..< grid.size) {
            for (j in 0 ..< grid.first().size) {
                if (i == 0 && j == 0) { continue }

                val above = if (i == 0) {
                    items[i][j - 1]
                } else {
                    items[i - 1][j]
                }

                val left = if (j == 0) {
                    items[i - 1][j]
                } else {
                    items[i][j - 1]
                }

                val current = grid[i][j]
                items[i][j] = if (above > left) {
                    left
                } else {
                    above
                } + current
            }
        }

        return items[grid.size - 1][grid.first().size - 1]
    }
}

fun main() {
    println(
        MinimumPathSum().minPathSum(
            arrayOf(
                intArrayOf(1,3,1),
                intArrayOf(1,5,1),
                intArrayOf(4,2,1),
            )
        )
    )
}