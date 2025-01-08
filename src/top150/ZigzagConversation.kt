package top150

/**
 * 6. Zigzag Conversion
 */
class ZigzagConversation {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) { return s }

        val map = mutableMapOf<Int, String>()
        var current = 0
        var flag = 1
        for (i in 0 .. numRows) {
            map[i] = ""
        }

        for (char in s) {
            map[current] = map[current]!! + char
            val next = current + flag
            if (next == numRows) {
                flag = -1
            } else if (next == -1) {
                flag = 1
            }
            current += flag
        }

        return map
            .values
            .joinToString("")
    }
}

fun main() {
    println(ZigzagConversation().convert("AB", 1))
    println(ZigzagConversation().convert("PAYPALISHIRING", 3))
}