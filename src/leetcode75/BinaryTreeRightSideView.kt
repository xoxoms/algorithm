package leetcode75

import TreeNode
import java.util.LinkedList

/**
 * 199. Binary Tree Right Side View
 */
class BinaryTreeRightSideView {
    fun rightSideView(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        val queue = LinkedList<TreeNode>()
        queue.add(root ?: return emptyList())

        while (queue.isNotEmpty()) {
            val polled = mutableListOf<TreeNode>()
            while (queue.isNotEmpty()) {
                polled.add(queue.poll())
            }

            for (i in 0 ..< polled.size) {
                polled[i].right?.let { queue.add(it) }
                polled[i].left?.let { queue.add(it) }
            }

            result.add(polled.first().`val`)
        }

        return result
    }
}

fun main() {
    println(BinaryTreeRightSideView().rightSideView(TreeNode.make_3_9_20_15_7()))
}