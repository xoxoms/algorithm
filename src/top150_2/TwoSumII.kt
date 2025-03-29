package top150_2

/**
 * 167. Two Sum II - Input Array Is Sorted
 * 투포인터로 해결한다.
 * 양쪽에 i, j를 초기화하고, 합에 따라 i와 j를 가감한다.
 */
class TwoSumII {
    class Solution {
        fun twoSum(numbers: IntArray, target: Int): IntArray {
            var i = 0
            var j = numbers.size -1

            while (true) {
                var sum = numbers[i] + numbers[j]
                if (sum > target) {
                    j--
                } else if (sum < target) {
                    i++
                } else {
                    return intArrayOf(i + 1, j + 1)
                }
            }
        }
    }
}