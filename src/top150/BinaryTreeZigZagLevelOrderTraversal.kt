package top150

import TreeNode
import java.util.*

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 */
class BinaryTreeZigZagLevelOrderTraversal {

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        recursive(root ?: return emptyList(), 0, 1, result)
        return result
    }

    private fun recursive(treeNode: TreeNode, levelIndex: Int, direction: Int, result: MutableList<MutableList<Int>>) {
        if (result.size - 1 < levelIndex) { result.add(mutableListOf()) }

        if (direction == 1) {
            result[levelIndex].add(treeNode.`val`)
        } else {
            result[levelIndex].add(0, treeNode.`val`)
        }

        treeNode.left?.let { recursive(it, levelIndex + 1, direction * -1, result) }
        treeNode.right?.let { recursive(it, levelIndex + 1, direction * -1, result) }
    }

    fun zigzagLevelOrderBFS(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val queue = LinkedList<TreeNode>()
        queue.add(root ?: return result)
        var direction = 1
        while (queue.isNotEmpty()) {
            val polls = mutableListOf<TreeNode>()
            while (queue.isNotEmpty()) { polls.add(queue.poll()) }

            val values = mutableListOf<Int>()
            result.add(values)
            for (i in 0 ..< polls.size) {
                if (direction == 1) {
                    values.add(polls[i].`val`)
                } else {
                    values.add(polls[polls.size - 1 - i].`val`)
                }

                polls[i].left?.let { queue.add(it) }
                polls[i].right?.let { queue.add(it) }
            }
            direction *= -1
        }

        return result
    }
}

fun main() {
    println(BinaryTreeZigZagLevelOrderTraversal().zigzagLevelOrder(TreeNode.make_3_9_20_15_7()))
}