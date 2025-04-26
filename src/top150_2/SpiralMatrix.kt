package top150_2

/**
 * 54. Spiral Matrix
 * 45m
 * 방문처리로 처리하면 좀더 쉬웠을거같지만 공간복잡도를 작게 풀기위해 while문으로만 해결함.
 * 값 대입해보는 것이 어려워서이지, 방향성을 떠오르는데는 크게 어렵지는 않았다.
 * ============================
 * 한바퀴돌때마다 증가되는 round 값과 다음값을 활용하요 i,j 위치를 미리 계산한다.
 */
class SpiralMatrix {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val result = mutableListOf<Int>()
        var round = 0
        var direction = 1

        var i = 0
        var j = 0
        val goal = matrix.size * matrix[0].size
        while (result.size < goal) {
            result.add(matrix[i][j])
            if (direction == 1) {
                if (j + 1 >= matrix[0].size - round) {
                    i++
                    direction = 2
                } else {
                    j++
                }
            } else if (direction == 2) {
                if (i + 1 >= matrix.size - round) {
                    j--
                    direction = 3
                } else {
                    i++
                }
            } else if (direction == 3) {
                if (j - 1 < 0 + round) {
                    i--
                    direction = 4
                } else {
                    j--
                }
            } else {
                if (i - 1 < 1 + round) {
                    j++
                    direction = 1
                    round++
                } else {
                    i--
                }
            }
        }

        return result
    }
}