package medium

/**
 * 2829. Determine the Minimum Sum of a k-avoiding Array
 * 결과처리할 리스트의 사이즈와 n이 같을때까지 루핑한다.
 * 제외 셋에 현재값 - k를 넣는다.
 * i가 셋에 포함됐으면 건너뛴다.
 * 합을 리턴한다.
 */
class DetermineTheMinimumSumOfAKAvoidingArray {
    fun minimumSum(n: Int, k: Int): Int {
        val result = mutableListOf<Int>()
        val avoid = mutableSetOf<Int>()

        var i = 1
        while (result.size < n) {
            if (!avoid.contains(i)) {
                if (i < k) {
                    avoid.add(k - i)
                }
                result.add(i)
            }
            i++
        }

        return result.sum()
    }
}

fun main() {
    println(DetermineTheMinimumSumOfAKAvoidingArray().minimumSum(5, 4))
}