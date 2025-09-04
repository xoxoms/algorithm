package dp2

/**
 * 62. Unique Paths
 * 5m
 * ================
 * dp로 해결한다.
 * dp[m - 1][n - 1] = dp[m - 1][n - 1 - 1] + dp[m - 1 - 1][n - 1]
 */
class UniquePaths {

    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m) { IntArray(n) { 1 } }

        for (i in 1 ..< m) {
            for (j in 1 ..< n) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
            }
        }

        return dp[m - 1][n - 1]
    }
}