package top150_2

import kotlin.math.max

/**
 * 56. Merge Intervals
 * 1h30m
 * 처음에 문제파악을 잘못했다.
 * ======================
 * [0] 번째 인덱스 값으로 정렬한다.
 * 이전값과 현재값이 겹치지 않으면 이전 값을 결과에 넣는다.
 * 겹치면 현재 index 값을 업데이트한다.
 * 와일문이 종료되면 마지막 값을 결과에 넣어준다.
 */
class MergeIntervals {

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        intervals.sortBy { it[0] }

        var i = 1
        while (i < intervals.size) {
            val prev = intervals[i - 1]
            val current = intervals[i]
            if (prev[1] < current[0]) {
                result.add(prev)
            } else {
                intervals[i][0] = prev[0]
                intervals[i][1] = max(prev[1], current[1])
            }
            i++
        }

        result.add(intervals[i - 1])
        return result.toTypedArray()
    }
}

fun main() {
    val result = MergeIntervals().merge(
        arrayOf(
            intArrayOf(1,3),
            intArrayOf(2,6),
            intArrayOf(8,10),
            intArrayOf(15,18)
        )
    )

    println(result)
}