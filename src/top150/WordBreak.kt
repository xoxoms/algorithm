package top150

/**
 * 139. Word Break
 * wordDict를 순회하면서 전달된 값을 지워나간다.
 * 빈 스트링이되면 true를 리턴한다.
 */
class WordBreak {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        if (s == "") {
            return true
        }

        if (visited.contains(s)) {
            return false
        } else {
            visited.add(s)
        }

        for (word  in wordDict) {
            if (s.startsWith(word) && wordBreak(s.substring(word.length), wordDict)) {
                return true
            }
        }

        return false
    }

    private val visited = mutableSetOf<String>()
}

fun main() {
    println(WordBreak().wordBreak("leetcode", arrayListOf("leet", "code")))
}