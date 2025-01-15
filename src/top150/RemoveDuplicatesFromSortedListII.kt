package top150

/**
 * 82. Remove Duplicates from Sorted List II
 * curr의 값과 currNext 값이 같으면 제거대상이다.
 * 다른 값이 나올때까지 curr을 갱신한 후 prev.next에 할당한다.
 * curr의 값과 currNext 값이 다르면 prev와 curr을 갱신한다.
 */
class RemoveDuplicatesFromSortedListII {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head

        var prev: ListNode? = dummy
        var curr: ListNode? = head

        while (curr != null) {
            if (curr.`val` == curr.next?.`val`) {
                val target = curr.`val`
                while (curr?.`val` == target) {
                    curr = curr.next
                }
                prev!!.next = curr
            } else {
                prev = curr
                curr = curr.next
            }
        }

        return dummy.next
    }
}

fun main() {
    val head = ListNode(1)
    val node1 = ListNode(2)
    val node2 = ListNode(3)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(4)
    val node6 = ListNode(6)
    head.next = node1
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6

    val result = RemoveDuplicatesFromSortedListII().deleteDuplicates(head)
    var curr = result
    while (curr != null) {
        print("${curr.`val`}")
        curr = curr.next
    }
    println()
}