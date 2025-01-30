package top150

import kotlin.math.min

/**
 * 77. Combinations!!
 * 2h30m
 * 현재 값을 배열에 넣고 dp 호출
 * dp응 답받으면 removeLast 처리
 * 다음 값을 시도
 * 좋은 방식의 해결과 방법은 비슷하지만, 좀더 효율적으로 해결 가능한 것으로 보임.
 * ==================================
 * 반복문에서 현재 값을 넣는다.
 * next를 current+1로 시작한다.
 * dp에 next를 넣어 호출한다.
 * visited에 값이 있으면 list에 넣고 false를 리턴한다.
 * visited에 값이 없으면 list에 넣고 true를 리턴한다.
 * true면 다시 반복한다.
 * false면 next를 증가시킨다.
 * ===================================
 * 새로운 배열을 만들고 result에 넣는다.
 * current는 1부터시작한다.
 * last는 k부터 시작한다.
 * current부터 k - 1까지 순회한다.
 * 배열에 현재 i를 넣는다.
 * last를 넣고 last++한다.
 * last가 n과 같으면 current++한다.
 * 위를 반복한다.
 * current + k가 n보다 크면 와일문을 탈출한다.
 */
class Combinations {
    private val result: MutableList<MutableList<Int>> = mutableListOf()

    fun combine(n: Int, k: Int): List<List<Int>> {
        dp(n, k, 1, mutableListOf())
        return result
    }

    private fun dp(n: Int, k: Int, value: Int, prev: MutableList<Int>) {
        if (prev.size + 1 == k) {
            for (i in value .. n) {
                val target: MutableList<Int> = mutableListOf()
                result.add(target)
                for (j in prev) {
                    target.add(j)
                }
                target.add(i)
            }
        } else {
            val max = min(value + n - k, n)
            for (i in value .. max) {
                prev.add(i)
                dp(n, k, i + 1, prev)
                prev.removeLast()
            }
        }
    }
}

fun main() {
    println(Combinations().combine(4, 2))
    println(Combinations().combine(2, 1))
    println(Combinations().combine(4, 3))
}