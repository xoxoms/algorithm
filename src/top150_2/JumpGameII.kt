package top150_2

import java.util.LinkedList

/**
 * 45. Jump Game II
 * BFS로 풀어봤다.
 * 현재 번째에서 갈수있는 모든 곳을 큐에넣는다.
 * 큐에서 꺼낸 값이 마지막 인덱스면 리턴한다.
 */
class JumpGameII {
    fun jump(nums: IntArray): Int {
        val visited = mutableSetOf<Int>()
        val queue = LinkedList<Int>()
        queue.add(0)
        var result = 0

        while (true) {
            val polls = mutableListOf<Int>()
            while (queue.isNotEmpty()) {
                val polled = queue.poll()
                if (polled >= nums.size - 1) {
                    return result
                }

                polls.add(polled)
            }

            polls.forEach {
                for (i in 1 .. nums[it]) {
                    if (!visited.contains(it + i)) {
                        visited.add(it + i)
                        queue.add(it + i)
                    }
                }
            }
            result++
        }
    }
}