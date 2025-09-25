package dp2

/**
 * 72. Edit Distance
 * 5d
 * 어려웠다.
 * =================
 * dp 테이블을 초기화한다.
 * 삽입/삭제/수정을 고려하여 dp 테이블에 min값을 할당한다.
 */
class EditDistance {

    fun minDistance(word1: String, word2: String): Int {
        val dp = Array<IntArray>(word1.length + 1) {
            IntArray(word2.length + 1) { Int.MIN_VALUE }
        }

        for (i in 0 ..< dp.size) { dp[i][0] = i }
        for (i in 0 ..< dp[0].size) { dp[0][i] = i }

        for (l in 1 ..< dp.size) {
            for (r in 1 ..< dp[0].size) {
                dp[l][r] = minOf(
                    dp[l - 1][r - 1] + if (word1[l - 1] == word2[r - 1]) { 0 } else { 1 },
                    dp[l - 1][r] + 1,
                    dp[l][r - 1] + 1,
                )
            }
        }

        return dp[word1.length][word2.length]
    }
}

fun main() {
    println(EditDistance().minDistance("plasma", "altruism"))
    println(EditDistance().minDistance("mart", "karma"))
    println(EditDistance().minDistance("sea", "eat"))
    println(EditDistance().minDistance("", "a"))
    println(EditDistance().minDistance("", ""))
    println(EditDistance().minDistance("intention", "execution"))
    println(EditDistance().minDistance("horse", "ros"))
}