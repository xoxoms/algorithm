package top150_2

import TreeNode
import java.util.LinkedList

/**
 * 104. Maximum Depth of Binary Tree
 */
class MaximumDepthOfBinaryTree {

    fun maxDepth(root: TreeNode?): Int {
        var result = 0
        if (root == null) { return result }
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val polled = mutableListOf<TreeNode>()
            while (queue.isNotEmpty()) {
                polled.add(queue.poll())
            }

            result++
            polled.forEach {
                it.left?.let { l -> queue.add(l) }
                it.right?.let { r -> queue.add(r) }
            }
        }

        return result
    }
}