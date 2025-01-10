package top150

/**
 * 392. Is Subsequence
 */
class IsSubsequence {

    fun isSubsequence(s: String, t: String): Boolean {
        if (t.length < s.length) { return false }
        if (s.length == 0) { return true }

        var i = 0
        var j = 0
        while (true) {
            if (j == t.length) { return false }
            if (s[i] == t[j]) {
                i++
                j++
                if (i == s.length) { return true }
            } else {
                j++
            }
        }
    }
}

fun main() {
    println(IsSubsequence().isSubsequence("abc", "ahbgdc"))
}