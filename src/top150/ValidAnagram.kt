package top150

/**
 * 242. Valid Anagram
 */
class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        if (s == t) return true

        val map = mutableMapOf<Char, Int>()
        for (i in 0 until s.length) {
            map[s[i]] = (map[s[i]] ?: 0) + 1
            map[t[i]] = (map[t[i]] ?: 0) - 1
        }

        return map.values.all { it == 0 }
    }
}

fun main() {
    println(ValidAnagram().isAnagram("rat", "cat"))
}