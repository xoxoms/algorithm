package top150_2

import top150.ListNode

/**
 * 19. Remove Nth Node From End of List
 * ======================================
 * next가 없을때까지 current를 갱신하고, l에 넣는다.
 * 이후, i - n - 1 값의 next를 i - n + 1로 할당해준다.
 */
class RemoveNthNodeFromEndOfList {

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head

        var current: ListNode? = dummy
        var i = 0
        val l = mutableListOf<ListNode>()
        while (current != null) {
            l.add(current)
            i++
            current = current.next
        }

        if (n == 1) {
            l[i - 1 - 1].next = null
        } else {
            l[(i - 1 - n)].next = l[(i + 1 - n)]
        }

        return dummy.next
    }
}