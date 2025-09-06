package dp2

import kotlin.math.max
import kotlin.math.min

/**
 * 221. Maximal Square
 * 2h
 * ===================
 * dp 맵 변수생성한다.
 * 맨 아래와, 맨 오른쪽 값을 할당한다.
 * 역방향으로 dp 값을 순회한다.
 * dp[i][j] 값은 min(오른쪽, 아래, 대각선아래)이다.
 */
class MaximalSquare {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        var result = 0

        val map = Array(matrix.size) { IntArray(matrix[0].size) }
        for (i in 0 ..< map.size) {
            map[i][map[0].size - 1] = matrix[i][map[0].size - 1].digitToInt()
        }
        for (i in 0 ..< map[0].size) {
            map[map.size - 1][i] = matrix[map.size - 1][i].digitToInt()
        }

        for (i in map.size - 1 downTo 0) {
            for (j in map[0].size - 1 downTo 0) {
                if (i == map.size - 1 || j == map[0].size - 1) {
                    map[i][j] = matrix[i][j].digitToInt()
                } else {
                    map[i][j] = if (matrix[i][j] == '0') {
                        matrix[i][j].digitToInt()
                    } else {
                        min(
                            min(
                                map[i + 1][j],
                                map[i][j + 1],
                            ),
                            map[i + 1][j + 1],
                        ) + 1
                    }
                }

                result = max(result, map[i][j] * map[i][j])
            }
        }

        return result
    }
}

fun main() {
    println(
        MaximalSquare().maximalSquare(
            arrayOf(
                charArrayOf('1'),
            )
        )
    )
    println(
        MaximalSquare().maximalSquare(
            arrayOf(
                charArrayOf('1','0','1','0','0'),
                charArrayOf('1','0','1','1','1'),
                charArrayOf('1','1','1','1','1'),
                charArrayOf('1','0','0','1','0'),
            )
        )
    )
    println(
        MaximalSquare().maximalSquare(
            arrayOf(
                charArrayOf('1','1','1','1','1','1','1','1'),
                charArrayOf('1','1','1','1','1','1','1','0'),
                charArrayOf('1','1','1','1','1','1','1','0'),
                charArrayOf('1','1','1','1','1','0','0','0'),
                charArrayOf('0','1','1','1','1','0','0','0'),
            )
        )
    )
}