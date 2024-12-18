import kotlin.math.max

class LongestSubstring {

    fun test(s: String, k: Int): Int {
        if (k == 1) { return s.length }
        var max = 0
        for (i in s.indices) {
            var count = 1
            for (j in i until s.length) {
                if (s[i] != s[j]) {
                    count++
                    if (count > k) {
                        max = max(max, count)
                        break
                    }
                }
            }
        }

        return max
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(LongestSubstring().test("a", 0))
            println(LongestSubstring().test("eceba", 2))
            println(LongestSubstring().test("aa", 1))
        }
    }
}