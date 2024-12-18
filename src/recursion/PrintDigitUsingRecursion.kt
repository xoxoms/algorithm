package recursion

class PrintDigitUsingRecursion {

    fun test(value: String) {
        recursive(value, 0)
    }

    private fun recursive(value: String, index: Int) {
        if (index >= value.length) { return }
        print(value[index])
        recursive(value, index + 1)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            PrintDigitUsingRecursion().test("""
                3
                121
                39
                123456
           """.trimIndent())
        }
    }
}