package top150

import java.util.*

/**
 * 26. Remove Duplicates from Sorted Array
 * 배열을 끝까지 순회한다.
 * 현재 값을 큐에넣는다.
 * 다른 값이 나올때까지 다시 순회한다.
 * 배열이 끝나면 큐에 넣은 것을 처음부터 채운다.
 * 큐 사이즈를 응답한다.
 * =================
 * 투포인터로 해결된다.
 */
class RemoveDuplicatesFromSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        var i = 1
        var j = 1

        while (j < nums.size) {
            if (nums[i - 1] != nums[j]) {
                nums[i++] = nums[j]
            }
            j++
        }

        return i
    }

    fun removeDuplicates2(nums: IntArray): Int {
        var prev = -101
        val queue = LinkedList<Int>()
        for (num in nums) {
            if (prev != num) {
                queue.add(num)
                prev = num
            }
        }

        val result = queue.size
        var i = 0
        while (queue.isNotEmpty()) {
            nums[i++] = queue.poll()
        }

        return result
    }
}

fun main() {
    println(
        RemoveDuplicatesFromSortedArray().removeDuplicates(
            intArrayOf(0,0,1,1,1,2,2,3,3,4)
        )
    )
}