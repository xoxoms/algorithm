package top150_2

import top150.ListNode

/**
 * 82. Remove Duplicates from Sorted List II !!
 * 40m
 * 조금 헤맸는데 방향성은 틀리지 않았고 곧 풀게됨.
 * =================
 * 더미를 만든다.
 * current.next 와 current.next.next가 같다면, 중복된 건이다.
 * 위 건의 경우 current.next 값과 다른 값이 나올때까지 루핑한다.
 * 새로나온 값을 current.next에 갱신한다.
 * 더미.next를 반환한다.
 */
class RemoveDuplicatesFromSortedListII {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val dummy = ListNode(-101)
        dummy.next = head
        var current: ListNode? = dummy
        while (current != null) {
            if (current.next != null && current.next?.`val` == current.next?.next?.`val`) {
                var c = current.next
                while (c != null && c.`val` == current.next!!.`val`) {
                    c = c.next
                }

                current.next = c
            } else {
                current = current.next
            }
        }

        return dummy.next
    }
}