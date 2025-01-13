package top150

/**
 * 228. Summary Ranges
 * min과 curr을 0번째로 초기화한다.
 * 배열을 순회한다.
 * curr+1과 현재 원소 값이
 * 같으면 curr을 업데이트한다.
 * 다르면 결과에 값을 쓰고 min과 curr을 업데이트한다.
 */
class SummaryRanges {
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.isEmpty()) return emptyList()

        var min = nums[0]
        var curr = nums[0]
        val result = mutableListOf<String>()

        for (i in 1 .. nums.size) {
            if (i == nums.size) {
                if (min == curr) {
                    result.add("$curr")
                } else {
                    result.add("${min}->${curr}")
                }
                break
            }
            if (curr + 1 < nums[i]) {
                if (min == curr) {
                    result.add("$curr")
                } else {
                    result.add("${min}->${curr}")
                }
                min = nums[i]
                curr = nums[i]
            } else {
                curr++
            }
        }

        return result
    }
}

fun main() {
    println(SummaryRanges().summaryRanges(intArrayOf(0,1,2,4,5,7)))
}