package top150_2

import top150.ListNode

/**
 * 2. Add Two Numbers
 * 두 노드 값 더하고 오버플로값은 다음 연산에 사용한다.
 */
class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var result = ListNode(0)

        var left = l1
        var right = l2
        var carry = 0
        var current = result
        while (left != null || right != null) {
            val sum = (left?.`val` ?: 0) + (right?.`val` ?: 0) + carry
            current.next = ListNode((sum % 10))
            current = current.next!!
            left = left?.next
            right = right?.next
            carry = sum / 10
        }

        if (carry != 0) {
            current.next = ListNode(carry)
        }

        return result.next
    }
}