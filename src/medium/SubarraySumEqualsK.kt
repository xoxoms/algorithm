package medium

/**
 * 560. Subarray Sum Equals K !!
 * 이전까지의 더한값을 저장하는 prefixSumMap을 사용한다.
 * 0번째는 이전까지 값이 없으므로 map에 0을 키로 1을 초기화해서 사용한다.
 * 현재 값 - k가 prefixSumMap의 갯수만큼 result 값을 증가시켜준다.
 * ==========================
 * 브루트포스로 해결한다.
 * 0번째부터 순회한다.
 * 현재값이 k보다 작다면 j를 늘린다.
 * k와 같으면 result++
 * k보다 크면 i++한다.
 */
class SubarraySumEqualsK {


    fun subarraySum(nums: IntArray, k: Int): Int {
        val prefixSumMap = mutableMapOf<Int, Int>()
        prefixSumMap[0] = 1

        var result = 0
        var currentSum = 0
        for (i in 0 ..< nums.size) {
            currentSum += nums[i]
            val diff = currentSum - k
            prefixSumMap[diff]?.let { result += it }
            prefixSumMap[currentSum] = (prefixSumMap[currentSum] ?: 0) + 1
        }

        return result
    }

    fun subarraySumBruteForce(nums: IntArray, k: Int): Int {
        var result = 0

        for (i in 0 ..< nums.size) {
            var sum = 0
            for (j in i ..< nums.size) {
                sum += nums[j]
                if (sum == k) {
                    result++
                }
            }
        }

        return result
    }
}

fun main() {
    println(SubarraySumEqualsK().subarraySum(intArrayOf(1,-1,0), 0))
    println(SubarraySumEqualsK().subarraySum(intArrayOf(-1,-1,1), 0))
    println(SubarraySumEqualsK().subarraySum(intArrayOf(1,2,3), 3))
    println(SubarraySumEqualsK().subarraySum(intArrayOf(1,1,1), 3))
}