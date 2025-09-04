package dp2

import kotlin.math.min

/**
 * 120. Triangle !!
 * 1h 15m
 * 지피티가 비효율이 있긴한 풀이라고 했다.
 * 점차 로우를 내려갈수록 커지기 때문에 2차원 배열이 필요없다.
 * =============
 */
class Triangle {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val list = mutableListOf<IntArray>()
        list.add(IntArray(1) { triangle[0][0] })

        for (i in 1 ..< triangle.size) {
            list.add(IntArray(i + 1) { Int.MAX_VALUE })
            for (j in 0 ..< i) {
                list[i][j] = min(
                    list[i][j],
                    triangle[i][j] + list[i - 1][j]
                )
                list[i][j + 1] = triangle[i][j + 1] + list[i - 1][j]
            }
        }

        return list[triangle.size - 1].min()
    }
}