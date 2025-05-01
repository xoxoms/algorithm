package top150_2

import kotlin.math.min

/**
 * 452. Minimum Number of Arrows to Burst Balloons !!
 * 2h
 * 돌아보면 쉬운거같긴한데...해결방법을 오래고민했다.
 * =================================
 * 배열을 x 시작점순으로 정렬한다.
 * 배열을 루핑한다.
 * 이전 endX 값보다 x 시작값이 크면 새로운 시작이다. 결과 값을++한다.
 * 이전 endX 값보다 x 시작값이 작거나 같으면 함께 처리될수있다. endX 값만 갱신한다.
 * 루프가 마무리되면 result 반환한다.
 */
class MinimumNumberOfArrowsToBurstBalloons {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        // ------
        //   --------
        //           ------
        //        ------------
        points.sortBy { it[0] }

        var i = 1
        var result = 1
        var endX = points[0][1]
        while (i < points.size) {
            if (endX < points[i][0]) {
                result++
                endX = points[i][1]
            } else {
                endX = min(points[i][1], endX)
            }
            i++
        }

        return result
    }
}

fun main() {
    println(MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(
        arrayOf(
            intArrayOf(9,12),
            intArrayOf(1,10),
            intArrayOf(4,11),
            intArrayOf(8,12),
            intArrayOf(3,9),
            intArrayOf(6,9),
            intArrayOf(6,7),
        )
    ))
}