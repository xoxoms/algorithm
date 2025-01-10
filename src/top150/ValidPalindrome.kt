package top150

/**
 * 125. Valid Palindrome
 */
class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        val target = s.uppercase()
        var i = 0
        var j = target.length - 1
        while (i < j) {
            if (!Regex("([A-Za-z0-9])").matches(target[i].toString())) {
                i++
                continue
            }
            if (!Regex("([A-Za-z0-9])").matches(target[j].toString())) {
                j--
                continue
            }

            if (target[i].uppercase() != target[j].uppercase()) {
                return false
            } else {
                i++
                j--
            }
        }

        return true
    }
}

fun main() {
    println(ValidPalindrome().isPalindrome("ab_a"))
//    println(ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"))
}