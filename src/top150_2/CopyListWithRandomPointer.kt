package top150_2

/**
 * 138. Copy List with Random Pointer !!
 * 1h
 * 최적화된 방식으로 해결하지 못했다.
 * ==================================
 * current, random, next 각각 연관관계가 있기 때문에
 * 재귀로 node를 생성해서 반환하게하여 해결했다.
 */
class CopyListWithRandomPointer {
    private val list = mutableListOf<Node>()
    private val nodeIndexMap = mutableMapOf<Node, Int>()
    private val map = mutableMapOf<Int, Node>()

    fun copyRandomList(node: Node?): Node? {
        if (node == null) { return node }
        var n = node
        var i = 0
        while (n != null) {
            list.add(n)
            nodeIndexMap[n] = i++
            n = n.next
        }

        return get(0)!!
    }

    private fun get(idx: Int): Node? {
        if (map[idx] != null) { return map[idx]!! }
        val origin = list[idx]
        val result = Node(origin.`val`)
        map[idx] = result

        val random = if (origin.random != null) { get(nodeIndexMap[origin.random]!!) } else { null }
        val next = if (origin.next != null) { get(idx+1) } else { null }
        result.random = random
        result.next = next
        return result
    }
}

class Node(
    val `val`: Int
) {
    var next: Node? = null
    var random: Node? = null
}

fun main() {
    val node1 = Node(7)
    val node2 = Node(13)
    val node3 = Node(11)
    val node4 = Node(10)
    val node5 = Node(1)
    node1.next = node2
    node1.random = null
    node2.next = node3
    node2.random = node1
    node3.next = node4
    node3.random = node5
    node4.next = node5
    node4.random = node3
    node5.next = null
    node5.random = node1

    CopyListWithRandomPointer().copyRandomList(node1)
}