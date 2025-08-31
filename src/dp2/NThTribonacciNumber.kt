package dp2

/**
 * 1137. N-th Tribonacci Number
 * 뭔가 좀더 나은 해법이있는거같다.
 * ============================
 * 방문처리하여 재계산하지 않도록 한다.
 * n - 1, 2, 3을 합친 값을 응답한다.
 */
class NThTribonacciNumber {
    private val map = mutableMapOf<Int, Int>()

    fun tribonacci(n: Int): Int {
        if (n == 0) { return 0 }
        if (n < 3) { return 1 }
        if (map[n] != null) {
            return map[n]!!
        }

        val result = tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1)
        map[n] = result
        return result
    }
}