package dp2

import kotlin.math.max

/**
 * 646. Maximum Length of Pair Chain !!
 * 3주차에 해결
 * 좋은 해법으로 풀지 못했다.
 * 최초 정렬한 후 이어나가는게 정석인듯
 * ====================================
 * map을 만든다.
 * 모든 원소를 순회한다.
 * 현재 순회하는 원소보다 i번째가 크면, 해당 원소의 map 값 + 1을 사용하여 value를 갱신한다.
 * map에 값이 없다면 해당 index로 assign 함수 재호출한다.
 * 본 루프함수에서 result를 갱신하고 최종 값을 반환한다.
 */
class MaximumLengthOfPairChain {
    val map = mutableMapOf<Int, Int>()

    fun findLongestChain(pairs: Array<IntArray>): Int {
        var result = 0
        for (i in 0 ..< pairs.size) {
            assign(pairs, i)
            result = max(map[i]!!, result)
        }
        return result
    }

    private fun assign(pairs: Array<IntArray>, index: Int) {
        if (map[index] != null) { return }

        var value = 1
        for (i in 0 ..< pairs.size) {
            if (i == index) { continue }

            if (pairs[index][1] < pairs[i][0]) {
                assign(pairs, i)
                value = max(value, map[i]!! + 1)
            }
        }

        map[index] = value
    }
}

fun main() {
    println(
        MaximumLengthOfPairChain().findLongestChain(
            arrayOf(
                intArrayOf(3, 4),
                intArrayOf(2, 3),
                intArrayOf(1, 2),
            )
        )
    )
}