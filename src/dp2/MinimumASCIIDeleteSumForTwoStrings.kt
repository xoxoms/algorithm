package dp2

/**
 * 712. Minimum ASCII Delete Sum for Two Strings
 * 1h
 * =============================================
 * 대각선 값은 이전 통과한 값이므로 l 과 r이 같으면 0, 다르면 두 문자 아스키코드 더한 값 사용
 * 위 값은 현재 l 커서 값이 추가되기 전 통과한 값이므로 위 값 + l 값 사용
 * 왼쪽 값은 현재 r 커서 값이 추가되기 전 통과한 값이므로 왼쪽 값 + r 값 사용
 *
 * 위 세가지 값중 가장 작은 값 dp에 할당
 */
class MinimumASCIIDeleteSumForTwoStrings {

    fun minimumDeleteSum(s1: String, s2: String): Int {
        val dp = Array(s1.length + 1) {
            IntArray(s2.length + 1) {
                Int.MAX_VALUE
            }
        }

        dp[0][0] = 0

        for (i in 0 ..< s1.length) {
            dp[i + 1][0] = s1[i].code + dp[i][0]
        }

        for (i in 0 ..< s2.length) {
            dp[0][i + 1] = s2[i].code + dp[0][i]
        }

        for (l in 1 ..< dp.size) {
            for (r in 1 ..< dp[0].size) {
                val same = s1[l - 1] == s2[r - 1]

                dp[l][r] = minOf(
                    dp[l - 1][r - 1] + if (same) { 0 } else { s1[l - 1].code + s2[r - 1].code },
                    dp[l - 1][r] + s1[l - 1].code,
                    dp[l][r - 1] + s2[r - 1].code,
                )
            }
        }

        return dp[s1.length][s2.length]
    }
}

fun main() {
    println(MinimumASCIIDeleteSumForTwoStrings().minimumDeleteSum("delete", "leet"))
    println(MinimumASCIIDeleteSumForTwoStrings().minimumDeleteSum("sea", "eat"))
}