package top150_2

import TreeNode
import java.util.LinkedList

/**
 * 637. Average of Levels in Binary Tree
 * BFS로 해결한다.
 * 한 level의 값들을 모두 꺼내어 sum하고, 평균 구해서 결과에 넣는다.
 */
class AverageOfLevelsInBinaryTree {

    fun averageOfLevels(root: TreeNode?): DoubleArray {
        if (root == null) { return doubleArrayOf() }
        val averages = mutableListOf<Double>()
        val queue = LinkedList<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            var sum = 0.0
            val polls = mutableListOf<TreeNode>()
            while (queue.isNotEmpty()) {
                val polled = queue.poll()
                polls.add(polled)
                sum += polled.`val`
            }

            averages.add(sum / polls.size)

            polls.forEach {
                it.left?.let { queue.add(it) }
                it.right?.let { queue.add(it) }
            }
        }

        val result = DoubleArray(averages.size)
        for (i in 0 ..< averages.size) {
            result[i] = averages[i]
        }

        return result
    }
}