package dp2

/**
 * 63. Unique Paths II
 * 8m
 * ===================
 * grid[i][j]가 1이면 0개로 마킹한다.
 * 그외, grid[i][j] 기준 위, 왼 값의 합을 할당한다.
 * i 또는 j의 사이즈가 1일 수 있기 때문에 분기처리를 넣었다.
 */
class UniquePathsII {

    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        for (i in 0 ..< obstacleGrid.size) {
            for (j in 0 ..< obstacleGrid[0].size) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0
                } else {
                    if (i == 0 && j == 0) {
                        obstacleGrid[i][j] = 1
                    } else if (i == 0) {
                        obstacleGrid[i][j] = obstacleGrid[i][j - 1]
                    } else if (j == 0) {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j]
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1]
                    }
                }
            }
        }

        return obstacleGrid[obstacleGrid.size - 1][obstacleGrid[0].size - 1]
    }
}