package top150_2

/**
 * 58. Length of Last Word
 * 오랜만에 알고리즘해서인지 헤맸다.
 */
class LengthOfLastWord {

    fun lengthOfLastWord(s: String): Int {
        var result = 0

        for (i in s.length - 1 downTo 0) {
            if (s[i] == ' ' && result > 0) {
                return result
            } else if (s[i] != ' ') {
                result++
            }
        }

        return result
    }
}

fun main() {
    println(LengthOfLastWord().lengthOfLastWord("   fly me   to   the moon  "))
}