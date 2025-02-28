package leetcode75

import top150.ListNode

/**
 * 2095. Delete the Middle Node of a Linked List
 * node.next?.next 같은 방식으로 처리하면 더 수월한거같다.
 * 효율이 좋지않은 해답.
 */
class DeleteTheMiddleNodeOfALinkedList {
    fun deleteMiddle(head: ListNode?): ListNode? {
        if (head == null) {
            return head
        }

        val dummy = ListNode(-1)
        dummy.next = head

        var target = head!!
        var count = 0
        while (target.next != null) {
            target = target.next!!
            count++
        }

        val mid = count / 2
        target = dummy
        while (count-- > mid) {
            target = target.next!!
        }

        target.next = target.next?.next

        return dummy.next
    }
}

fun main() {
    DeleteTheMiddleNodeOfALinkedList().deleteMiddle(ListNode(1))
}