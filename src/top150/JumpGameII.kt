package top150

import kotlin.math.max
import kotlin.math.min

/**
 * 45. Jump Game II
 */
class JumpGameII {
    /**
     * Sliding window
     * 슬라이딩 윈도우로 해결할수있다.
     * 처음 윈도우 사이즈는 0으로 초기화한다.
     * l과 r을 순회하여 가장 먼 값을 r에 넣어준다.
     * l은 r+1 값을 넣어준다.
     * 점프카운트를 증가시킨다.
     * r이 배열 마지막값인덱스보다 커지면 루프를 탈출하고 결과를 반환한다.
     *
     * 문제에서 끝에 도달하지 못하는 경우가 없는 것을 보장하기때문에 while문 탈출 조건을 본문과 같이 할수 있다.
     */
    fun jump(nums: IntArray): Int {
        var l = 0
        var r = 0
        var result = 0

        while (r < nums.size - 1) {
            var farthest = 0
            for (i in l .. r) {
                farthest = max(farthest, nums[i] + i)
            }

            l = r + 1
            r = farthest
            result++
        }

        return result
    }

    /**
     * DFS
     * 1h
     * 현재 인덱스를 인자로 받고 1을 응답하는 재귀함수를 만든다.
     * 만약 마지막원소에 닿을수없다면 0을 리턴한다.
     */
    private val memoization = mutableMapOf<Int, Int>()
    fun jumpDFS(nums: IntArray): Int {
        if (nums.size == 1) { return 0 }
        return dfs(nums, 0)
    }

    private fun dfs(nums: IntArray, current: Int): Int {
        if (memoization.contains(current)) {
            return memoization[current]!!
        }

        var min = Int.MAX_VALUE
        for (i in 1 .. nums[current]) {
            val result = (if (current + i >= nums.size - 1) {
                0
            } else {
                dfs(nums, current + i)
            }) + 1

            if (result > 0) {
                min = min(min, result)
            }
        }

        memoization[current] = min
        return min
    }
}

fun main() {
    println(JumpGameII().jump(intArrayOf(1, 1, 1, 1)))
//    println(JumpGameII().jump(intArrayOf(1, 2)))
//    println(JumpGameII().jump(intArrayOf(2, 3, 1, 1, 4)))
//    println(JumpGameII().jump(intArrayOf(2, 0, 0, 0)))
}