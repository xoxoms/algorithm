package top150

/**
 * 39. Combination Sum
 * 1h 35m
 */
class CombinationsSum {
    private val result = mutableListOf<MutableList<Int>>()

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        dp(0, 0, target, candidates, mutableListOf())
        return result
    }

    private fun dp(idx: Int, sum: Int, target: Int, nums: IntArray, prev: MutableList<Int>) {
        if (sum > target) { return }

        for (i in idx..< nums.size) {
            val num = nums[i]
            if (sum == target) {
                val l = mutableListOf<Int>()
                prev.forEach { l.add(it) }
                result.add(l)
                return
            } else {
                prev.add(num)
                dp(i, sum + num, target, nums, prev)
                prev.removeLast()
            }
        }
    }
}

fun main() {
    println(CombinationsSum().combinationSum(intArrayOf(2,3,6,7), 7))
}