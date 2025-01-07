package top150

/**
 * 14. Longest Common Prefix
 */
class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        var result = ""
        for (i in strs[0].indices) {
            val start = result + strs[0][i]
            if (strs.all { it.startsWith(start) }) {
                result = start
            } else {
                return result
            }
        }

        return result
    }
}

fun main() {
    println(LongestCommonPrefix().longestCommonPrefix(arrayOf("a")))
    println(LongestCommonPrefix().longestCommonPrefix(arrayOf("flower", "flow", "flight")))
}