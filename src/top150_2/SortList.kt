package top150_2

import top150.ListNode

/**
 * 148. Sort List !!
 * mergesort로 해결하는게 복잡도 우위에 있다.
 * 머지소트 떠올리지못해 비효율적인 방식으로 해결해버렸다.
 */
class SortList {

    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) { return head }
        val list = mutableListOf<ListNode>()
        var target = head
        while (target != null) {
            list.add(target)
            target = target.next
        }

        list.sortBy { it.`val` }
        for (i in 0 ..< list.size - 1) {
            list[i].next = list[i + 1]
        }
        list.last().next = null

        return list[0]
    }
}