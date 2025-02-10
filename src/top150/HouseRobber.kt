package top150

import kotlin.math.max

/**
 * 198. House Robber
 * nums[i] = nums[i - 2] + nums[i] > nums[i - 1]로 i번 순회한다.
 * 마지막 값을 응답한다.
 */
class HouseRobber {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) { return nums[0] }
        if (nums.size == 2) { return max(nums[0], nums[1]) }

        for (i in 1 ..< nums.size) {
            val prev = if (i < 2) {
                0
            } else {
                nums[i - 2]
            }

            nums[i] = max(nums[i] + prev, nums[i - 1])
        }

        return nums[nums.size - 1]
    }
}

fun main() {
    println(HouseRobber().rob(intArrayOf(1, 2, 3, 1)))
    println(HouseRobber().rob(intArrayOf(2,1,1,2)))
}