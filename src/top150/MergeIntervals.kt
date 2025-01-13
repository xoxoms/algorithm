package top150

import java.util.*
import kotlin.math.max
import kotlin.math.min

/**
 * 56. Merge Intervals
 */
class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortWith { o1, o2 -> o1[0] - o2[0] }
        val result = LinkedList<IntArray>()
        var min = intervals[0][0]
        var max = intervals[0][1]

        var cursor = 1
        while (cursor < intervals.size) {
            val current = intervals[cursor]
            if ((current[0] in min..max) || (max in current[0] .. current[1])) {
                min = min(min, current[0])
                max = max(max, current[1])
            } else {
                result.add(intArrayOf(min, max))
                min = current[0]
                max = current[1]
            }
            cursor++
        }

        result.add(intArrayOf(min, max))

        return result.toTypedArray()
    }
}

fun main() {
    val result = MergeIntervals().merge(
        arrayOf(
            intArrayOf(1,3),
            intArrayOf(2,6),
            intArrayOf(8,10),
            intArrayOf(15,18),
        )
    )

    for (item in result) {
        for (it in item) {
            print("$it ")
        }
    }
    println()
}