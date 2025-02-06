package top150

/**
 * 74. Search a 2D Matrix
 * 0번째를 순회한다.
 * target > [i][0]이면 i를 갱신한다.
 * [i]가 fix되면 j를 찾는다.
 * [j]는 정렬되어있기 때문에 바이너리 서치로 진행한다.
 */
class SearchA2DMatrix {
    private lateinit var search: (Int, Int) -> Boolean

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.first().first() > target) { return false }
        if (matrix.last().last() < target) { return false }

        var i = 0
        while (i < matrix.size - 1) {
            if (matrix[i + 1][0] > target) { break }
            i++
        }

        search = { left: Int, right: Int ->
            val mid = (left + right) / 2
            if (left >= right && matrix[i][left] != target) {
                false
            } else if (matrix[i][mid] == target) {
                true
            } else if (matrix[i][mid] < target) {
                search(mid + 1, right)
            } else {
                search(left, mid - 1)
            }
        }

        return search(0, matrix[0].size - 1)
    }
}

fun main() {
    println(
        SearchA2DMatrix().searchMatrix(
            arrayOf(intArrayOf(1,3,5,7)),
            3,
        )
    )

    println(
        SearchA2DMatrix().searchMatrix(
            arrayOf(
                intArrayOf(1,3,5,7),
                intArrayOf(10,11,16,20),
                intArrayOf(23,30,34,60),
            ),
            13,
        )
    )
}