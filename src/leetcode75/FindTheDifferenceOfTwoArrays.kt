package leetcode75

/**
 * 2215. Find the Difference of Two Arrays
 * set으로 있는거없는거 체크한다.
 */
class FindTheDifferenceOfTwoArrays {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val target1 = nums1.toSet()
        val target2 = nums2.toSet()

        val result1 = mutableSetOf<Int>()
        val result2 = mutableSetOf<Int>()

        for (i in 0 ..< nums1.size) {
            if (!target2.contains(nums1[i])) {
                result1.add(nums1[i])
            }
        }

        for (i in 0 ..< nums2.size) {
            if (!target1.contains(nums2[i])) {
                result2.add(nums2[i])
            }
        }

        return listOf(
            result1.toList(),
            result2.toList()
        )
    }
}

fun main() {
    println(FindTheDifferenceOfTwoArrays().findDifference(intArrayOf(1,2,3), intArrayOf(3,4,5)))
}