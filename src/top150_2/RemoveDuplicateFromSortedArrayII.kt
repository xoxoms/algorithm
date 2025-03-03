package top150_2

/**
 * 80. Remove Duplicates from Sorted Array II !!
 * 좋은 해법이 아니다.
 * nums[i - count - 2] 값과 nums[i] 값이 같다면 count++한다.
 * 아니라면, nums[i] 값을 nums[i - count]에 넣어준다.
 */
class RemoveDuplicateFromSortedArrayII {

    fun removeDuplicates(nums: IntArray): Int {
        var count = 0
        for (i in 2 ..< nums.size) {
            if (nums[i - count - 2] == nums[i]) {
                count++
            } else {
                nums[i - count] = nums[i]
            }
        }

        return nums.size - count
    }
}