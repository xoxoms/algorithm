package top150_2

/**
 * 63. Unique Paths II
 * 30m
 * ===================
 * 로봇은 오른족, 아래로만 이동가능하다.
 * dp[][] 값에 해당 위치로 이동가능한 길수를 저장한다.
 * 즉, 각 컬럼에 위와 왼쪽의 값을 더한다.
 * 마지막 컬럼의 값을 반환한다.
 */
class UniquePathsII {

    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        if (obstacleGrid.isEmpty() || obstacleGrid[0][0] == 1) {  return 0  }
        val paths = Array<IntArray>(obstacleGrid.size) {  IntArray(obstacleGrid.first().size) { 0 } }


        for (i in 0 ..< obstacleGrid.size) {
            if (obstacleGrid[i][0] == 1) {
                break
            }

            paths[i][0] = 1
        }

        for (i in 0 ..< obstacleGrid.first().size) {
            if (obstacleGrid[0][i] == 1) {
                break
            }

            paths[0][i] = 1
        }

        for (i in 1 ..< obstacleGrid.size) {
            for (j in 1 ..< obstacleGrid.first().size) {
                if (obstacleGrid[i][j] == 0) {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1]
                }
            }
        }

        return paths.last().last()
    }
}

fun main() {
    println(
        UniquePathsII().uniquePathsWithObstacles(
            arrayOf(
                intArrayOf(0,1,0,0),
            )
        )
    )
    println(
        UniquePathsII().uniquePathsWithObstacles(
            arrayOf(
                intArrayOf(0,0,0),
                intArrayOf(0,1,0),
                intArrayOf(0,0,0),
            )
        )
    )
    println(
        UniquePathsII().uniquePathsWithObstacles(
            arrayOf(
                intArrayOf(0,1),
                intArrayOf(0,0),
            )
        )
    )
    println(
        UniquePathsII().uniquePathsWithObstacles(
            arrayOf(
                intArrayOf(1,0),
            )
        )
    )
}