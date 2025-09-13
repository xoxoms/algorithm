package dp2

/**
 * 5. Longest Palindromic Substring
 * 40m
 * n^2 dp로 풀수있다는데 dp로 풀진못햇네.
 * ================================
 * 문자열을 순회하면서 이중 포문을 돌린다.
 * 현재 위치를 기준으로 left, right커서를 두고 해당 방향으로 증감한다.
 * 이동 후 값이 같다면 회문이므로 반복, 값이 다르면 중단한다.
 * cbbc 처럼 기준값이 바로 다음에 나올수 있으므로 bb처리를 위해 한번더체크해야한다.
 * 이렇게 회문이 특정되면 결과를 업데이트한다.
 *
 */
class LongestPalindromicSubstring {

    fun longestPalindrome(s: String): String {
        var result = ""
        if (s.isEmpty()) { return result }

        for (i in 0 ..< s.length) {
            var l = i
            for (r in l .. l + 1) {
                var j = 0
                while (true) {
                    val left = l - j
                    val right = r + j
                    if (left < 0 || right >= s.length) {
                        break
                    }

                    if (s[left] != s[right]) {
                        break
                    }

                    if (result.length < right - left + 1) {
                        result = s.substring(left, right + 1)
                    }
                    j++
                }
            }
        }

        return result
    }
}

fun main() {
    println(LongestPalindromicSubstring().longestPalindrome("cbbd"))
    println(LongestPalindromicSubstring().longestPalindrome("babad"))
}