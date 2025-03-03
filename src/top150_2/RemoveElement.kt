package top150_2

/**
 * 27. Remove Element
 * `val`과 같은 값이 나오면 count++한다.
 * 다른 값이 나오면 해당 값을 i - count로 이관한다.
 */
class RemoveElement {

    fun removeElement(nums: IntArray, `val`: Int): Int {
        var count = 0
        for (i in 0..< nums.size) {
            if (nums[i] != `val`) {
                nums[i - count] = nums[i]
            } else {
                count++
            }
        }

        return nums.size - count
    }
}