package top150_2

import TreeNode
import java.util.LinkedList

/**
 * 226. Invert Binary Tree
 * easy인데 생각하는데 오래걸렸다.....
 * ======================
 * root를 큐에넣는다.
 * 큐는 빌때까지 left/right 값을 스왑한다.
 * 큐에 left, right를 각각 넣는다.
 */
class InvertBinaryTree {

    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) { return root }
        val queue = LinkedList<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val polled = queue.poll()
            val temp = polled.left
            polled.left = polled.right
            polled.right = temp

            polled.left?.let { queue.add(it) }
            polled.right?.let { queue.add(it) }
        }

        return root
    }
}