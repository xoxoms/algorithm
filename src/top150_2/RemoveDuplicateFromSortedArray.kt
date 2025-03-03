package top150_2

/**
 * 26. Remove Duplicates from Sorted Array
 * 이전 값을 기록한다.
 * 현재 값이 이전 값과 같다면 count++한다.
 * 현재 값이 이전 값과 다르면, nums[i - count]에 값을 넣어준다.
 */
class RemoveDuplicateFromSortedArray {

    fun removeDuplicates(nums: IntArray): Int {
        var prev = nums[0]
        var count = 0
        for (i in 1..<nums.size) {
            if (prev == nums[i]) {
                count++
            } else {
                nums[i - count] = nums[i]
                prev = nums[i]
            }
        }

        return nums.size - count
    }
}