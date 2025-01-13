package top150

/**
 * 383. Ransom Note
 */
class RansomNote {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        if (magazine.contains(ransomNote)) {
            return true
        }

        val map = mutableMapOf<Char, Int>()
        ransomNote.forEach {
            map[it] = (map[it] ?: 0) + 1
        }

        magazine.forEach {
            if (map.contains(it)) {
                map[it] = map[it]!! - 1
            }
        }

        return map.values.all { it <= 0 }
    }
}

fun main() {
    println(RansomNote().canConstruct("fffbfg", "effjfggbffjdgbjjhhdegh"))
    println(RansomNote().canConstruct("aab", "baa"))
    println(RansomNote().canConstruct("a", "b"))
}