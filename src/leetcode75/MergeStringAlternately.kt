package leetcode75

/**
 * 1768. Merge Strings Alternately
 */
class MergeStringAlternately {
    fun mergeAlternately(word1: String, word2: String): String {
        val sb = StringBuilder()
        var i = 0
        var j = 0
        while (i < word1.length && j < word2.length) {
            sb.append(word1[i++])
            sb.append(word2[j++])
        }

        while (i < word1.length) {
            sb.append(word1[i++])
        }


        while (j < word2.length) {
            sb.append(word2[j++])
        }

        return sb.toString()
    }
}

fun main() {
    println(MergeStringAlternately().mergeAlternately("abc", "pqr"))
    println(MergeStringAlternately().mergeAlternately("ab", "pqrs"))
}