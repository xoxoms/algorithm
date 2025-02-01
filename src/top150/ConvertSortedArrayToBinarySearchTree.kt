package top150

import TreeNode

/**
 * 108. Convert Sorted Array to Binary Search Tree !!
 * easy로 되어있으나 해결하지 못함.
 * ===============================
 * 재귀 함수에 0과 마지막 인덱스를 넣어 호출
 * (l + r) / 2로 중간값의 인덱스를 구함
 * 중간값의 left가 될 값은, 중간값보다 작아야하므로 m - 1을 r에 넣어 재귀 호출
 * 중간값의 right가 될 값은, 중간값보다 커야하므로 m + 1을 l에 넣어 재귀 호출
 * l > r이 되면 유일한 null케이스로 방어해줌.
 * 최대 r은 마지막 인덱스와 같기 때문에 별다른 조치 필요없음.
 */
class ConvertSortedArrayToBinarySearchTree {

    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return recursive(nums, 0, nums.size - 1)
    }

    private fun recursive(nums: IntArray, l: Int, r: Int): TreeNode? {
        if (l > r) {
            return null
        }

        val m = (l + r) / 2
        val mid = TreeNode(nums[m])
        mid.left = recursive(nums, l, m - 1)
        mid.right = recursive(nums, m + 1, r)

        return mid
    }
}

fun main() {
    println(
        ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9))
    )
}