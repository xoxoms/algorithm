package dp2

/**
 * 139. Word Break
 * 1h
 * 왜풀이시간이 4배나 늘었는가!?
 * dp를 어떻게해야할지 고민하는데 시간을 썼다.
 * 좀더 익숙해져야할듯
 * ===============
 * dp 테이블에 문자열을 넣어두고 해당 문자열이 true/false인지 확인하도록 한다.
 */
class WordBreak {
    private val dp = mutableMapOf<String, Boolean>()

    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        dp[""] = true
        recursive(s, wordDict)
        return dp[s]!!
    }

    private fun recursive(s: String, wordDict: List<String>) {
        if (dp[s] != null) {
            return
        }

        for (word in wordDict) {
            if (s.startsWith(word)) {
                val substring = s.substring(word.length)
                recursive(substring, wordDict)
                if (dp[substring] == true) {
                    dp[s] = dp[substring]!!
                    return
                }
            }
        }

        dp[s] = false
    }
}

fun main() {
    println(WordBreak().wordBreak("abcd", listOf("a","abc","b","cd")))
//    println(WordBreak().wordBreak("leetcode", listOf("leet", "code")))
}