package top150

import bfs.Node
import java.util.*

class CloneGraph {
    /**
     * 133. Clone Graph
     * node 값을 큐에 넣는다.
     * 동일한 값을 갖는 신규 노드 만든다.
     * neighbors를 맵에서 꺼낸다.
     * 없으면 새로만든다.
     * 기존 node neighbors를 큐에 넣는다.
     */
    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null
        val map = mutableMapOf<Int, Node>()
        map[node.`val`] = Node(node.`val`)

        val queue = LinkedList<Node>()
        queue.add(node)

        while (queue.isNotEmpty()) {
            val polled = queue.poll()
            if (!map.contains(polled.`val`)) {
                map[polled.`val`] = Node(polled.`val`)
            }

            polled.neighbors.forEach { neighbor ->
                if (neighbor != null) {
                    if (!map.contains(neighbor.`val`)) {
                        map[neighbor.`val`] = Node(neighbor.`val`)
                        queue.add(neighbor)
                    }
                    map[polled.`val`]!!.neighbors.add(map[neighbor.`val`]!!)
                }
            }
        }

        return map[node.`val`]!!
    }
}

fun main() {
    CloneGraph().cloneGraph(Node(1))
}