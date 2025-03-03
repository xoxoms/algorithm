package top150_2

/**
 * 88. Merge Sorted Array
 * i,j,p 세 변수를 두고, i와 j의 값을 비교 후 p--에 넣어준다.
 */
class MergeSortedArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = m - 1
        var j = n - 1
        var p = nums1.size - 1

        while (p >= 0) {
            if (i == - 1) {
                nums1[p--] = nums2[j--]
            } else if (j == -1) {
                nums1[p--] = nums1[i--]
            } else {
                if (nums1[i] < nums2[j]) {
                    nums1[p--] = nums2[j--]
                } else {
                    nums1[p--] = nums1[i--]
                }
            }
        }
    }
}