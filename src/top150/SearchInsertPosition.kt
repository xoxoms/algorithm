package top150

/**
 * 35. Search Insert Position
 */
class SearchInsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {
        if (nums.last() < target) { return nums.size }
        var result = 0
        for (i in 0 ..< nums.size - 1) {
            if (target > nums[i]) {
                result = i + 1
            } else if (target == nums[i]) {
                return i
            }
        }

        return result
    }
}

fun main() {
    println(SearchInsertPosition().searchInsert(intArrayOf(1,3,5,6), 5))
    println(SearchInsertPosition().searchInsert(intArrayOf(1,3,5,6), 2))
}