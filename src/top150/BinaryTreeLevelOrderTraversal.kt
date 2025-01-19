package top150

import TreeNode
import java.util.*

/**
 * 102. Binary Tree Level Order Traversal
 */
class BinaryTreeLevelOrderTraversal {

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        dfs(root ?: return emptyList(), 0, result)
        return result
    }

    private fun dfs(treeNode: TreeNode, levelIndex: Int, result: MutableList<MutableList<Int>>) {
        if (result.size - 1 < levelIndex) { result.add(mutableListOf()) }
        result[levelIndex].add(treeNode.`val`)
        treeNode.left?.let { dfs(it, levelIndex + 1, result) }
        treeNode.right?.let { dfs(it, levelIndex + 1, result) }
    }

    fun levelOrderBFS(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        val queue = LinkedList<TreeNode>()
        queue.add(root ?: return result)

        while (queue.isNotEmpty()) {
            val polls = mutableListOf<TreeNode>()
            while (queue.isNotEmpty()) { polls.add(queue.poll()) }

            val nodes = mutableListOf<Int>()
            result.add(nodes)
            for (poll in polls) {
                nodes.add(poll.`val`)
                poll.left?.let { queue.add(it) }
                poll.right?.let { queue.add(it) }
            }
        }

        return result
    }
}

fun main() {
    println(BinaryTreeLevelOrderTraversal().levelOrder(TreeNode.make_3_9_20_15_7()))
}