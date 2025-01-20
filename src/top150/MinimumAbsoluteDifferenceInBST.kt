package top150

import TreeNode
import java.util.*
import kotlin.math.min

/**
 * 530. Minimum Absolute Difference in BST
 */
class MinimumAbsoluteDifferenceInBST {
    fun getMinimumDifference(root: TreeNode?): Int {
        val queue = LinkedList<TreeNode>()
        val nums = mutableListOf<Int>()
        queue.add(root ?: return 0)
        while (queue.isNotEmpty()) {
            val polled = queue.poll()
            nums.add(polled.`val`)
            polled.left?.let { queue.add(it) }
            polled.right?.let { queue.add(it) }
        }

        nums.sort()
        var result = nums[1] - nums[0]
        for (i in 1..< nums.size - 1) {
            result = min(result, min(nums[i] - nums[i - 1], nums[i + 1] - nums[i]))
        }

        return result
    }
}

fun main() {
    println(MinimumAbsoluteDifferenceInBST().getMinimumDifference(TreeNode.make(4,2,6,1,3)))
}