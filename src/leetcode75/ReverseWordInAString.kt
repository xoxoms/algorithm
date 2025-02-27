package leetcode75

import java.util.*

/**
 * 151. Reverse Words in a String
 * 시간,공간복잡도 줄여서 처리해보려고 아래처럼 구현했으나 beats값이 100%는 아니었다.
 */
class ReverseWordInAString {

    fun reverseWords(s: String): String {
        val sj = StringJoiner(" ")
        var last = s.length
        for (i in s.length - 2 downTo 0) {
            if (s[i] == ' ' && s[i + 1] != ' ') {
                sj.add(s.slice(i + 1 .. last - 1).trim())
                last = i
            }
        }

        sj.add(s.slice(0 .. last - 1).trim())

        return sj.toString().trim()
    }
}

fun main() {
    ReverseWordInAString().reverseWords("the sky is blue")
}