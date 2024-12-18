package bfs

import TreeNode
import java.util.*

/**
 * 107. Binary Tree Level Order Traversal II
 * 큐에 다음 레벨 노드를 모두 넣은 후 취합
 */
class BinaryTreeLevelOrderTraversalII {

    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        val queue = LinkedList<TreeNode>()
        queue.add(root)

        val result = LinkedList<List<Int>>()
        while (queue.isNotEmpty()) {
            val items = mutableListOf<TreeNode>()
            while (queue.isNotEmpty()) {
                items.add(queue.poll())
            }

            val current = mutableListOf<Int>()
            result.addFirst(current)

            items.forEach { polled ->
                current.add(polled.`val`)
                polled.left?.let { queue.add(it) }
                polled.right?.let { queue.add(it) }
            }
        }

        return result
    }
}

fun main() {
    val root = TreeNode(1)
    println(BinaryTreeLevelOrderTraversalII().levelOrderBottom(root = root))
}