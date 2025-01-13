package top150

/**
 * 1. Two Sum
 */
class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for (i in nums.indices) { map[nums[i]] = i }
        for (i in nums.indices) {
            if (map.containsKey(target - nums[i]) && i != map[target - nums[i]]) {
                return intArrayOf(i, map[target - nums[i]]!!)
            }
        }

        return intArrayOf()
    }
}

fun main() {
    TwoSum().twoSum(intArrayOf(2,7,11,15), 9).forEach { print("$it ") }
    println()
}