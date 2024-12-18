package recursion

class PrintFrom1ToN {

    fun test(value: Int) {
        if (value > 0) {
            test(value - 1)
            println(value)
        }
    }

    fun test2(value: Int) {
        if (value == 0) return
        println(value)
        test2(value - 1)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            PrintFrom1ToN().test(5)
            PrintFrom1ToN().test2(5)
        }
    }
}