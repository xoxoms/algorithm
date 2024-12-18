package recursion

class PrintEvenIndices {

    fun test(value: String, index: Int) {
        if (index >= value.length) return

        if ((index + 1) % 2 == 1) {
            print(value[index])
        }
        test(value, index + 1)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            PrintEvenIndices().test("12345678", 0)
        }
    }
}