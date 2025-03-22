package top150_2

/**
 * 125. Valid Palindrome
 * 단순 노가다 알고리즘이다.
 */
class ValidPalindrome {

    fun isPalindrome(s: String): Boolean {
        val word = s.lowercase()

        var i = 0
        var j = s.length - 1
        while (i < j) {
            val left = word[i].toInt()
            if (!((left >= 48 && left < 58) || (left > 96 && left < 123))) {
                i++
                continue
            }

            val right = word[j].toInt()
            if (!((right >= 48 && right < 58) || (right > 96 && right < 123))) {
                j--
                continue
            }

            if (left != right) {
                return false
            } else {
                i++
                j--
            }
        }

        return true
    }
}