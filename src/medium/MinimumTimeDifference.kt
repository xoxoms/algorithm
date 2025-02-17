package medium

import java.time.LocalTime
import java.time.format.DateTimeFormatter
import kotlin.math.abs

/**
 * 539. Minimum Time Difference
 * 시간분으로 변환한다.
 * 오름차순 배열에 넣는다.
 * 순회하며 결과값을 갱신한다.
 */
class MinimumTimeDifference {

    fun findMinDifference(timePoints: List<String>): Int {
        if (timePoints.size < 2) { return 0 }

        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        val times = timePoints.map { LocalTime.parse(it, formatter) }.sorted()

        var result = abs((times.last().toSecondOfDay() - (60*60*24 + times.first().toSecondOfDay())))
        for (i in 0 ..< times.size - 1) {
            val diff = times[i + 1].toSecondOfDay() - times[i].toSecondOfDay()
            if (diff < result) {
                result = diff
            }
        }

        return result / 60
    }
}

fun main() {
    println(MinimumTimeDifference().findMinDifference(listOf("00:00","23:59")))
    println(MinimumTimeDifference().findMinDifference(listOf("00:00","23:59","00:00")))
}