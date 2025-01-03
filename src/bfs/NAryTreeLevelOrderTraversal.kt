package bfs

import java.util.*

/**
 * 429. N-ary Tree Level Order Traversal
 * 루트부터 큐에 넣는다.
 * 큐가 빌때까지 컨슘한 후, 자식노드들을 큐에 넣는다.
 */
class NAryTreeLevelOrderTraversal {
    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }

    fun levelOrder(root: Node?): List<List<Int>> {
        if (root == null) { return emptyList() }
        val result = mutableListOf<List<Int>>()

        val queue = LinkedList<Node>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val current = mutableListOf<Node>()
            while (queue.isNotEmpty()) {
                current.add(queue.poll())
            }

            for (node in current) {
                for (child in node.children) {
                    queue.offer(child)
                }
            }

            result.add(current.map { it.`val` })
        }

        return result
    }
}

fun main() {
    val root = NAryTreeLevelOrderTraversal.Node(1)

    NAryTreeLevelOrderTraversal().levelOrder(root)
}