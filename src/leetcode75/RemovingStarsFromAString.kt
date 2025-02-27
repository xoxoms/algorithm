package leetcode75

import java.util.*

/**
 * 2390. Removing Stars From a String
 * 별이면 스택에 pop() 해준다.
 * 아니면 스택에 넣는다.
 * 결과는 0번쨰부터 순회하여 반환한다.
 */
class RemovingStarsFromAString {
    fun removeStars(s: String): String {
        val stack = Stack<Char>()
        val sb = StringBuilder()
        for (i in 0 ..< s.length) {
            if (s[i] == '*') {
                stack.pop()
            } else {
                stack.push(s[i])
            }
        }

        for (i in 0 ..< stack.size) {
            sb.append(stack[i])
        }
        return sb.toString()
    }
}

fun main() {
    println(RemovingStarsFromAString().removeStars("leet**cod*e"))
}