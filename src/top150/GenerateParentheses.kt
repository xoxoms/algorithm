package top150

/**
 * 22. Generate Parentheses !!
 * 더 나은 방법이 많이 있다.
 * backTracking 방식도 개선 필요.
 * ========================
 * 재귀함수를 사용하여,주어진 n번째까지 "("를 삽입한다.
 * n번째가 되면 ")"도 삽입한다.
 * n*2와 지금까지 배열에 쌓인 갯수가 같다면 결과에 저장하고 재귀를 종료한다.
 * 위 과정으로 재귀를 마치고 돌아왔을때 현 함수에서 삽입한 값이 "("이었다면 ")"값을 넣어 다시 호출한다.
 * 반복한다.
 */
class GenerateParentheses {
    private val result = mutableListOf<String>()
    private val sb = StringBuilder()
    private var count1 = 0
    private var count2 = 0

    fun generateParenthesis(n: Int): List<String> {
        recursive(mutableListOf(), n, 0)
        return result
    }

    private fun recursive(
        prev: MutableList<String>,
        n: Int,
        current: Int,
    ) {
        if (prev.size == n * 2) {
            prev.forEach { sb.append(it) }
            result.add(sb.toString())
            sb.clear()
            return
        }

        if (current < n) {
            prev.add("(")
            count1++
            recursive(prev, n, current + 1)
            prev.removeLast()
            count1--
        }

        if (count1 > count2) {
            prev.add(")")
            count2++
            recursive(prev, n, current)
            prev.removeLast()
            count2--
        }
    }
}

fun main() {
    println(GenerateParentheses().generateParenthesis(4))
}