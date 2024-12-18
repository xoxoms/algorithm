package recursion

class Fibonacci {

    fun test(value: Int): Int {
        if (value < 3) return value - 1
        return test(value - 1) + test(value - 2)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Fibonacci().test(1))
            println(Fibonacci().test(2))
            println(Fibonacci().test(3))
            println(Fibonacci().test(4))
            println(Fibonacci().test(5))
            println(Fibonacci().test(6))
            println(Fibonacci().test(7))
        }
    }
}