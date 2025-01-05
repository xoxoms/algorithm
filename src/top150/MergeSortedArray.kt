package top150

/**
 * 88. Merge Sorted Array
 * 2포인터로 해결. O(M+N). 1h
 * 두 배열의 맨뒤부터 루핑한다.
 * 현재 포인터 원소를 비교한다.
 * 뒤쪽이 크면 뒤쪽 값을 current 값에 넣는다.
 * 앞쪽이 크면 앞쪽 값을 current 값에 넣는다.
 */
class MergeSortedArray {

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = m - 1
        var j = n - 1

        var current = nums1.size - 1
        while (current >= 0) {
            val n1 = if (i < 0) { Int.MIN_VALUE } else { nums1[i] }
            val n2 = if (j < 0) { Int.MIN_VALUE } else { nums2[j] }

            if (n1 > n2) {
                nums1[current--] = n1
                i--
            } else {
                nums1[current--] = n2
                j--
            }
        }
    }
}

fun main() {
//    val nums1 = intArrayOf(4, 5, 6, 0, 0, 0)
//    MergeSortedArray().merge(
//        nums1 = nums1,
//        m = 3,
//        nums2 = intArrayOf(1, 2, 3),
//        n = 3
//    )
//
//    val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
//    MergeSortedArray().merge(
//        nums1 = nums1,
//        m = 3,
//        nums2 = intArrayOf(2, 5, 6),
//        n = 3
//    )

    val nums1 = intArrayOf(0)
    MergeSortedArray().merge(
        nums1 = nums1,
        m = 0,
        nums2 = intArrayOf(1),
        n = 1
    )

    for (i in nums1) {
        print("$i ")
    }
}