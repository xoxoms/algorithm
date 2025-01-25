package top150

/**
 * 17. Letter Combinations of a Phone Number !!
 * idx가 증가할때마다 특정 인덱스의 값이 변경되게끔해서 해결했다.
 * 별로 좋은 방식의 해결은 아닌듯하다.
 */
class LetterCombinationsOfAPhoneNumber {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()

        val targets = mutableListOf<String>()
        for (digit in digits) {
            val target = when (digit) {
                '2' -> "abc"
                '3' -> "def"
                '4' -> "ghi"
                '5' -> "jkl"
                '6' -> "mno"
                '7' -> "pqrs"
                '8' -> "tuv"
                '9' -> "wxyz"
                else -> return emptyList()
            }

            targets.add(target)
        }

        val sizeList = targets.map { it.length }
        val endCount = sizeList.reduce { acc, i -> acc * i }
        var idx = 0
        val sb = StringBuilder()
        val result = mutableListOf<String>()

        val modArray = IntArray(targets.size)
        var prevSize = targets[0].length
        for (i in 1 ..< targets.size) {
            modArray[i] = prevSize
            prevSize *= targets[i].length
        }

        while (idx < endCount) {
            for (i in 0 ..< targets.size) {
                val charIdx = if (i == 0) {
                    idx % targets[i].length
                } else {
                    idx / modArray[i] % targets[i].length
                }
                val currentValue = targets[i][charIdx]
                sb.append(currentValue)
            }
            idx++

            result.add(sb.toString())
            sb.clear()
        }

        return result
    }
}

fun main() {
    println(LetterCombinationsOfAPhoneNumber().letterCombinations("5678"))
}