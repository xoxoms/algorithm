package recursion

class PrintBinary {

    fun test(value: Int) {
        if (value == 1) {
            print(1)
            return
        }

        val result = value / 2
        val reminder = value % 2

        test(result)
        print(reminder)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            PrintBinary().test(10)
            println()
            PrintBinary().test(29)
        }
    }
}