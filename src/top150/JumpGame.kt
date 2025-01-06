package top150

import java.util.*

/**
 * 55. Jump Game
 */
class JumpGame {
    /**
     * Greedy
     * 마지막 원소를 goal로 선언한다.
     * 마지막 - 1부터 첫번째까지 루핑한다.
     * 현재위치에서 최대 점프값을 더했을때 골보다 같거나 크면, 골을 현재 값으로 갱신한다.
     * 0번째가 골이되면 true를 응답한다.
     */
    fun canJump(nums: IntArray): Boolean {
        var goal = nums.size - 1
        for (i in nums.size - 2 downTo 0) {
            if (i + nums[i] >= goal) {
                goal = i
            }
        }

        return goal == 0
    }

    /**
     * DFS
     * O(2^N) 25m
     * 현재 위치를 받아 이동한 값이 마지막 원소인지 리턴하는 재귀함수를 만든다.
     * 방문검사한다.
     * 이동가능한 경우의 수부터 1까지 반복 수행한다.
     * 재귀 호출 중 true되면 바로 리턴한다.
     */
    fun canJumpDFS(nums: IntArray): Boolean {
        val visited = mutableSetOf<Int>()
        return dfs(nums, 0, visited)
    }

    private fun dfs(nums: IntArray, idx: Int, visited: MutableSet<Int>): Boolean {
        if (idx >= nums.size - 1) { return true }

        for (i in nums[idx] downTo 1) {
            val value = idx + 1
            if (visited.contains(value)) {
                continue
            } else {
                visited.add(value)
            }
            val result = dfs(nums, idx + i, visited)
            if (result) {
                return true
            }
        }

        return false
    }

    /**
     * BFS
     * O(N^2) 9m
     * 방문확인/기록한다.
     * 마지막 원소에 도달하면 리턴한다.
     * 현재 위치에서 갈수있는 곳을 전부 큐에 넣는다.
     */
    fun canJumpBFS(nums: IntArray): Boolean {
        val queue = LinkedList<Int>()
        val visited = mutableSetOf<Int>()
        queue.add(0)

        while (queue.isNotEmpty()) {
            val polls = mutableListOf<Int>()
            while (queue.isNotEmpty()) {
                val polled = queue.poll()
                if (polled == nums.size - 1) {
                    return true
                }

                polls.add(polled)
            }

            for (polled in polls) {
                for (i in 1 .. nums[polled]) {
                    val value = i + polled
                    if (value > nums.size - 1 || visited.contains(value)) {
                        continue
                    } else {
                        visited.add(value)
                    }

                    queue.add(value)
                }
            }
        }

        return false
    }
}

fun main() {
//    println(JumpGame().canJump(intArrayOf(2, 5, 0, 0)))
//    println(JumpGame().canJump(intArrayOf(2, 0, 0)))
    println(JumpGame().canJump(intArrayOf(2, 3, 1, 1, 4)))
//    println(JumpGame().canJump(intArrayOf(3, 2, 1, 0, 4)))
}