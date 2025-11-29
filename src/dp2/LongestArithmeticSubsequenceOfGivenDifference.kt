package dp2

import kotlin.math.max

/**
 * 1218. Longest Arithmetic Subsequence of Given Difference
 * 40m
 * 정석풀이가 아님
 * ========================================================
 * dp를 1로 초기화한다.
 * 0번째 인덱스부터 i 루핑한다.
 * i + 1부터 j 루핑한다.
 * target과 arr[j]가 같다면, arr[i] + 1의 값을 할당한다.
 * 위 방식으로만 처리 시, 타임아웃이 발생한다.
 * arr[i] == arr[j]라면, 나중에 i 루핑에서 처리 될 것이므로 break 해준다.
 */
class LongestArithmeticSubsequenceOfGivenDifference {

    fun longestSubsequence(arr: IntArray, difference: Int): Int {
        val dp = IntArray(arr.size) { 1 }
        var result = 1

        for (i in 0 ..< arr.size - 1) {
            val target = arr[i] + difference
            for (j in i + 1 ..< arr.size) {
                if (target == arr[j]) {
                    dp[j] = max(dp[i] + 1, dp[j])
                    result = max(dp[j], result)
                } else if (arr[i] == arr[j]) {
                    dp[j] = max(dp[j], dp[i])
                    break
                }
            }
        }

        return result
    }
}

fun main() {
    println(
        LongestArithmeticSubsequenceOfGivenDifference().longestSubsequence(
            intArrayOf(1,5,7,8,5,3,4,2,1),
            -2,
        )
    )
}