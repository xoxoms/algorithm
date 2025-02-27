package leetcode75

/**
 * 1732. Find the Highest Altitude
 * 문제를 이해하는데 어려웠다.
 * 순차대로 더하면서 가장높았던 값을 반환하면된다.
 */
class FindTheHighestAltitude {

    fun largestAltitude(gain: IntArray): Int {
        var result = 0
        var current = result
        for (i in 0 ..< gain.size) {
            current += gain[i]
            if (result < current) result = current
        }

        return result
    }
}

fun main() {
    println(FindTheHighestAltitude().largestAltitude(intArrayOf(-5,1,5,0,-7)))
}