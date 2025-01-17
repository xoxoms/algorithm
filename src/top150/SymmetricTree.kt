package top150

import TreeNode
import java.util.*

/**
 * 101. Symmetric Tree
 * 역시 어렵게 생각할게 없었는데,,요령을 못찾았다.
 * 재귀로 구현하면 간단하게 끝난다.
 */
class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return false
        return isSame(root.left, root.right)
    }

    private fun isSame(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) return true
        if (left?.`val` != right?.`val`) return false
        return isSame(left?.left, right?.right) && isSame(left?.right, right?.left)
    }

    fun isSymmetricBFS(root: TreeNode?): Boolean {
        val queue = LinkedList<TreeNode?>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val polls = mutableListOf<TreeNode?>()
            while (queue.isNotEmpty()) { polls.add(queue.poll()) }

            for (i in 0 .. polls.size / 2) {
                if (polls[i]?.`val` != polls[polls.size - 1 - i]?.`val`) {
                    return false
                }
            }

            var doBreak = true
            for (polled in polls) {
                if (polled?.left != null || polled?.right != null) {
                    doBreak = false
                }

                queue.add(polled?.left)
                queue.add(polled?.right)
            }

            if (doBreak) { break }
        }

        return true
    }
}

fun main() {
    println(SymmetricTree().isSymmetric(TreeNode.make(1,2,2,3,4,4,3)))
}