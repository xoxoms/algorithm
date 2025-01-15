package top150

/**
 * 61. Rotate List !!
 * 첫 순회로 총사이즈와 마지막 노드를 구한다.
 * 로테이트할 값 k % 사이즈 값이 0이면 제자리이므로 얼리리턴한다.
 * newLast를 갱신한다.
 * 루핑할 (size - round - 1) 값을 구하는 이유를 이해해야한다.
 * newLast는 마지막값이므로 newLast.next가 헤더가 된다.
 * 기존 tail은 head를 바라본다.
 */
class RotateList {

    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        var tail: ListNode = head ?: return null
        var size = 1
        while (tail.next != null) {
            tail = tail.next!!
            size++
        }

        val round = k % size
        if (round == 0) { return head }
        var newLast = head
        for (i in 0 ..< size - round - 1) {
            newLast = newLast?.next
        }

        val newHead = newLast?.next
        newLast?.next = null
        tail.next = head

        return newHead
    }

    fun rotateRight2(head: ListNode?, k: Int): ListNode? {
        val dummy = ListNode(-101)
        dummy.next = head
        var prev: ListNode? = null
        var curr = head

        var t: ListNode? = head ?: return null
        var size = 1
        while (t?.next != null) {
            t = t.next
            size++
        }

        val round = k % size
        if (round == 0) { return head }
        for (i in 0 until round) {
            if (curr?.next == null) { continue }

            while (curr?.next != null) {
                prev = curr
                curr = curr?.next
            }

            prev?.next = null
            curr?.next = dummy.next
            dummy.next = curr
        }

        return dummy.next
    }
}

fun main() {
    val head = ListNode(1)
    val node2 = ListNode(2)
//    val node3 = ListNode(3)
//    val node4 = ListNode(4)
//    val node5 = ListNode(5)
    head.next = node2
//    node2.next = node3
//    node3.next = node4
//    node4.next = node5

    val result = RotateList().rotateRight(head, 1)
//    val node2 = ListNode(2)
//    val node3 = ListNode(3)
//    val node4 = ListNode(4)
//    val node5 = ListNode(5)
//    head.next = node2
//    node2.next = node3
//    node3.next = node4
//    node4.next = node5
//
//    val result = RotateList().rotateRight(head, 2)
    var curr = result
    while (curr != null) {
        print("${curr.`val`} ")
        curr = curr.next
    }
    println()
}