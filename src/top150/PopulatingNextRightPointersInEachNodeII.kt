package top150

import java.util.*

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}

/**
 * 117. Populating Next Right Pointers in Each Node II
 * 좋은 해법은 아니다.
 */
class PopulatingNextRightPointersInEachNodeII {

    fun connect(root: Node?): Node? {
        if (root == null) return null

        val queue = LinkedList<Node>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val polls = mutableListOf<Node>()
            while (queue.isNotEmpty()) {
                val polled = queue.poll()
                if (polled != null) {
                    polls.add(polled)
                }
            }

            if (polls.isEmpty()) { break }

            for (i in 0..< polls.size - 1) {
                polls[i].next = polls[i + 1]
            }

            for (i in 0..< polls.size) {
                polls[i].left?.let { queue.add(it) }
                polls[i].right?.let { queue.add(it) }
            }
        }

        return root
    }
}

fun main() {
    val root = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)
    val node5 = Node(5)
    val node7 = Node(7)
    root.left = node2
    root.right = node3
    node2.left = node4
    node2.right = node5
    node3.right = node7

    PopulatingNextRightPointersInEachNodeII().connect(root)
}