package dp

import kotlin.math.min

class Jump1 {

    private val memo = mutableMapOf<Int, Boolean>()
    fun jump(nums: IntArray): Boolean {
        return dp(nums, 0)
    }
    private fun dp(nums: IntArray, idx: Int): Boolean {
        if (idx == nums.size - 1) {
            return true
        }
        if (nums[idx] == 0) {
            return false
        }
        if (memo[idx] != null) {
            return memo[idx]!!
        }

        val endExclusive = min(idx + nums[idx], nums.size - 1)
        for (i in idx + 1.. endExclusive) {
            val result = dp(nums, i)
            memo[i] = result
            if (result) { return true }
        }

        return false
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Jump1().jump(intArrayOf(1)))
            println(Jump1().jump(intArrayOf(3,2,1,0,4)))
            println(Jump1().jump(intArrayOf(2,3,1,1,4)))
        }
    }
}