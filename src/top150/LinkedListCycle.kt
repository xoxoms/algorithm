package top150

import java.util.*

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * 141. Linked List Cycle
 * slow, fast로 해결한다.
 * 싸이클이 존재하면 언젠가는 fast가 slow를 따라잡기 때문
 */
class LinkedListCycle {

    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head

        while (fast?.next != null) {
            slow = slow!!.next
            fast = fast.next!!.next
            if (slow == fast) {
                return true
            }
        }

        return false
    }

    fun hasCycle2(head: ListNode?): Boolean {
        if (head?.next == null) return false

        val queue = LinkedList<ListNode>()
        queue.add(head)
        val visited = mutableSetOf<ListNode>()
        while (queue.isNotEmpty()) {
            val polled = queue.poll()
            if (visited.contains(polled)) {
                return true
            } else {
                visited.add(polled)
            }

            polled?.next?.let { queue.add(it) }
        }

        return false
    }
}

fun main() {
    val root = ListNode(3)
    val node1 = ListNode(2)
    val node2 = ListNode(0)
    val node3 = ListNode(-3)
    root.next = node1
    node1.next = node2
    node2.next = node3
    node3.next = node2
    println(LinkedListCycle().hasCycle(root))
}