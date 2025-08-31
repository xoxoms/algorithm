package top150_2

/**
 * 97. Interleaving String
 * 45m
 * dp문제인데, 재귀로 풀었다.................
 * =======================
 * s1, s2, s3 문자열과 각 포인터를 전달받는 재귀 함수를 작성한다.
 * hit시 카운터를 하나씩 올려가며 최종 마지막 문자에 도달하는지 확인한다.
 */
class InterleavingString {

    private val visited = mutableSetOf<Triple<Int, Int, Int>>()
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        if (s3.length < s1.length + s2.length) {
            return false
        }

        return recursive(s1, s2, s3, 0, 0, 0)
    }

    private fun recursive(s1: String, s2: String, s3: String, target: Int, i1: Int, i2: Int): Boolean {
        if (visited.contains(Triple(target, i1, i2))) {
            return false
        }

        visited.add(Triple(target, i1, i2))

        if (s1.length == i1 && s2.length == i2 && target == s3.length) {
            return true
        }

        if (i1 < s1.length && s1[i1] == s3[target]) {
            if (recursive(s1, s2, s3, target + 1, i1 + 1, i2)) {
                return true
            }
        }

        if (i2 < s2.length && s2[i2] == s3[target]) {
            if (recursive(s1, s2, s3, target + 1, i1, i2 + 1)) {
                return true
            }
        }

        return false
    }
}

fun main() {
    println(InterleavingString().isInterleave("aabcc", "dbbca", "aadbbcbcac"))
    println(InterleavingString().isInterleave("aabcc", "dbbca", "aadbbbaccc"))
}