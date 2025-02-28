package leetcode75

import TreeNode
import kotlin.math.max

/**
 * 104. Maximum Depth of Binary Tree
 */
class MaximumDepthOfBinaryTree {

    fun maxDepth(root: TreeNode?, depth: Int = 1): Int {
        if (root == null) { return 0 }
        var max = depth

        root.left?.let {
            max = max(maxDepth(it, depth + 1), max)
        }

        root.right?.let {
            max = max(maxDepth(it, depth + 1), max)
        }

        return max
    }
}

fun main() {
    MaximumDepthOfBinaryTree().maxDepth(TreeNode.make_3_9_20_15_7())
}