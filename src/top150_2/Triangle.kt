package top150_2

/**
 * 120. Triangle
 * DP로 풀어야하는데 그렇지 못했다.
 * ================
 *
 * 현재 인덱스, 다음 인덱스 결과값을 받아서 방문 처리한다.
 * 현재값과 recursive한 값을 더한 후 리턴한다
 */
class Triangle {
    private val visited = mutableMapOf<Pair<Int, Int>, Int>()

    fun minimumTotal(triangle: List<List<Int>>): Int {
        return recursive(triangle, 0, 0)
    }

    private fun recursive(triangle: List<List<Int>>, i: Int, j: Int): Int {
        if (visited.contains(Pair(i, j))) {
            return visited[Pair(i, j)]!!
        }
        if (triangle.size == i) {
            return 0
        }

        val left = recursive(triangle, i + 1, j)
        val right = recursive(triangle, i + 1, j + 1)
        visited[Pair(i + 1, j)] = left
        visited[Pair(i + 1, j + 1)] = right

        return if (left < right) {
            left
        } else {
            right
        } + triangle[i][j]
    }
}