package top150_2

import top150.ListNode

/**
 * 61. Rotate List
 * 풀긴했지만, 복잡도가 좋지 않았다.
 * ===========================
 * 루핑하여 리스트에 넣는다.
 * k 값을 사이즈 모듈러 연산하여 rotate를 구한다.
 * l.last().next를 처음 값으로,
 * l[l.size - r -1].next를 null로 변경한다.
 */
class RotateList {

    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null || k == 0) { return head }

        val l = mutableListOf<ListNode>()
        var idx = 0
        var current = head
        while (current != null) {
            l.add(current)
            current = current.next
            idx++
        }

        val r = k % l.size
        if (r == 0) { return head }

        l.last().next = l[0]
        val newFirst = l.size - r
        l[newFirst - 1].next = null

        return l[newFirst]
    }
}