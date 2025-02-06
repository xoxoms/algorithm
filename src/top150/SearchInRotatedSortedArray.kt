package top150

/**
 * 33. Search in Rotated Sorted Array
 * 피벗된 위치를 찾는다.
 * 이진탐색으로 target index를 찾아 반환한다.
 */
class SearchInRotatedSortedArray {
    fun search(nums: IntArray, target: Int): Int {
        var i = 0
        while (i < nums.size - 1) {
            if (nums[i] > nums[i + 1]) {
                break
            }

            i++
        }

        return if (nums[0] > target) {
            search(nums, i + 1, nums.size - 1, target)
        } else {
            search(nums, 0, i, target)
        }
    }

    private fun search(nums: IntArray, left: Int, right: Int, target: Int): Int {
        val mid = (left + right) / 2

        return if (nums[mid] == target) {
            mid
        } else if (left >= right)  {
            -1
        } else if (nums[mid] > target) {
            search(nums, left, mid, target)
        } else {
            search(nums, mid + 1, right, target)
        }
    }
}

fun main() {
    println(
        SearchInRotatedSortedArray().search(
            intArrayOf(4,5,6,7,0,1,2),
            5,
        )
    )
}