package top150_2

import top150.ListNode

/**
 * 141. Linked List Cycle
 * 싸이클이 있는지는 fast slow 알고리즘으로 해결했어야한다.
 */
class HasCycle {
    fun hasCycle(head: ListNode?): Boolean {
        val set = mutableSetOf<ListNode>()

        var target = head
        while (target != null) {
            if (set.contains(target)) {
                return true
            }
            set.add(target)
            target = target.next
        }

        return false
    }
}