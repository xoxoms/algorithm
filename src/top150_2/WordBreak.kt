package top150_2

/**
 * 139. Word Break !!
 * 15m
 * 금방 풀었지만 복기하면좋을듯해서 북마크해둔다.
 * =================
 * 이미 확인한 문자열은 재처리하지 않아도되므로 방문처리한다.
 * 전달된 인자가 딕셔너리 특정 값으로 시작하면 문자열을 자르고 재귀처리한다.
 * 빈값이되면 true를 리턴한다.
 */
class WordBreak {

    private val visited = mutableSetOf<String>()
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        return if (visited.contains(s)) {
            false
        } else {
            visited.add(s)
            wordDict.any { word ->
                if (s.isEmpty()) {
                    return true
                }

                if (s.startsWith(word)) {
                    wordBreak(s.substring(word.length), wordDict)
                } else {
                    false
                }
            }
        }
    }
}

fun main() {
    println(WordBreak().wordBreak("applepenapple", listOf("apple", "pen")))
}