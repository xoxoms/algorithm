package recursion

class SumNumber {
    fun test(array: IntArray, index: Int = 0): Int {
        if (index >= array.size) return 0
        return array[index] + test(array, index + 1)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(SumNumber().test(intArrayOf(1, -2, 3, 4, -5)))
            println(SumNumber().test(intArrayOf(5,5,5,5)))
        }
    }
}