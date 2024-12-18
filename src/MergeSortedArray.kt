class MergeSortedArray {

    fun test(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        if (n == 0) return
        if (m == 0) {
            for (i in nums2.indices) { nums1[i] = nums2[i] }
            return
        }

        var i = m - 1
        var j = n - 1
        var k = nums1.size - 1
        do {
            if (j < 0 || (i >= 0 && (nums1[i] > nums2[j]))) {
                nums1[k--] = nums1[i--]
            } else {
                nums1[k--] = nums2[j--]
            }
        } while (k >= 0)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            MergeSortedArray().test(
                intArrayOf(2,0),
                1,
                intArrayOf(1),
                1
            )
            MergeSortedArray().test(
                intArrayOf(1,2,3,0,0,0),
                3,
                intArrayOf(2,5,6),
                3
            )
        }
    }
}