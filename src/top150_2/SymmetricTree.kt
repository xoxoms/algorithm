package top150_2

import TreeNode
import java.util.LinkedList

/**
 * 101. Symmetric Tree
 * 50m
 * 풀다보면 easy들이 더 어려운거같다.
 * 내가 해결한 BFS 방식은 연산 속도가 별로다.
 * ===================
 * 큐에 좌, 우를 넣는다.
 * 큐를 전부 poll한다.
 * poll한 값의 size 반까지 수회하며 반대와 같은 값인지 확인한다.
 * 통과하면 다음 레벨로 넘어가기 위해 각 polled 별 left, right를 큐에 넣는다.
 * 전부 null이면 탈출한다.
 */
class SymmetricTree {

    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) { return false }
        val queue = LinkedList<TreeNode?>()
        queue.add(root.left)
        queue.add(root.right)

        while (queue.isNotEmpty()) {
            val polls = mutableListOf<TreeNode?>()
            while (queue.isNotEmpty()) {
                polls.add(queue.poll())
            }

            for (i in 0 ..< polls.size / 2) {
                if (polls[i]?.`val` != polls[polls.size - 1 - i]?.`val`) {
                    return false
                }
            }

            polls.forEach {
                queue.add(it?.left)
                queue.add(it?.right)
            }

            if (queue.all { it == null }) {
                break
            }
        }

        return true
    }
}

fun main() {
    println(SymmetricTree().isSymmetric(TreeNode.make(1, 2, 2, null, 3, null, 3)))
    println(SymmetricTree().isSymmetric(TreeNode.make(1, 2, 2, 3, 4, 4, 3)))
}