package medium

import top150.ListNode
import java.util.*

/**
 * 24. Swap Nodes in Pairs
 * 굳이 큐를 쓰지 않아도 됐다.
 * =======================
 * dummy를 만든다.
 * dummy의 next에 head를 넣는다.
 * queue에 dummy를 넣고 queue가 빌때까지 반복한다.
 * polled.next와 polled.next.next의 값을 바꾼다.
 * polled.next.next.next를 큐에 넣는다.
 * dummy.next를 응답한다.
 */
class SwapNodesInPairs {

    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) { return head }
        val dummy = ListNode(0)
        dummy.next = head
        val queue = LinkedList<ListNode?>()
        queue.add(dummy)

        while (queue.isNotEmpty()) {
            val polled = queue.poll()
            if (polled?.next?.next == null) { break }

            val temp = polled.next!! // 1
            polled.next = polled.next!!.next // 2
            temp.next = polled.next!!.next // 3
            polled.next!!.next = temp // 4

            queue.add(polled.next!!.next) // 0 2 1 3 4
        }

        return dummy.next
    }
}

fun main() {
    val head = ListNode(1)
    val node1 = ListNode(2)
    val node2 = ListNode(3)
    val node3 = ListNode(4)

    head.next = node1
    node1.next = node2
    node2.next = node3

    var result = SwapNodesInPairs().swapPairs(head)
    while (result != null) {
        print("${result.`val`} ")
        result = result.next
    }
    println()
}