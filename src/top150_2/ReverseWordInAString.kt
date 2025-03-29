package top150_2

/**
 * 151. Reverse Words in a String
 * 뒤에서부터 공백이 아닐때까지 sb에 append한다.
 * 알고리즘은 비교적 간단하지만..문자열을 다루는 문제다보니 끼워맞추느라 시간이 걸렸다.
 */
class ReverseWordInAString {

    fun reverseWords(s: String): String {
        val sb = StringBuilder()
        var i = s.length - 1

        var start = 0
        while (s[start] == ' ') {
            start++
        }

        while (i >= start) {
            if (s[i] == ' ') {
                i--
            } else {
                val end = i
                while (i >= start) {
                    if (s[i] == ' ') {
                        break
                    } else {
                        i--
                    }
                }
                sb.append(s.substring(i + 1, end + 1))
                if (i > start) {
                    sb.append(" ")
                }
            }
        }

        return sb.toString()
    }
}