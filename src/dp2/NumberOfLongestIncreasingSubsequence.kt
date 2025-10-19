package dp2

import kotlin.math.max

/**
 * 673. Number of Longest Increasing Subsequence !!
 * 시간 특정불가 20h 정도 쓴듯. 풀이도 비효율이 있어서 추후 다시 풀어보면 좋겠다.
 * =============================================
 * i,j를 역순으로 순회한다.
 * i < j라면 j위치의 값에서 이어갈수있다.
 * sizeDp[j]가 maxSize 값보다 크면 maxSize를 갱신한다.
 * sizeDp[j]가 maxSize 값과 같다면, valueDp[i] 값에 더해준다.
 *
 * 최종 글로벌 maxSize 값과 동일한 사이즈의 valueDp[i] 값을 모두 더한 값을 반환한다.
 */
class NumberOfLongestIncreasingSubsequence {
    fun findNumberOfLIS(nums: IntArray): Int {
        val valueDp = IntArray(nums.size) { 0 }
        val sizeDp = IntArray(nums.size) { 1 }
        var result = 0
        var max = 0

        for (i in nums.size - 1 downTo 0) {
            var maxSize = 1
            var flag = false

            for (j in i + 1 ..< nums.size) {
                if (nums[i] < nums[j]) {
                    flag = true
                    maxSize = max(maxSize, sizeDp[j])
                }
            }

            for (j in i + 1 ..< nums.size) {
                if (nums[i] < nums[j] && maxSize == sizeDp[j]) {
                    valueDp[i] += valueDp[j]
                }
            }

            if (valueDp[i] == 0) {
                valueDp[i] = 1
            }

            if (flag) {
                maxSize++
            }

            sizeDp[i] = maxSize

            if (maxSize == max) {
                result += valueDp[i]
            } else if (maxSize > max) {
                max = maxSize
                result = valueDp[i]
            }
        }

        return result
    }
}

fun main() {
    println(NumberOfLongestIncreasingSubsequence().findNumberOfLIS(intArrayOf(0,2,1,3,5,4)))
    println(NumberOfLongestIncreasingSubsequence().findNumberOfLIS(intArrayOf(0,-1,3,2,1,6,5,4)))
    println(NumberOfLongestIncreasingSubsequence().findNumberOfLIS(intArrayOf(2,2,2,2,2)))
    println(NumberOfLongestIncreasingSubsequence().findNumberOfLIS(intArrayOf(1,3,5,4,7)))
//    println(NumberOfLongestIncreasingSubsequence().findNumberOfLIS(intArrayOf(3,5,4)))
}