package top150

import java.util.Stack

/**
 * 20. Valid Parentheses
 */
class ValidParentheses {
    fun isValid(s: String): Boolean {
        if (s.length % 2 != 0) return false

        val stack = Stack<String>()
        s.forEach {
            val current = it.toString()
            if (current == "(" || current == "[" || current == "{") {
                stack.push(current)
            } else {
                if (stack.isEmpty()) { return false }
                val pop = stack.pop()
                if (!(pop == "(" && current == ")" || pop == "[" && current == "]" || pop == "{" && current == "}")) {
                    return false
                }
            }
        }

        return stack.isEmpty()
    }
}

fun main() {
    println(ValidParentheses().isValid("()"))
    println(ValidParentheses().isValid("([{}])"))
}