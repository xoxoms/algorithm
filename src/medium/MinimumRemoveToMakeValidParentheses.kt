package medium

import java.util.*

/**
 * 1249. Minimum Remove to Make Valid Parentheses
 * leftCounter를 두고 처리하는 방법이 더 빠르다고한다.
 * ==============================================
 * (, ) index stack을 각각 둔다.
 * s를 순회하며 인덱스를 삽입한다.
 * 닫힘 괄호의 최상단보다 나중인 열림 괄호는 삭제한다.
 * 닫힘 괄호가 열림 괄호보다 나중이라면 열림과 닫힘 각각 허용한다.
 * 열림괄호가 비었다면 닫힘괄호 삭제한다.
 * 닫힘괄호가 비었다면 열림괄호 삭제한다.
 */
class MinimumRemoveToMakeValidParentheses {
    fun minRemoveToMakeValid(s: String): String {
        val openStack = Stack<Int>()
        val closeStack = Stack<Int>()

        for (i in 0 ..< s.length) {
            if (s[i] == '(') { openStack.push(i) }
            else if (s[i] == ')') { closeStack.push(i) }
        }

        val removeTargets = mutableSetOf<Int>()

        while (openStack.isNotEmpty() || closeStack.isNotEmpty()) {
            val open = openStack.lastOrNull()
            val close = closeStack.lastOrNull()

            if (open == null) {
                removeTargets.add(closeStack.pop())
            } else if (close == null) {
                removeTargets.add(openStack.pop())
            } else if (open > close) {
                removeTargets.add(openStack.pop())
            } else if (open < close) {
                openStack.pop()
                closeStack.pop()
            }
        }

        val sb = StringBuilder()
        for (i in 0 ..< s.length) {
            if (!removeTargets.contains(i)) {
                sb.append(s[i])
            }
        }

        return sb.toString()
    }
}

fun main() {
    println(MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid("lee(t(c)o)de)"))
}