package top150

/**
 * 86. Partition List !!
 * 헤더가 바뀔수 있기때문에 dummy를 추가한다.
 * leftLast를 dummy로 초기화한다.
 * curr.next != null 루핑한다.
 * curr.val >= x면 curr과 prev를 업데이트한다.
 * curr.val < x이고, curr이 leftLat의 다음이면 자리 바꿀일 없으므로 한칸씩 업데이트한다.
 * curr.next < x면 스왑한다.
 */
class PartitionList {
    fun partition(head: ListNode?, x: Int): ListNode? {
        val dummy = ListNode(-101)
        dummy.next = head
        var lastLeft = dummy
        var prev = lastLeft
        var curr: ListNode? = head ?: return null

        while (curr != null) {
            if (curr.`val` >= x) {
                prev = curr
                curr = curr.next
            } else if (lastLeft.next == curr) {
                lastLeft = lastLeft.next!!
                prev = prev.next!!
                curr = curr.next
            } else {
                val temp = lastLeft.next!!
                val temp2 = curr.next

                lastLeft.next = curr
                lastLeft = curr
                lastLeft.next = temp

                prev.next = temp2
                curr = temp2
            }
        }

        return dummy.next
    }
}

fun main() {
    val head = ListNode(1)
    val node2 = ListNode(2)
    head.next = node2
    val result = PartitionList().partition(head, 2)
//
//    val head = ListNode(1)
//    val node2 = ListNode(4)
//    val node3 = ListNode(3)
//    val node4 = ListNode(2)
//    val node5 = ListNode(5)
//    val node6 = ListNode(2)
//    head.next = node2
//    node2.next = node3
//    node3.next = node4
//    node4.next = node5
//    node5.next = node6
//
//    val result = PartitionList().partition(head, 3)
    var curr = result
    while (curr != null) {
        print("${curr.`val`} ")
        curr = curr.next
    }
    println()
}