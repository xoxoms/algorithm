class SpiralMatrix {

    fun test(matrix: Array<IntArray>): List<Int> {
        var i = 0
        var j = -1
        val result = mutableListOf<Int>()
        var direction = 0
        val maxSize = matrix.size * matrix[0].size

        while (true) {
            if (result.size == maxSize) {
                break
            }

            val round = direction / 4
            val d = direction % 4
            val increase = if (d < 2) 1 else -1

            if (d == 3 && i - 1 == round) {
                direction++
                continue
            }

            if (direction % 2 == 0) {
                if (j + increase < 0 + round || j + increase == matrix[0].size - round) {
                    direction++
                    continue
                } else {
                    j += increase
                }
            } else {
                if (i + increase < 0 + round || i + increase == matrix.size - round) {
                    direction++
                    continue
                } else {
                    i += increase
                }
            }

            result.add(matrix[i][j])
        }

        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpiralMatrix().test(
                arrayOf(
                    intArrayOf(1,2,3),
                    intArrayOf(4,5,6),
                    intArrayOf(7,8,9)
                )
            )
//            SpiralMatrix().test(
//                arrayOf(
//                    intArrayOf(1,2,3,4),
//                    intArrayOf(5,6,7,8),
//                    intArrayOf(9,10,11,12)
//                )
//            )
        }
    }
}