package dp2

import kotlin.math.min

/**
 * 64. Minimum Path Sum
 * 15m
 * ====================
 * i,j 둘다 0부터시작한다.
 * i,j 값 분기하여 min 값을 구한다.
 * dp[i][j]에 min + dp[i][j]를 할당해준다.
 */
class MinimumPathSum {
    fun minPathSum(grid: Array<IntArray>): Int {

        for (i in 0 ..< grid.size) {
            for (j in 0 ..< grid[0].size) {
                val min = if (i == 0 && j == 0) {
                    0
                } else if (i == 0) {
                    grid[i][j - 1]
                } else if (j == 0) {
                    grid[i - 1][j]
                } else {
                    min(grid[i][j - 1], grid[i - 1][j])
                }

                grid[i][j] = grid[i][j] + min
            }
        }

        return grid[grid.size - 1][grid[0].size - 1]
    }
}