package top150

import TreeNode

/**
 * 112. Path Sum
 */
class PathSum {

    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false
        return dfs(root, targetSum, root.`val`)
    }

    private fun dfs(node: TreeNode, targetSum: Int, currentSum: Int): Boolean {
        if (node.left == null && node.right == null) {
            return currentSum == targetSum
        }

        val leftResult = node.left?.let { dfs(it, targetSum, currentSum + it.`val`) }
        if (leftResult == true) { return true }

        val rightResult = node.right?.let { dfs(it, targetSum, currentSum + it.`val`) }
        if (rightResult == true) { return true }

        return false
    }
}

fun main() {
    println(PathSum().hasPathSum(TreeNode.make(5,4,8,11,null,13,4,7,2,null,null,null,1), 22))
}