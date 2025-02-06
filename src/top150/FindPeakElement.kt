package top150

/**
 * 162. Find Peak Element
 */
class FindPeakElement {
    fun findPeakElement(nums: IntArray): Int {
        if (nums.size == 1) { return 0 }
        if (nums[nums.size - 1] > nums[nums.size - 2]) { return nums.size - 1 }

        var i = 1
        while (i < nums.size - 1) {
            if (nums[i-1] < nums[i] && nums[i] > nums[i+1]) { return i }
            i++
        }

        return 0
    }
}

fun main() {
    println(
        FindPeakElement().findPeakElement(
            intArrayOf(1,2,3,1)
//            intArrayOf(2,1)
        )
    )
}