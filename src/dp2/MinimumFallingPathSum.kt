package dp2

import kotlin.math.min

/**
 * 931. Minimum Falling Path Sum
 * 32m
 * =============================
 * 분기문 처리를 없애기 위해 dp 공간 +2 사이즈로 할당
 * dp[i][j] = matrix[i][j] + min(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1])
 */
class MinimumFallingPathSum {
    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        val map = Array(matrix.size) {
            IntArray(matrix.size + 2) { Int.MAX_VALUE }
        }

        for (i in 1 ..< map[0].size - 1) {
            map[0][i] = matrix[0][i - 1]
        }

        for (i in 1 ..< map.size) {
            for (j in 1 ..< map[0].size - 1) {
                map[i][j] = min(
                    min(
                        map[i - 1][j - 1],
                        map[i - 1][j],
                    ),
                    map[i - 1][j + 1]
                ) + matrix[i][j - 1]
            }
        }

        return map[map.size - 1].min()
    }
}

fun main() {
    MinimumFallingPathSum().minFallingPathSum(
        arrayOf(
            intArrayOf(2,1,3),
            intArrayOf(6,5,4),
            intArrayOf(7,8,9),
        )
    )
}