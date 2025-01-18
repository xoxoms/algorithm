package top150

import TreeNode
import java.util.*

/**
 * 236. Lowest Common Ancestor of a Binary Tree !!
 * 해결했으나, 방식이 너무 별로다.
 * 복습필요
 */
class LowestCommonAncestorOfABinaryTree {

    /**
     * queue에 root를 넣는다.
     * p와 q 둘다 찾을때까지 bfs 탐색한다.
     * 탐색과 함께 map에 node, parent를 저장한다.
     * 탐색 종료 후 map에서 부모를 따라가며 동일한 것을 리턴한다.
     */
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        val queue = LinkedList<TreeNode>()
        val map = mutableMapOf<TreeNode, TreeNode>()
        queue.add(root ?: return null)
        var foundP: TreeNode? = null
        var foundQ: TreeNode? = null

        while (queue.isNotEmpty()) {
            val polls = LinkedList<TreeNode>()
            while (queue.isNotEmpty()) { polls.add(queue.poll()) }

            for (polled in polls) {
                polled.left?.let {
                    map[it] = polled
                    queue.add(it)
                }
                polled.right?.let {
                    map[it] = polled
                    queue.add(it)
                }
                if (polled == p) { foundP = polled }
                if (polled == q) { foundQ = polled }
            }

            if (foundP != null && foundQ != null) { break }
        }

        val parentP = mutableListOf<TreeNode>()
        val parentQ = mutableListOf<TreeNode>()

        var targetP = foundP
        while (map[targetP] != null) {
            parentP.add(map[targetP]!!)
            targetP = map[targetP]!!
        }

        var targetQ = foundQ
        while (map[targetQ] != null) {
            parentQ.add(map[targetQ]!!)
            targetQ = map[targetQ]!!
        }

        val left = mutableListOf<TreeNode>()
        val right = mutableListOf<TreeNode>()
        if (parentP.size > parentQ.size) {
            left.addAll(parentP)
            left.add(foundP!!)
            right.addAll(parentQ)
            right.add(foundQ!!)
        } else {
            left.addAll(parentQ)
            left.add(foundQ!!)
            right.addAll(parentP)
            right.add(foundP!!)
        }

        for (l in left) {
            for (r in right) {
                if (l == r) {
                    return r
                }
            }
        }

        return null
    }
}

fun main() {
    val root = TreeNode(3)
    val node1 = TreeNode(5)
    val node2 = TreeNode(1)
    val node3 = TreeNode(6)
    val node4 = TreeNode(2)
    val node5 = TreeNode(0)
    val node6 = TreeNode(8)
    val node7 = TreeNode(7)
    val node8 = TreeNode(4)
    root.left = node1
    root.right = node2
    node1.left = node3
    node1.right = node4
    node2.left = node5
    node2.right = node6
    node4.left = node7
    node4.right = node8

    val result = LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(root, node1, node8)
    println(result?.`val`)
}