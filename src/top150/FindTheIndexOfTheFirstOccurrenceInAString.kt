package top150

/**
 * 28. Find the Index of the First Occurrence in a String
 */
class FindTheIndexOfTheFirstOccurrenceInAString {
    fun strStr(haystack: String, needle: String): Int {
        if (haystack == needle) { return 0 }
        if (haystack.length < needle.length) { return -1 }

        for (i in 0..<haystack.length - needle.length + 1) {
            var result = true
            for (j in needle.indices) {
                if (haystack[i + j] != needle[j]) {
                    result = false
                    break
                }
            }
            if (result) {
                return i
            }
        }

        return -1
    }
}

fun main() {
    println(FindTheIndexOfTheFirstOccurrenceInAString().strStr("abc", "c"))
    println(FindTheIndexOfTheFirstOccurrenceInAString().strStr("leetcode", "leeto"))
    println(FindTheIndexOfTheFirstOccurrenceInAString().strStr("llleetocode", "leeto"))
}