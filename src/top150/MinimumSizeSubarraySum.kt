package top150

import kotlin.math.min

/**
 * 209. Minimum Size Subarray Sum !!
 */
class MinimumSizeSubarraySum {

    /**
     * SlidingWindow
     * L과 R을 초기화한다.
     * L부터 R의합이 target과 같거나 클때까지 R을 늘린다.
     * size를 기록한다.
     * L을 쉬프트한다.
     * target과비교한다.
     * target보다 작으면 R을 쉬프트한다.
     * target과 같거나 크면 기록한다.
     * 반복한다.
     */
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var l = 0
        var total = 0
        var result = Int.MAX_VALUE

        for (r in nums.indices) {
            total += nums[r]
            while (total >= target) {
                result = min(result, r - l + 1)
                total -= nums[l]
                l++
            }
        }

        return result
    }

    /**
     * 배열사이즈와 동일한 슬롯을 만든다.
     * 원본 배열 사이즈만큼 반복한다.
     * 각 라운드마다 원소 수만큼 반복한다.
     * 현재 원소 + round의 값을 슬롯에 넣는다.
     * 슬롯 값이 target보다 같거나 크면 라운드를 리턴한다.
     */
    fun minSubArrayLenBruteForce(target: Int, nums: IntArray): Int {
        val arr = IntArray(nums.size) { 0 }

        for (round in 0 .. nums.size) {
            for (j in 0..< nums.size - round) {
                arr[j] = arr[j] + nums[j + round]
                if (arr[j] >= target) {
                    return round + 1
                }
            }
        }

        return 0
    }
}

fun main() {
    println(MinimumSizeSubarraySum().minSubArrayLen(7, intArrayOf(2,3,1,2,4,3)))
    println(MinimumSizeSubarraySum().minSubArrayLen(213, intArrayOf(12,28,83,4,25,26,25,2,25,25,25,12)))
}