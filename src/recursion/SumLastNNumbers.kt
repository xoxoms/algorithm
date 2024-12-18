package recursion

class SumLastNNumbers {
    fun test(array: IntArray, n: Int): Int {
        val i = array.size - n
        if (i == array.size) { return 0 }
        return array[i] + test(array, n - 1)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(SumLastNNumbers().test(intArrayOf(1, -2, 3, 4, -5), 3))
            println(SumLastNNumbers().test(intArrayOf(5,5,5,5), 3))
            println(SumLastNNumbers().test(intArrayOf(1,8,2,5), 3))
        }
    }
}