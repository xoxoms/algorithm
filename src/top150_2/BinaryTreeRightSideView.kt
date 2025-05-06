package top150_2

import TreeNode
import java.util.LinkedList

/**
 * 199. Binary Tree Right Side View
 * BFS 탐색으로 해결
 */
class BinaryTreeRightSideView {
    fun rightSideView(root: TreeNode?): List<Int> {
        val queue = LinkedList<TreeNode>()
        val result = mutableListOf<Int>()
        if (root == null) { return result }

        queue.add(root)

        while (queue.isNotEmpty()) {
            val polled = mutableListOf<TreeNode>()
            while (queue.isNotEmpty()) {
                polled.add(queue.poll())
            }

            result.add(polled.last().`val`)
            polled.forEach { poll ->
                poll.left?.let { queue.add(it) }
                poll.right?.let { queue.add(it) }
            }
        }

        return result
    }
}