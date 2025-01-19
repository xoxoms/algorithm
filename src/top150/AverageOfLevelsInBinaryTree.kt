package top150

import TreeNode
import java.util.*

/**
 * 637. Average of Levels in Binary Tree
 */
class AverageOfLevelsInBinaryTree {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val result = mutableListOf<Double>()
        val queue = LinkedList<TreeNode>()
        queue.add(root ?: return result.toDoubleArray())

        while (queue.isNotEmpty()) {
            val polls = mutableListOf<TreeNode>()
            while (queue.isNotEmpty()) {
                polls.add(queue.poll())
            }

            var sum = 0.0
            for (poll in polls) {
                poll.left?.let { queue.add(it) }
                poll.right?.let { queue.add(it) }
                sum += poll.`val`
            }

            result.add(sum / polls.size)
        }

        return result.toDoubleArray()
    }
}

fun main() {
    AverageOfLevelsInBinaryTree().averageOfLevels(TreeNode.make(3,9,20,null,null,15,7))
        .forEach {
            print("$it ")
        }
    println()
}