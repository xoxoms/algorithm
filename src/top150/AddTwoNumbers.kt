package top150

import java.util.*

/**
 * 2. Add Two Numbers
 * O(N) 30m
 * 재귀로 풀면 훨씬 더 깔끔해진다.
 */
class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var target1 = l1
        var target2 = l2
        var overflow = 0
        val queue = LinkedList<ListNode>()

        while (target1 != null || target2 != null || overflow != 0) {
            var sum = overflow
            if (target1 != null) {
                sum += target1.`val`
                target1 = target1.next
            }
            if (target2 != null) {
                sum += target2.`val`
                target2 = target2.next
            }

            overflow = sum/10
            queue.add(ListNode(sum%10))
        }

        for (i in 0 until queue.size - 1) {
            queue[i].next = queue[i + 1]
        }

        return queue[0]
    }
}

fun main() {
    val l1 = ListNode(9)
    val l2 = ListNode(1)
    val l21 = ListNode(9)
    val l22 = ListNode(9)
    val l23 = ListNode(9)
    val l24 = ListNode(9)
    val l25 = ListNode(9)
    val l26 = ListNode(9)
    val l27 = ListNode(9)
    val l28 = ListNode(9)
    val l29 = ListNode(9)
    l2.next = l21
    l21.next = l22
    l22.next = l23
    l23.next = l24
    l24.next = l25
    l25.next = l26
    l26.next = l27
    l27.next = l28
    l28.next = l29

//    val l1 = ListNode(2)
//    val l11 = ListNode(4)
//    val l12 = ListNode(3)
//    l1.next = l11
//    l11.next = l12
//
//    val l2 = ListNode(5)
//    val l21 = ListNode(6)
//    val l22 = ListNode(4)
//    l2.next = l21
//    l21.next = l22

    val result = AddTwoNumbers().addTwoNumbers(l1, l2)
    var target = result
    while (target != null) {
        print("${target.`val`},")
        target = target.next
    }
    println()
}