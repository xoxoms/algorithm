package top150_2

/**
 * 5. Longest Palindromic Substring
 * 1h 30m
 * ================================
 * s를 순회한다.
 * l에 i를 할당한다.
 * l과 i가 다를때까지 i++하고 r을 구한다.
 * l - 1, r + 1을 비교하면서 같으면 result를 갱신한다.
 */
class LongestPalindromicSubstring {

    fun longestPalindrome(s: String): String {
        var result = ""

        var i = 0
        while (i < s.length) {
            var l = i
            var r = i
            while (i < s.length && s[l] == s[i]) {
                r = i++
            }

            while (l >= 0 && r < s.length) {
                if (s[l] == s[r]) {
                    val candidate = s.substring(l, r + 1)
                    if (result.length < candidate.length) {
                        result = candidate
                    }
                    l--
                    r++
                } else {
                    break
                }
            }
        }

        return result
    }
}

fun main() {
    println(LongestPalindromicSubstring().longestPalindrome("a"))
    println(LongestPalindromicSubstring().longestPalindrome("babad"))
    println(LongestPalindromicSubstring().longestPalindrome("bb"))
    println(LongestPalindromicSubstring().longestPalindrome("ccc"))
    println(LongestPalindromicSubstring().longestPalindrome("cbbd"))
}