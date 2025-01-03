package bfs

import java.util.*

/**
 * 417. Pacific Atlantic Water Flow
 * 2차원 배열을 순회하여 셀 하나씩 아래 로직을 수행한다.
 * 현재 셀보다 낮은 값을 갖는 동서남북 셀을 큐에 넣는다.
 * 큐를 전부 폴링한다.
 * 태평양과 대서양 각각 변수를 업데이트한다.
 * 둘다 true라면 결과에 넣고 루프를 빠져나온다.
 */
class PacificAtlanticWaterFlow {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val queue = LinkedList<Pair<Int, Int>>()
        val result = mutableListOf<List<Int>>()

        for (i in heights.indices) {
            for (j in heights[0].indices) {
                val visited = mutableSetOf<Pair<Int, Int>>()
                queue.add(i to j)
                var condition1 = false
                var condition2 = false

                while (queue.isNotEmpty()) {
                    val polled = queue.poll()
                    if (visited.contains(polled)) {
                        continue
                    } else {
                        visited.add(polled)
                    }

                    if (polled.first == 0 || polled.second == 0) {
                        condition1 = true
                    }
                    if (polled.first == heights.size - 1 || polled.second == heights[0].size - 1) {
                        condition2 = true
                    }

                    val current = heights[polled.first][polled.second]
                    if (polled.first - 1 >= 0 && current >= heights[polled.first - 1][polled.second]) {
                        queue.add(polled.first - 1 to polled.second)
                    }
                    if (polled.first + 1 < heights.size && current >= heights[polled.first + 1][polled.second]) {
                        queue.add(polled.first + 1 to polled.second)
                    }
                    if (polled.second - 1 >= 0 && current >= heights[polled.first][polled.second - 1]) {
                        queue.add(polled.first to polled.second - 1)
                    }
                    if (polled.second + 1 < heights[0].size && current >= heights[polled.first][polled.second + 1]) {
                        queue.add(polled.first to polled.second + 1)
                    }
                }

                if (condition1 && condition2) {
                    result.add(listOf(i, j))
                }
            }
        }

        return result
    }
}

fun main() {
    val result = PacificAtlanticWaterFlow().pacificAtlantic(
//        heights = arrayOf(
//            intArrayOf(1, 2, 2, 3, 5),
//            intArrayOf(3, 2, 3, 4, 4),
//            intArrayOf(2, 4, 5, 3, 1),
//            intArrayOf(6, 7, 1, 4, 5),
//            intArrayOf(5, 1, 1, 2, 4),
//        )
//        heights = arrayOf(
//            intArrayOf(1),
//        )
//        heights = arrayOf(
//            intArrayOf(10, 10, 10),
//            intArrayOf(10, 1, 10),
//            intArrayOf(10, 10, 10),
//        )
        heights = arrayOf(
            intArrayOf(19,16,16,12,14,0,17,11,2,0,18,9,13,16,8,8,8,13,17,9,16,9,4,7,1,19,10,7,0,15),
            intArrayOf(0,11,4,14,9,0,6,13,16,5,19,9,4,5,4,12,0,13,0,7,9,12,13,15,3,7,4,9,15,1),
            intArrayOf(13,14,12,12,12,16,6,15,13,1,8,9,11,14,14,10,19,11,10,0,5,18,4,12,7,13,17,15,18,1),
            intArrayOf(16,14,19,5,8,2,11,17,7,1,4,6,5,18,7,15,6,19,18,12,1,14,2,2,0,9,15,14,13,19),
            intArrayOf(17,4,12,9,12,10,12,10,4,5,12,7,2,12,18,10,10,8,6,1,5,13,10,3,5,3,11,4,8,11),
            intArrayOf(8,19,18,9,6,2,7,3,19,6,0,17,9,12,11,1,15,11,18,1,8,11,1,11,16,7,8,17,15,0),
            intArrayOf(7,0,5,11,1,7,12,18,12,1,5,2,11,7,18,12,0,11,9,18,5,2,3,1,1,1,8,14,19,5),
            intArrayOf(2,14,2,16,17,19,10,16,1,16,16,3,19,12,13,17,19,12,16,10,16,8,16,12,6,12,13,17,9,12),
            intArrayOf(8,1,10,5,7,0,15,19,8,15,4,12,18,18,13,11,5,2,8,3,15,4,3,7,7,14,15,11,6,16),
            intArrayOf(0,5,13,19,1,1,2,4,16,2,16,9,15,15,10,10,18,11,17,1,5,14,5,19,7,0,13,7,13,7),
            intArrayOf(11,6,16,12,4,2,9,11,17,19,12,10,6,16,17,5,1,18,19,7,15,1,14,0,3,19,7,3,4,13),
            intArrayOf(4,11,8,10,10,19,7,18,4,2,2,14,6,9,18,14,2,16,5,3,19,17,4,3,7,1,12,2,4,3),
            intArrayOf(14,16,3,11,13,13,6,16,18,0,17,19,4,1,14,12,4,17,5,19,8,13,15,3,15,4,1,14,12,10),
            intArrayOf(13,2,12,2,16,12,19,10,19,12,19,14,12,17,16,3,13,7,3,15,16,7,10,15,14,10,6,5,2,18),
        )
    )

    println(result)
}