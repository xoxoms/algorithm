package dp2

import kotlin.math.max

/**
 * 516. Longest Palindromic Subsequence !!
 * 2h 30m
 * ====================================
 * i는 역순으로, j는 정순으로 반복문을 수행한다.
 * 2중 dp 테이블을 만든다.
 * i == j라면 1을 채운다.
 * 이 중포문을 도는데, s[i] == s[j]라면 [i+1][j-1] + 2의 값을 쓴다.
 * 그 외, 아래 혹은 왼쪽의 dp 테이블 값을 취한다.
 */
class LongestPalindromicSubsequence {
    fun longestPalindromeSubseq(s: String): Int {
        val arr = Array(s.length) { IntArray(s.length) { 0 } }

        for (i in s.length - 1 downTo 0) {
            arr[i][i] = 1

            for (j in i + 1 ..< s.length) {
                arr[i][j] = if (s[i] == s[j]) {
                    arr[i + 1][j - 1] + 2
                } else {
                    max(arr[i][j - 1], arr[i + 1][j])
                }
            }
        }

        return arr[0][s.length - 1]
    }
}

fun main() {
    println(LongestPalindromicSubsequence().longestPalindromeSubseq("aabaaba"))
    println(LongestPalindromicSubsequence().longestPalindromeSubseq("bbbab"))
    println(LongestPalindromicSubsequence().longestPalindromeSubseq("cbbd"))
    println(LongestPalindromicSubsequence().longestPalindromeSubseq("p"))
    println(LongestPalindromicSubsequence().longestPalindromeSubseq("racecarracecarracecarracecarracecar"))
}