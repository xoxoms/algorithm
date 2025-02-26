package leetcode75

/**
 * 345. Reverse Vowels of a String
 * 소문자 대문자 전부 검증하는 함수사용하는게 낫다
 */
class ReverseVowelsOfAString {
    private val set = mutableSetOf<Char>('a','e','i','o','u')

    fun reverseVowels(s: String): String {
        var l = 0
        var r = s.length - 1
        val result = s.toCharArray()

        while (l < r) {
            while (l < r && !set.contains(s[l].lowercaseChar())) {
                l++
            }
            while (r > l && !set.contains(s[r].lowercaseChar())) {
                r--
            }

            if (l < r) {
                var temp = s[l]
                result[l] = s[r]
                result[r] = temp
            }
            l++
            r--
        }

        return result.concatToString()
    }
}

fun main() {
    println(ReverseVowelsOfAString().reverseVowels("0P"))
    println(ReverseVowelsOfAString().reverseVowels("IceCreAm"))
}