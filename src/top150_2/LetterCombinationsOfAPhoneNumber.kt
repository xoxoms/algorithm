package top150_2

/**
 * 17. Letter Combinations of a Phone Number
 * 과거랑 해결 방식이 바뀌었다.
 * ========================
 * 요청 받은 값을 재귀함수로 던진다.
 * 재귀함수는 현재까지 누적된 값에 현재인덱스의 문자열을 조합한 값을 다음 인덱스의 재귀로 넘긴다.
 * 재귀가 마지막 값을 넘으면 결과에 넣고 종료한다.
 */
class LetterCombinationsOfAPhoneNumber {
    private val result = mutableListOf<String>()

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return listOf()
        }

        recursive(digits, "", 0)
        return result
    }

    private fun recursive(digits: String, word: String, idx: Int) {
        if (digits.length == idx) {
            result.add(word)
            return
        }

        val characters = getCharacters(digits[idx])
        for (i in 0 ..< characters.size) {
            recursive(digits, word + characters[i], idx + 1)
        }
    }

    private fun getCharacters(number: Char): List<String> {
        return when (number) {
            '2' -> { listOf("a", "b", "c") }
            '3' -> { listOf("d", "e", "f") }
            '4' -> { listOf("g", "h", "i") }
            '5' -> { listOf("j", "k", "l") }
            '6' -> { listOf("m", "n", "o") }
            '7' -> { listOf("p", "q", "r", "s") }
            '8' -> { listOf("t", "u", "v") }
            '9' -> { listOf("w", "x", "y", "z") }
            else -> { listOf() }
        }
    }
}

fun main() {
    println(LetterCombinationsOfAPhoneNumber().letterCombinations("5678"))
}