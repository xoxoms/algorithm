package top150_2

import top150.ListNode

/**
 * 92. Reverse Linked List II !!
 * 1h
 * 컨셉은 금방 떠올렸으나, 풀이에 오래걸렸다.
 * 다음번에는 좀더 빠르게 풀수있겠다.
 * ==============================
 * 더미를 만들고 시작한다.
 * left 값과 같을때까지(inclusive) current, prev를 전진한다.
 * 같아지면 l(좌측 값)을 초기화 한다.
 *
 * current.next를 따라가면서 current.next를 prev 값으로 업데이트해준다.
 * right 값과 같아지면 루프를 탈출한다.
 *
 * l.next.next(변경 시작점의 다음 값)에 current를 넣어준다.
 * l.next(결과 좌측 첫값) 값에 prev를 넣는다.
 */
class ReverseLinkedListII {

    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head

        var round = 1
        var prev = dummy
        var current = head
        var l = prev
        while (current != null && round <= right) {
            if (round <= left) {
                l = prev
                prev = current
                current = current.next
            } else {
                val temp = current.next
                current.next = prev
                prev = current
                current = temp
            }

            round++
        }

        l.next?.next = current
        l.next = prev

        return dummy.next
    }
}

fun main() {
    val head = ListNode(3)
    val node2 = ListNode(5)
    head.next = node2
    val result = ReverseLinkedListII().reverseBetween(head, 1, 2)
    println(result?.`val`)
}