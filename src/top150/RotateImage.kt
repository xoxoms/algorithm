package top150

import java.util.*

/**
 * 48. Rotate Image
 * O(N*M) 1h
 * 2차원 배열의 행 갯수를 순회한다.
 * 해당 행의 마지막부터 0번째 행까지 큐에 넣는다.
 * 0이되면 다음 열로 넘어간다.
 * 모든 열이 처리되면 큐에서 꺼내서 순서대로 어레이에 집어넣는다.
 */
class RotateImage {

    fun rotate(matrix: Array<IntArray>): Unit {
        val queue = LinkedList<Int>()
        for (j in matrix[0].indices) {
            for (i in matrix.size - 1 downTo 0) {
                queue.add(matrix[i][j])
            }
        }

        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[0].size) {
                matrix[i][j] = queue.poll()
            }
        }
    }
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
    )
    RotateImage().rotate(matrix)
    matrix.forEach { item -> item.forEach { print("$it ") } }
    println()
}