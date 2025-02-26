package leetcode75

/**
 * 1071. Greatest Common Divisor of Strings !!
 *
 * 정상 케이스라면 두값을 더했을때 순서 상관없이 같아야한다.
 * 정상 케이스라면 크기가 같아질때까지 큰값에서 작은값의 길이를 빼준다.
 * 크기가 같아지면 동일한 gcd를 찾은것인데, 빈값일수있겠다.
 */
class GreatestCommonDivisorOrStrings {

    fun gcdOfStrings(str1: String, str2: String): String {
        if (str1 + str2 != str2 + str1) return ""
        var l1 = str1.length
        var l2 = str2.length
        while (l1 != l2) {
            if (l1 > l2) l1 = l1 - l2
            else l2 = l2 - l1
        }

        return str1.substring(0, l1)
    }
}

fun main() {
    println(GreatestCommonDivisorOrStrings().gcdOfStrings("ABABAB", "AB"))
    println(GreatestCommonDivisorOrStrings().gcdOfStrings("ABCABC", "ABC"))
}