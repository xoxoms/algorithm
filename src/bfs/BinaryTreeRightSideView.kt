package bfs

import TreeNode
import java.util.*

/**
 * 199. Binary Tree Right Side View
 * 큐에 레벨 별 리스트를 넣은 후 마지막 것을 꺼내어 결과값으로 사용
 */
class BinaryTreeRightSideView {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) { return emptyList() }

        val queue = LinkedList<TreeNode>()
        queue.add(root)

        val result = ArrayList<Int>()
        while (queue.isNotEmpty()) {
            val list = mutableListOf<TreeNode>()

            while (queue.isNotEmpty()) {
                val polled = queue.poll()
                if (polled != null) {
                    list.add(polled)
                }
            }

            for (treeNode in list) {
                treeNode.left?.let { queue.add(it) }
                treeNode.right?.let { queue.add(it) }
            }
            result.add(list.last().`val`)
        }

        return result
    }
}

fun main(args: Array<String>) {
    val root = TreeNode(1)

    BinaryTreeRightSideView().rightSideView(root)
}