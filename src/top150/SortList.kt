package top150

/**
 * 148. Sort List !!
 * 머지소트로 해결한다.
 * next 값이 null일때까지 sort를 재귀호출한다.
 * null이되면 현재 값을 반환한다.
 * 위동작으로 left, right 시작 헤더를 구할수있다.
 * left와 right 값을 비교하여 tail.next에 대입한다.
 * return을 위해 dummy 선언도 해야한다.
 *
 * right는 slow-fast 알고리즘으로 구할수있다.
 */
class SortList {

    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) { return head }
        return sort(head)
    }

    private fun sort(head: ListNode): ListNode {
        if (head.next == null) { return head }
        val rightNode = getRight(head)

        var left: ListNode? = sort(head)
        var right: ListNode? = sort(rightNode)

        val dummy = ListNode(0)
        var tail = dummy

        while (left != null || right != null) {
            if (left == null) {
                tail.next = right
                right = right!!.next
            } else if (right == null) {
                tail.next = left
                left = left.next
            } else {
                if (left.`val` > right.`val`) {
                    tail.next = right
                    right = right.next
                } else {
                    tail.next = left
                    left = left.next
                }
            }

            tail = tail.next!!
        }

        return dummy.next!!
    }

    private fun getRight(head: ListNode): ListNode {
        var slow = head
        var fast = head.next!!

        while (fast.next?.next != null) {
            slow = slow.next!!
            fast = fast.next!!.next!!
        }

        val result = slow.next!!
        slow.next = null

        return result
    }
}

fun main() {
    val root = ListNode(4)
    val node1 = ListNode(2)
    val node2 = ListNode(1)
    val node3 = ListNode(3)
    root.next = node1
    node1.next = node2
    node2.next = node3

    val result = SortList().sortList(root)
    println(result!!.`val`)
}