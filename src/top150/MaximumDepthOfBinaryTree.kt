package top150

import TreeNode
import java.util.*
import kotlin.math.max

/**
 * 104. Maximum Depth of Binary Tree
 */
class MaximumDepthOfBinaryTree {

    /**
     * using dfs
     */
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0

        var result = 0
        if (root.left != null) {
            result = max(maxDepth(root.left), result)
        }
        if (root.right != null) {
            result = max(maxDepth(root.right), result)
        }

        return result + 1
    }

    /**
     * using bfs
     */
    fun maxDepthByQueue(root: TreeNode?): Int {
        val queue = LinkedList<TreeNode>()
        queue.add(root ?: return 0)

        var depth = 0
        while (queue.isNotEmpty()) {
            val polls = mutableListOf<TreeNode>()
            while (queue.isNotEmpty()) { polls.add(queue.poll()) }

            polls.forEach {
                it.left?.let { queue.add(it) }
                it.right?.let { queue.add(it) }
            }
            depth++
        }

        return depth
    }
}

fun main() {
    println(MaximumDepthOfBinaryTree().maxDepth(TreeNode.make_3_9_20_15_7()))
}