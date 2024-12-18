package recursion

class SumOfMatrix {
    fun test(a: Array<IntArray>, b: Array<IntArray>, index: Int = 0) {
        val idx = index % a[0].size
        val jdx = index / a[0].size
        if (index >= a[0].size * 2) {
            for (i in a.indices) {
                for (j in a[0].indices) {
                    print("${a[i][j]} ")
                }
                println()
            }
            return
        }

        a[jdx][idx] += b[jdx][idx]
        test(a, b, index + 1)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                SumOfMatrix().test(
                    arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)),
                    arrayOf(intArrayOf(1, 3, 5), intArrayOf(7, 9, 11)),
                )
            )
        }
    }
}