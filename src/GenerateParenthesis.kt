class GenerateParenthesis {

    fun test(n: Int): List<String> {
        val result = mutableListOf<String>()

        fun dfs(left: Int, right: Int, path: String) {
            // (((())))
            // ((()()))
            // ((()))()
            // ((()
            // ((()))()
            // (())(())
            if (right == n) {
                result.add(path)
                return
            }

            if (left < n) {
                dfs(left + 1, right, "$path(")
            }

            if (right < left) {
                dfs(left, right + 1, "$path)")
            }
        }

        dfs(0, 0, "")
        return result
    }

    fun generateParenthesis(n: Int): List<String> {
        return calc(n*2)
            .filter {
                var count = 0
                for (c in it) {
                    if (c == '(') {
                        count++
                    } else {
                        count--
                    }

                    if (count < 0 || count > n) {
                        return@filter false
                    }
                }

                count == 0
            }
    }

    private fun calc(n: Int): Set<String> {
        if (n == 0) { return setOf("") }
        val result = mutableSetOf<String>()
        calc(n - 1).forEach {
            result.add("$it(")
            result.add("$it)")
            result.add("($it")
            result.add(")$it")
        }
        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(GenerateParenthesis().test(4))
        }
    }
}