class LongestRepeatingSubstring {

    fun test(s: String): Int {
        var max = 0
        for (i in 0 .. s.length - 2) {
            for (j in s.length - 1 downTo i) {
                val text = s.substring(i, j + 1)
                if (s.drop(i + 1).contains(text)) {
                    max = maxOf(max, text.length)
                    break
                }
            }
        }

        return max
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(LongestRepeatingSubstring().test("aba"))
            println(LongestRepeatingSubstring().test("aaaaa"))
            println(LongestRepeatingSubstring().test("abcd"))
            println(LongestRepeatingSubstring().test("abbaba"))
            println(LongestRepeatingSubstring().test("aabcaabdaab"))
        }
    }
}