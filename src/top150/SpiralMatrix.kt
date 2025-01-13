package top150

/**
 * 54. Spiral Matrix
 * 방향을 1,2,3,4로 정의하고 1로 초기화한다.
 * 1인 경우 오른쪽으로 쭉간다.
 * 2인 경우 아래로 쭉간다.
 * 3인 경우 왼쪽으로 쭉간다.
 * 4인 경우 위로 쭉간다.
 * 이미 처리된 칸을 만나거나 벽을 만나면 방향을 업데이트한다.
 * 모든 칸이 방문되면 리턴한다.
 */
class SpiralMatrix {

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val result = mutableListOf<Int>()
        val visited = mutableSetOf<Pair<Int, Int>>()
        var direction = 1
        var i = 0
        var j = 0

        val round = matrix.size * matrix[0].size
        while (result.size < round) {
            result.add(matrix[i][j])
            visited.add(Pair(i, j))
            when (direction) {
                1 -> {
                    if (j + 1 < matrix[0].size && !visited.contains(Pair(i, j+1))) {
                        j++
                    } else {
                        direction = 2
                        i++
                    }
                }
                2 -> {
                    if (i + 1 < matrix.size && !visited.contains(Pair(i+1, j))) {
                        i++
                    } else {
                        direction = 3
                        j--
                    }
                }
                3 -> {
                    if (j - 1 >= 0 && !visited.contains(Pair(i, j-1))) {
                        j--
                    } else {
                        direction = 4
                        i--
                    }
                }
                else -> {
                    if (i - 1 >= 0 && !visited.contains(Pair(i-1, j))) {
                        i--
                    } else {
                        direction = 1
                        j++
                    }
                }
            }
        }

        return result
    }
}

fun main() {
    println(
        SpiralMatrix().spiralOrder(
            arrayOf(
                intArrayOf(1,2,3),
                intArrayOf(4,5,6),
                intArrayOf(7,8,9),
            )
        )
    )
}