package top150_2

import java.util.LinkedList

/**
 * 150. Evaluate Reverse Polish Notation
 * =====================================
 * 연산이면 pop() 두번 하고 연산 결과 스택에 넣는다.
 * 마지막 pop() 후 리턴한다.
 */
class EvaluateReversePolishNotation {

    fun evalRPN(tokens: Array<String>): Int {
        val stack = LinkedList<Int>()
        tokens.forEach {
            stack.push(
                if (it == "+") {
                    val right = stack.pop()
                    val left = stack.pop()

                    left + right
                } else if (it == "-") {
                    val right = stack.pop()
                    val left = stack.pop()

                    left - right
                } else if (it == "*") {
                    val right = stack.pop()
                    val left = stack.pop()

                    left * right
                } else if (it == "/") {
                    val right = stack.pop()
                    val left = stack.pop()

                    left / right
                } else {
                    it.toInt()
                }
            )
        }

        return stack.pop().toInt()
    }
}

fun main() {
    EvaluateReversePolishNotation().evalRPN(arrayOf("4","13","5","/","+"))
}