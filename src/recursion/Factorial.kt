package recursion

class Factorial {

    fun test(value: Int): Int {
        if (value == 0) return 1
        // 5 = 5 * 4!
        return value * test(value - 1)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Factorial().test(3))
            println(Factorial().test(5))
        }
    }
}