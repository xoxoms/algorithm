package medium

import TreeNode
import java.util.*
import kotlin.math.max
import kotlin.math.min

/**
 * 314. Binary Tree Vertical Order Traversal
 * if (!map.containsKey(curr)) {} 이 computeAbsent보다 좋은듯.
 * =========================================
 * idx map을 둔다.
 * left일 경우 curr - 1을
 * right일 경우 curr + 1을 key로하는 맵에 list를 삽입한다.
 * list는 결과에도 삽입한다.
 * 결과는 앞뒤로 삽입할수있도록 덱으로 만든다.
 */
class BinaryTreeVerticalOrderTraversal {
    private val map = mutableMapOf<Int, MutableList<Int>>()

    fun verticalOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return emptyList()
        }

        val queue = LinkedList<Pair<TreeNode, Int>>()
        queue.add(Pair(root, 0))

        var minValue = 0
        var maxValue = 0
        while (queue.isNotEmpty()) {
            val polled = queue.poll()
            val node = polled.first
            val curr = polled.second

            minValue = min(minValue, curr)
            maxValue = max(maxValue, curr)
            if (!map.containsKey(curr)) {
                map[curr] = mutableListOf()
            }

            map[curr]!!.add(node.`val`)
            node.left?.let { queue.add(Pair(it, curr - 1)) }
            node.right?.let { queue.add(Pair(it, curr + 1)) }
        }

        val result = mutableListOf<List<Int>>()
        for (i in minValue .. maxValue) {
            result.add(map[i]!!)
        }

        return result
    }
}

fun main() {
    println(BinaryTreeVerticalOrderTraversal().verticalOrder(TreeNode.make_3_9_20_15_7()))
}