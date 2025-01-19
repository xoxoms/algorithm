package top150

import TreeNode
import java.util.*

/**
 * 199. Binary Tree Right Side View
 */
class BinaryTreeRightSideView {
    fun rightSideView(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        val queue = LinkedList<TreeNode>()
        queue.add(root ?: return emptyList())

        while (queue.isNotEmpty()) {
            val polls = mutableListOf<TreeNode>()
            while (queue.isNotEmpty()) {
                polls.add(queue.poll())
            }

            if (polls.isEmpty()) { break }
            result.add(polls.last().`val`)

            for (poll in polls) {
                poll.left?.let { queue.add(it) }
                poll.right?.let { queue.add(it) }
            }
        }

        return result
    }
}

fun main() {
    println(BinaryTreeRightSideView().rightSideView(TreeNode.make(1,2,3,null,5,null,4)))
}