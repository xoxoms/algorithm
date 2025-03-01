package bfs

import TreeNode
import java.util.*

/**
 * 700. Search in a Binary Search Tree
 * 재귀가 더 나은 답안이다.
 */
class SearchBST {

    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        val queue = LinkedList<TreeNode>()
        queue.add(root ?: return null)
        while (queue.isNotEmpty()) {
            val polled = queue.poll()
            if (polled.`val` == `val`) {
                return polled
            }

            polled.left?.let { queue.add(it) }
            polled.right?.let { queue.add(it) }
        }

        return null
    }
}

fun main() {
    SearchBST().searchBST(root = TreeNode.make_3_9_20_15_7(), 9)
}