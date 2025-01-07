package top150

/**
 * 13. Roman to Integer
 */
class RomanToInteger {
    fun romanToInt(s: String): Int {
        var text = s

        var result = 0
        while (text.length > 0) {
            val substring = if (text.startsWith("M")) {
                result += 1000
                1
            } else if (text.startsWith("CM")) {
                result += 900
                2
            } else if (text.startsWith("D")) {
                result += 500
                1
            } else if (text.startsWith("CD")) {
                result += 400
                2
            } else if (text.startsWith("C")) {
                result += 100
                1
            } else if (text.startsWith("XC")) {
                result += 90
                2
            } else if (text.startsWith("L")) {
                result += 50
                1
            } else if (text.startsWith("XL")) {
                result += 40
                2
            } else if (text.startsWith("X")) {
                result += 10
                1
            } else if (text.startsWith("IX")) {
                result += 9
                2
            } else if (text.startsWith("V")) {
                result += 5
                1
            } else if (text.startsWith("IV")) {
                result += 4
                2
            } else {
                result += 1
                1
            }

            text = text.substring(substring)
        }

        return result
    }
}

fun main() {
    println(RomanToInteger().romanToInt("MCMXCIV"))
    println(RomanToInteger().romanToInt("III"))
    println(RomanToInteger().romanToInt("LVIII"))
}