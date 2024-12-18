package recursion

class PrintInvertedPyramid {
    private var memo = ""

    fun test(value: Int) {
        if (value == 0) {
            println("==================")
            return
        }

        print(memo)
        memo += " "

        for (i in 0 until (value * 2) - 1) {
            print("*")
        }
        println()

        test(value - 1)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            PrintInvertedPyramid().test(4)
            PrintInvertedPyramid().test(1)
            PrintInvertedPyramid().test(3)
            PrintInvertedPyramid().test(5)
            PrintInvertedPyramid().test(7)
        }
    }
}