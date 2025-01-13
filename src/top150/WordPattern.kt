package top150

/**
 * 290. Word Pattern
 */
class WordPattern {
    fun wordPattern(pattern: String, s: String): Boolean {
        val map = mutableMapOf<Char, String>()
        val map2 = mutableMapOf<String, Char>()
        val split = s.split(" ")
        if (split.size != pattern.length) { return false }

        for (i in 0 .. pattern.length - 1) {
            if (map[pattern[i]] == null) {
                map[pattern[i]] = split[i]
            } else if (map[pattern[i]] != split[i]) {
                return false
            }

            if (map2[split[i]] == null) {
                map2[split[i]] = pattern[i]
            } else if (map2[split[i]] != pattern[i]) {
                return false
            }
        }

        return true
    }
}

fun main() {
    println(WordPattern().wordPattern("abba", "dog cat cat dog"))
}