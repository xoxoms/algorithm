package top150

/**
 * 92. Reverse Linked List II !!
 * 3페이즈로 나눈다.
 * 0. 계산 편의를 위해 0번째 더미를 만들고 head와 연결한다.
 * 1. left 값보다 작을때까지 leftPrev를 갱신한다.
 * ㄴ 이를 거치면 leftPrev는 스왑할 대상 직전 값이 저장된다.
 * 2. rifht 값과 같거나 작을때까지 looping한다.
 * ㄴ 이를 거치면 prev에는 마지막 스왑 값이, curr에는 스왑후 다음 값이 저장된다.
 * 3. 값 갱신
 * ㄴ leftPrev.next.next는 스왑전 값의 다음 값인데 이 값에 curr을 넣어줌으로써 스왑 후 첫번째 원소 값을 바라보게 된다.
 * ㄴ leftPrev.next에는 스왑된 첫번째 값을 맵핑해줘야한다. prev를 넣어준다.
 * dummy.next를 반환한다.
 */
class ReverseLinkedListII {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head

        var leftPrev: ListNode? = dummy
        var curr: ListNode? = head

        // loop until i < 1 => [ 0 ]
        for (i in 0..< left - 1) {
            leftPrev = curr
            curr = curr?.next ?: break

            // [0] leftPrev = 0 (dummy), curr = 1 (head)
            // leftPrev = 1 (curr)
            // curr = 2 (curr.next)

            // [1] leftPrev = 1, curr = 2
            // leftPrev = 2 (curr)
            // curr = 3 (curr.next)

            // escape
        }

        // leftPrev = 1
        // curr = 2
        // loop until 4 - 2 + 1 => 0 < 3 => [ 0, 1, 2 ]
        var prev: ListNode? = null
        for (i in 0 ..< right - left + 1) {
            val temp = curr?.next
            curr?.next = prev
            prev = curr
            curr = temp

            // [0] curr = 2, prev = null
            // temp = 3 (curr.next)
            // curr.next = null (prev)
            // prev = 2 (curr)
            // curr = 3 (temp)

            // [1] curr = 3, prev = 2
            // temp = 4 (curr.next)
            // curr.next = 2 (prev)
            // prev = 3 (curr)
            // curr = 4 (temp)

            // [2] curr = 4, prev = 3
            // temp = 5 (curr.next)
            // curr.next = 3 (prev)
            // prev = 4 (curr)
            // curr = 5 (temp)

            // escape
        }

        // 위까지 처리하면, leftPrev에는 스왑 전 첫번째 값 전 값 1이 저장되어있다.
        // prev에는 마지막 스왑한 값 4가 저장되어있고, curr에는 스왑대상 다음 값 right 5가 저장되어있다. => leftPrev = 1, prev = 4, curr = 5
        // leftPrev.next.next에 curr를 넣으면 스왑 전 첫번째 값의 다음을 null에서 스왑 다음 값으로 맵핑할수있다.
        // 즉, leftPrev.next.next에 curr을 넣어주면 => 2.next = 5가 된다.
        // => leftPrev(1).next(2).next = curr(5)
        // leftPrev.next에는 스왑 후 첫번째 값이 된 prev를 넣어준다.
        // => leftPrev(1).next = prev(4)
        leftPrev?.next?.next = curr
        leftPrev?.next = prev

        return dummy.next
    }
}

fun main() {
    val head = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
    head.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    val result = ReverseLinkedListII().reverseBetween(head, 2, 4)

//    val result = ReverseLinkedListII().reverseBetween(head, 2, 4)
//    val head = ListNode(3)
//    val node1 = ListNode(5)
//    head.next = node1
//    val result = ReverseLinkedListII().reverseBetween(head, 1, 2)

//    val head = ListNode(5)
//    val result = ReverseLinkedListII().reverseBetween(head, 1, 1)

    var target = result
    while (target != null) {
        print("${target.`val`},")
        target = target.next
    }
    println()
}