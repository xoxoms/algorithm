package dp

import kotlin.math.min

class Jump {

    private val memo = mutableMapOf<Int, Int>()
    fun jump(nums: IntArray, crr: Int = 0, total: Int = 0): Int {
        if (crr >= nums.size - 1) { return total }
        if (memo[crr] != null) { return memo[crr]!! + total }

        val distance = nums[crr]
        val answers = mutableListOf<Int>()
        for (i in 1..distance) {
            answers.add(jump(nums, crr + i, total + 1))
        }

        val ans = if (answers.isEmpty()) Int.MAX_VALUE else answers.min()
        memo[crr] = ans - total
        return ans
    }

    fun test2(nums: IntArray): Int {
        val memoization = mutableMapOf<Int, Int>()
        memoization[nums.size - 1] = 0

        for (i in nums.size - 2 downTo 0) {
            memoization[i] = (if (i + nums[i] >= nums.size - 1) {
                1
            } else {
                val end = i + nums[i]
                var min = nums.size

                for (j in i + 1 .. end) {
                    val a = memoization[j]!!
                    min = min(a, min)
                }

                min + 1
            })
        }

        return memoization[0]!!
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Jump().jump(intArrayOf(2,3,1,1,4)))
        }
    }
}