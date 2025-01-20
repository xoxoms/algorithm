package top150

import TreeNode
import java.util.*

/**
 * 230. Kth Smallest Element in a BST
 * 모든 원소를 넣는 방법이 아닌, k개가 쌓이면 값 비교 후 삽입하는 방식의 최적화가 가능
 */
class KthSmallestElementInaBST {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val queue = LinkedList<TreeNode>()
        val nums = mutableListOf<Int>()
        queue.add(root ?: return 0)
        while (queue.isNotEmpty()) {
            val polled = queue.poll()
            polled.left?.let { queue.add(it) }
            polled.right?.let { queue.add(it) }
            nums.add(polled.`val`)
        }

        nums.sort()
        return nums[k - 1]
    }
}

fun main() {
    println(KthSmallestElementInaBST().kthSmallest(TreeNode.make(3,1,4,null,2), 1))
}