package top150_2

/**
 * 242. Valid Anagram
 * 해법의 연산 속도가 빠르진 않다.
 */
class ValidAnagram {

    fun isAnagram(s: String, t: String): Boolean {
        val visited = mutableMapOf<Char, Int>()
        s.forEach {
            visited.computeIfAbsent(it) { 0 }
            visited[it] = visited[it]!! + 1
        }

        t.forEach {
            if (!visited.contains(it)) { return false }
            visited[it] = visited[it]!! - 1
        }

        return visited
            .values
            .all { it == 0 }
    }
}