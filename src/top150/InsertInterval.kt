package top150

import kotlin.math.max
import kotlin.math.min

/**
 * 57. Insert Interval !!
 */
class InsertInterval {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        if (intervals.isEmpty()) return arrayOf(newInterval)

        val result = mutableListOf<IntArray>()
        var target = newInterval
        var i = 0
        while (i < intervals.size) {
            val interval = intervals[i]
            if (target[1] < interval[0]) {
                result.add(target)
                result.addAll(intervals.takeLast(intervals.size - i))
                return result.toTypedArray()
            } else if (interval[1] < target[0]) {
                result.add(interval)
            } else {
                target = intArrayOf(
                    min(interval[0], target[0]),
                    max(interval[1], target[1]),
                )
            }
            i++
        }

        result.add(target)
        return result.toTypedArray()
    }
}

fun main() {
    InsertInterval().insert(
        arrayOf(
            intArrayOf(1,5),
        ),
        intArrayOf(2,3)
//        arrayOf(
//            intArrayOf(1,3),
//            intArrayOf(6,9),
//        ),
//        intArrayOf(2,5)
//        arrayOf(
//            intArrayOf(1,2),
//            intArrayOf(3,5),
//            intArrayOf(6,7),
//            intArrayOf(8,10),
//            intArrayOf(12,16),
//        ),
//        intArrayOf(4,8)
    ).forEach { print("${it[0]} ${it[1]},") }
}