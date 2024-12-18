class ReturnNoTwice {

    fun test(nums: IntArray): Int {
        if (nums.size <= 2) { return nums[0] }

        var size = nums.size
        var start = 0
        var end = size - 1
        var mid = 0

        while (size > 2) {
            mid = start + (size / 2)
            if (size == 3) {
                return if (nums[mid] == nums[mid - 1]) {
                    nums[mid + 1]
                } else {
                    nums[mid - 1]
                }
            }

            if (nums[mid] == nums[mid - 1]) {
                if (mid % 2 == 0) {
                    end = mid
                } else {
                    start = mid + 1
                }
            } else {
                if (mid % 2 == 0) {
                    start = mid
                } else {
                    end = mid - 1
                }
            }

            size = end - start + 1
        }

        return 0
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ReturnNoTwice().test(intArrayOf(0,0,1,1,2,2,3,3,4,4,10))
            ReturnNoTwice().test(intArrayOf(3,3,7,7,10,11,11))
            ReturnNoTwice().test(intArrayOf(1,1,2,3,3,4,4,8,8))
        }
    }
}