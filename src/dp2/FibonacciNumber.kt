package dp2

import kotlin.math.max

/**
 * 509. Fibonacci Number
 */
class FibonacciNumber {

    fun fib(n: Int): Int {
        if (n < 2) {
            return max(0, n)
        }

        return fib(n - 1) + fib(n - 2)
    }
}