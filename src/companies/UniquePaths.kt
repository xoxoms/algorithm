package companies

/**
 * 62. Unique Paths !!
 * DP
 */
class UniquePaths {

    fun uniquePaths(m: Int, n: Int): Int {
        val map = mutableListOf<IntArray>()
        for (i in 0 until m) { map.add(IntArray(n) { 1 }) }
        for (i in m - 1 downTo 0) {
            for (j in n - 1 downTo 0) {
                map[i][j] = if (i == m -1 && j == n - 1) {
                    1
                } else {
                    val right = if (j + 1 == n) 0 else map[i][j + 1]
                    val bottom = if (i + 1 == m) 0 else map[i + 1][j]
                    right + bottom
                }
            }
        }

        return map[0][0]
    }
}

fun main() {
    println(UniquePaths().uniquePaths(3, 7))
}