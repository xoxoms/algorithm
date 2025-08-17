package top150_2

import java.util.*

/**
 * 117. Populating Next Right Pointers in Each Node II
 */
class PopulatingNextRightPointersInEachNodeII {

    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }

    fun connect(root: Node?): Node? {
        if (root == null) {
            return root
        }

        val queue = LinkedList<Node>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val polled = mutableListOf<Node>()
            while (queue.isNotEmpty()) {
                polled.add(queue.poll())
            }

            var last: Node? = null
            for (i in polled.size - 1 downTo 0) {
                polled.get(i).next = last
                last = polled.get(i)
            }

            polled.forEach {
                it.left?.let { queue.add(it) }
                it.right?.let { queue.add(it) }
            }
        }

        return root
    }
}