package leetcode75

/**
 * 215. Kth Largest Element in an Array !!
 *
 * n번째 큰 값을 구하는 류의 문제에서는 퀵서치를 사용한다.
 * 복습필요 !!
 * 배열의 마지막 요소를 pivot으로 둔다.
 * pointer와 i로 pivot 전까지 순회한다.
 * pivot 값과 작거나 같으면, pointer++위치에 값과 i값을 스왑한다.
 * 루핑이 끝나면 pivot과 pointer위치를 바꾼다.
 * pointer의 좌측에는 pivot보다 작거나 같은 값들이 나열되고
 * pointer의 우측에는 pivot보다 큰 값들이 나열된다.
 * 각 케이스에 맞게 재귀호출한다.
 */
class KthLargestElementInAnArray {

    fun findKthLargest(nums: IntArray, k: Int): Int {
        return quickSelect(nums, k, 0, nums.size - 1)
    }

    private fun quickSelect(nums: IntArray, k: Int, l: Int, r: Int): Int {
        val pivot = nums[r]
        var p = l

        for (i in l ..< r) {
            if (nums[i] <= pivot) {
                val temp = nums[i]
                nums[i] = nums[p]
                nums[p] = temp
                p++
            }
        }

        val temp = nums[r]
        nums[r] = nums[p]
        nums[p] = temp

        val kk = nums.size - k
        return if (kk > p) {
            quickSelect(nums, k, p + 1, r)
        } else if (kk < p) {
            quickSelect(nums, k, l, p - 1)
        } else {
            nums[p]
        }
    }
}

fun main() {
    println(KthLargestElementInAnArray().findKthLargest(intArrayOf(3,2,1,5,6,4), 2))
    println(KthLargestElementInAnArray().findKthLargest(intArrayOf(3,2,3,1,2,4,5,5,6), 4))
}