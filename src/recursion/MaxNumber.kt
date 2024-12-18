package recursion

import kotlin.math.max

class MaxNumber {
    fun test(array: IntArray, index: Int): Int {
        if (index > array.size - 1) {
            return 0
        }
        return max(array[index], test(array, index + 1))
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MaxNumber().test(intArrayOf(1, -2, 3, 4, -5), 0))
        }
    }
}