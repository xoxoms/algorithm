package recursion

class CountVowels {

    private val vowels = setOf('a', 'e', 'i', 'o', 'u')
    private var count = 0
    fun test(value: String, index: Int = 0): Int {
        if (index == value.length) { return count }
        if (vowels.contains(value[index])) { count++ }
        test(value, index + 1)

        return count
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(CountVowels().test("Data Structure Lab"))
            println(CountVowels().test("aeiou"))
        }
    }
}