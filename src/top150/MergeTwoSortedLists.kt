package top150

import java.util.*

/**
 * 21. Merge Two Sorted Lists
 * 재귀로 하는게 훨 나음
 * l1과 l2의 값을 비교한다.
 * 작은 쪽을 루트로 쓴다.
 * 작은쪽.next와 큰쪽을 비교한다.
 * 작은쪽을 루트의 next로 쓴다.
 * 위를 반복한다.
 */
class MergeTwoSortedLists {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null && list2 == null) return null
        if (list1 == null) return list2
        if (list2 == null) return list1

        return if (list1.`val` < list2.`val`) {
            list1.next = mergeTwoLists(list1.next, list2)
            list1
        } else {
            list2.next = mergeTwoLists(list1, list2.next)
            list2
        }
    }

    fun mergeTwoLists2(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) { return list2 }
        if (list2 == null) { return list1 }

        val queue = LinkedList<ListNode?>()
        queue.add(list1)
        queue.add(list2)

        var prev: ListNode? = null
        while (queue.isNotEmpty()) {
            val l1 = queue.poll()
            val l2 = queue.poll()
            if (l1 == null && l2 == null) { break }

            if (l1 != null && l2 != null) {
                if (l1.`val` < l2.`val`) {
                    prev?.next = l1
                    prev = l1
                    queue.add(l1.next)
                    queue.add(l2)
                } else {
                    prev?.next = l2
                    prev = l2
                    queue.add(l1)
                    queue.add(l2.next)
                }
            } else if (l1 == null) {
                prev?.next = l2
                prev = l2
                queue.add(null)
                queue.add(l2!!.next)
            } else {
                prev?.next = l1
                prev = l1
                queue.add(l1.next)
                queue.add(null)
            }
        }

        return if (list1.`val` < list2.`val`) { list1 } else { list2 }
    }
}

fun main() {
    val l1 = ListNode(1)
    val l11 = ListNode(2)
    val l12 = ListNode(4)
    l1.next = l11
    l11.next = l12

    val l2 = ListNode(1)
    val l21 = ListNode(3)
    val l22 = ListNode(4)
    l2.next = l21
    l21.next = l22

    var target = MergeTwoSortedLists().mergeTwoLists(l1, l2)
    while (target != null) {
        print("${target.`val`},")
        target = target.next
    }
    println()
}