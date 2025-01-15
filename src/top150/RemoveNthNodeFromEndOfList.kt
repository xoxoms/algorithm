package top150

/**
 * 19. Remove Nth Node From End of List
 */
class RemoveNthNodeFromEndOfList {

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        val nodeList = mutableListOf<ListNode>()
        var current: ListNode? = dummy
        while (current != null) {
            nodeList.add(current)
            current = current.next
        }
        nodeList[nodeList.size - n - 1].next = nodeList[nodeList.size - n].next
        // nodeList = [0,1,2,3,4,5], size = 6
        // 6 - 2 - 1 = 3 => nodeList[3].next = nodeList[4].next
        // nodeList[3].next = 5

        // nodeList = [0,1], n = 1, size = 2
        // 2 - 1 - 1 = 0 => nodeList[0].next = nodeList[2 - 1].next
        // nodeList[0].next = null
        return dummy.next
    }
}

fun main() {
    val head = ListNode(1)
    val node1 = ListNode(2)
    val node2 = ListNode(3)
    val node3 = ListNode(4)
    val node4 = ListNode(5)
    head.next = node1
    node1.next = node2
    node2.next = node3
    node3.next = node4

    RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 2)
}