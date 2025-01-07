package top150

/**
 * 58. Length of Last Word
 * 알파벳 나오면++, 카운트가 0보다 큰데 띄어쓰기면 리턴
 */
class LengthOfLastWord {
    fun lengthOfLastWord(s: String): Int {
        var count = 0
        for (i in s.length - 1 downTo 0) {
            if (s[i] == ' ') {
                if (count != 0) {
                    return count
                }
            } else {
                count++
            }
        }

        return count
    }
}

fun main() {
    println(LengthOfLastWord().lengthOfLastWord("luffy is still joyboy"))
    println(LengthOfLastWord().lengthOfLastWord("   fly me   to   the moon  "))
}