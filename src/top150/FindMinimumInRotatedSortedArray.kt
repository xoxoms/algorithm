package top150

/**
 * 153. Find Minimum in Rotated Sorted Array
 * 좌측과 우측을 인자로 넣고
 * 중간값 > 우측값이라면 중간값 우측값으로 재시도
 * 중간값 < 우측값이라면 좌측값 중간값으로 재시도
 * 중간값이 가장 작을때 리턴한다.
 */
class FindMinimumInRotatedSortedArray {
    fun findMin(nums: IntArray): Int {
        return nums[find(nums, 0, nums.size - 1)]
    }

    private fun find(nums: IntArray, left: Int, right:Int): Int {
        val mid = (left + right) / 2
        return if (left >= right) {
            return left
        } else if (nums[mid] > nums[mid + 1]) {
            mid + 1
        } else if (nums[mid] > nums[right]) {
            find(nums, mid + 1, right)
        } else {
            find(nums, left, mid)
        }
    }
}

fun main() {
    println(FindMinimumInRotatedSortedArray().findMin(intArrayOf(11,13,15,17)))
    println(FindMinimumInRotatedSortedArray().findMin(intArrayOf(3,4,5,1,2)))
    println(FindMinimumInRotatedSortedArray().findMin(intArrayOf(2,1)))
}