class WordBreak {

    private val memoization = mutableSetOf<String>()
    private val memoization2 = mutableMapOf<String, Boolean>()

    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        if (s.isEmpty()) return true
        if (memoization2.contains(s)) return memoization2[s]!!

        wordDict
            .forEach {
                memoization2[s] = s.startsWith(it)
                if (memoization2[s]!!) {
                    val result = wordBreak(s.drop(it.length), wordDict)
                    if (result) {
                        return true
                    }
                }
            }

        return false
    }

    fun wordBreak2(s: String, wordDict: List<String>): Boolean {
        if (s.isEmpty()) return true
        if (memoization.contains(s)) return false

        wordDict
            .forEach {
                if (s.startsWith(it)) return@forEach
                val afterDrop = s.drop(it.length)
                val result = if (afterDrop.isEmpty()) {
                    true
                } else {
                    wordBreak(afterDrop, wordDict)
                }

                if (result) { return true }
                else {
                    memoization.add(s)
                }
            }

        return false
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(WordBreak().wordBreak("aaaaaaa", listOf("aaaa", "aa")))
            println(WordBreak().wordBreak("catskicatcats", listOf("cats","cat","dog","ski")))
            println(WordBreak().wordBreak("abcd", listOf("a","abc","b","cd")))
            println(WordBreak().wordBreak("leetcode", listOf("leet", "code")))
            println(WordBreak().wordBreak("catsandog", listOf("cats", "dog", "sand", "and", "cat")))
        }
    }
}