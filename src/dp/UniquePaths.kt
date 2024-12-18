package dp

class UniquePaths {

    fun uniquePaths(m: Int, n: Int): Int {
        if (m == 1 || n == 1) {
            return 1
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1)
    }

    fun test2(m: Int, n: Int): Int {
        val result = mutableListOf<Pair<Int, Int>>()
        dp(Pair(m - 1, n - 1), Pair(0, 0), result)
        return result.size
    }

    private fun dp(goal: Pair<Int, Int>, current: Pair<Int, Int>, result: MutableList<Pair<Int, Int>>) {
        if (goal == current) {
            result.add(current)
            return
        }

        if (current.first < goal.first) {
            dp(goal, Pair(current.first + 1, current.second), result)
        }

        if (current.second < goal.second) {
            dp(goal, Pair(current.first, current.second + 1), result)
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(UniquePaths().uniquePaths(3, 7))
        }
    }
}