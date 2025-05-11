package top150_2

import top150.ListNode

/**
 * 21. Merge Two Sorted Lists
 */
class MergeTwoSortedLists {

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var l = list1
        var r = list2

        var prev = dummy
        while (l != null || r != null) {
            if (l == null) {
                prev.next = ListNode(r!!.`val`)
                prev = prev.next!!
                r = r!!.next
                continue
            }

            if (r == null) {
                prev.next = ListNode(l!!.`val`)
                prev = prev.next!!
                l = l!!.next
                continue
            }

            if (l!!.`val` > r!!.`val`) {
                prev.next = ListNode(r!!.`val`)
                prev = prev.next!!
                r = r!!.next
            } else if (l!!.`val` == r!!.`val`) {
                prev.next = ListNode(l!!.`val`)
                prev = prev.next!!
                l = l!!.next
                prev.next = ListNode(r!!.`val`)
                prev = prev.next!!
                r = r!!.next
            } else {
                prev.next = ListNode(l!!.`val`)
                prev = prev.next!!
                l = l!!.next
            }
        }

        return dummy.next
    }
}