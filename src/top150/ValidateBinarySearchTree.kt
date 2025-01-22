package top150

import TreeNode

/**
 * 98. Validate Binary Search Tree !!
 * 현재 노드의 값이 좌/우측의 값보다 작거나 크면 false를 응답하고,
 * 상위 값보다도 작거나 커선안되므로 boundary 값들을 릴레이해서 체크해야한다.
 * 간단한 문제같은데 생각을 넓게하지못해 오래걸림.
 */
class ValidateBinarySearchTree {
    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) return true
        return recursive(root, Int.MIN_VALUE - 1L, Int.MAX_VALUE + 1L)
    }

    private fun recursive(node: TreeNode, leftBoundary: Long, rightBoundary: Long): Boolean {
        if (leftBoundary < node.`val` && node.`val` < rightBoundary) {
            node.left?.let {
                if (!recursive(it, leftBoundary, node.`val`.toLong())) {
                    return false
                }
            }

            node.right?.let {
                if (!recursive(it, node.`val`.toLong(), rightBoundary)) {
                    return false
                }
            }

            return true
        } else {
            return false
        }
    }
}

fun main() {
    println(ValidateBinarySearchTree().isValidBST(TreeNode.make(2, 1, 3)))
    println(ValidateBinarySearchTree().isValidBST(TreeNode.make(5,4,6,null,null,3,7)))
    val root = TreeNode(45)
    val node1 = TreeNode(42)
    val node2 = TreeNode(44)
    val node3 = TreeNode(43)
    val node4 = TreeNode(41)
    root.left = node1
    node1.right = node2
    node2.left = node3
    node3.left = node4

    println(ValidateBinarySearchTree().isValidBST(root))
}