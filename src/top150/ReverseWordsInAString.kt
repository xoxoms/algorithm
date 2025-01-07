package top150

import java.util.*

/**
 * 151. Reverse Words in a String
 */
class ReverseWordsInAString {

    fun reverseWords(s: String): String {
        val result = StringJoiner(" ")
        val trim = s.trim()

        var current = ""
        for (i in trim.length - 1 downTo 0) {
            if (trim[i] != ' ') {
                current = trim[i] + current
            } else if (current.isNotEmpty()) {
                result.add(current)
                current = ""
            }
        }

        result.add(current)

        return result.toString()
    }
}

fun main() {
    println(ReverseWordsInAString().reverseWords("  hello world  "))
    println(ReverseWordsInAString().reverseWords("a good    example  "))
}