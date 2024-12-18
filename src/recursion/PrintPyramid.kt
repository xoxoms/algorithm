package recursion

class PrintPyramid {
    var memo = "*"

    fun test(value: Int) {
        if (value == 0) {
            println("============================")
            return
        }
        for (i in 0 until value - 1) {
            print(" ")
        }
        println(memo)
        memo += "**"
        test(value - 1)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            PrintPyramid().test(4)
            PrintPyramid().test(1)
            PrintPyramid().test(3)
            PrintPyramid().test(5)
            PrintPyramid().test(7)
        }
    }
}