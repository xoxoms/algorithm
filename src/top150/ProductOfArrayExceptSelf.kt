package top150

import java.util.*

/**
 * 238. Product of Array Except Self
 */
class ProductOfArrayExceptSelf {

    /**
     * nums를 두번 순회한다.
     * 첫회차에서는 현재 원소에 이전까지의 곱한합을 할당한다.
     * 0번째의 경우 이전 값을 1로 초기화 후 저장한다.
     * 1번째의 경우 0번째 * 이전 값이 저장된다.
     * 2번째의 경우 1번째 * 이전 값이 저장된다.
     * 3번째의 경우 2번째 * 이전 값이 저장된다.
     *
     * 두번째 회차는 뒤에서부터 시작한다.
     * 현재 원소에 이전까지 곱한 값을 현재원소에 곱한다.
     * 3번째의 경우 3번째 값 * 1이 저장된다.
     * 2번째의 경우 2번째 값 * 3번째 값이 저장된다.
     * 1번째의 경우 1번째 값 * 2번째 값이 저장된다.
     * 0번재의 경우 0번째 값 * 1번째 값이 저장된다.
     *
     * 결과를 반환한다.
     */
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)

        var pre = 1
        for (i in 0 until nums.size) {
            result[i] = pre
            pre *= nums[i]
        }

        var post = 1
        for (i in nums.size - 1 downTo 0) {
            result[i] *= post
            post *= nums[i]
        }

        return result
    }

    /**
     * 배열 순회하며 곱한값을 임시저장한다.
     * 0이 있다면 기록해둔다.
     * 0이 두개면 0을 응답한다.
     * 그 외, 전부 곱한 값 / 자기자신으로 값을 채우고 리턴한다.
     */
    fun productExceptSelfWithDivide(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 0 }
        var value: Int? = null
        val queue = LinkedList<Int>()
        for (i in 0 until nums.size) {
            if (nums[i] == 0) {
                queue.add(i)
                continue
            }
            value = (value ?: 1) * nums[i]
        }

        if (value == null) {
            value = 0
        }

        if (queue.size > 1) {
            return result
        } else if (queue.isNotEmpty()) {
            for (idx in queue) { result[idx] = value }
        } else {
            for (i in 0 until nums.size) {
                result[i] = value / nums[i]
            }
        }

        return result
    }
}

fun main() {
    ProductOfArrayExceptSelf().productExceptSelf(nums = intArrayOf(1, 2, 3, 4)).forEach { print("$it ") }
    println()
    ProductOfArrayExceptSelf().productExceptSelf(nums = intArrayOf(0, 4, 0)).forEach { print("$it ") }
}