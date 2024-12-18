package bfs

import TreeNode

/**
 * 112. Path Sum
 * 리프 노드까지 더한 값이 인자로 받은 targetSum과 같으면 탐색을 멈추고 응답한다.
  */
class PathSum {

    fun test(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false
        if (targetSum == root.`val` && root.left == null && root.right == null) { return true }
        return test(root.left, targetSum - root.`val`) || test(root.right, targetSum - root.`val`)
    }
}

fun main() {
    val a = TreeNode(1)
    a.left = TreeNode(2)
    a.right = TreeNode(2)

    println(PathSum().test(
        root = a,
        targetSum = 3,
    ))
}