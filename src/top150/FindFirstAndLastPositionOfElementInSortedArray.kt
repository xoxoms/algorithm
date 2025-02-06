package top150

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * target을 찾는다.
 * 없다면 -1 리턴한다.
 * 이진탐색 right 사이드에서 target의 마지막 위치를 찾는다.
 */
class FindFirstAndLastPositionOfElementInSortedArray {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var i = 0
        while (true) {
            if (i == nums.size) { return intArrayOf(-1, -1) }
            if (nums[i] == target) {
                break
            }
            i++
        }

        return intArrayOf(i, find(nums, target, i, nums.size - 1))
    }

    private fun find(nums: IntArray, target: Int, left: Int, right: Int): Int {
        val mid = (left + right) / 2

        return if (nums[mid] == target) {
            if (mid + 1 == nums.size || nums[mid + 1] != target) {
                mid
            } else {
                find(nums, target, mid + 1, right)
            }
        } else {
            find(nums, target, left, mid)
        }
    }
}

fun main() {
    val result = FindFirstAndLastPositionOfElementInSortedArray().searchRange(
        intArrayOf(5, 7, 7, 8, 8, 10),
        8
    )

    result.forEach { print(it) }
    println()
}