package medium

import kotlin.math.ceil
import kotlin.math.min

/**
 * 875. Koko Eating Bananas !!
 * 이진탐색으로 계산한다.
 * 전혀떠올리지못해 시간이 오래걸렸다.
 */
class KokoEatingBananas {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var l = 1
        var r = piles.max()
        var result = r

        while (l <= r) {
            var k = (l + r) / 2
            var hour = 0L
            piles.forEach { hour += ceil(it.toDouble() / k).toLong() }
            if (hour <= h) {
                result = min(result, k)
                r = k - 1
            } else {
                l = k + 1
            }
        }

        return result
    }
}

fun main() {
    println(KokoEatingBananas().minEatingSpeed(intArrayOf(1000000000, 1000000000), 3))
    println(KokoEatingBananas().minEatingSpeed(intArrayOf(10,1000000000), 3))
    println(KokoEatingBananas().minEatingSpeed(intArrayOf(1000000000), 2))
    println(KokoEatingBananas().minEatingSpeed(intArrayOf(10), 9))
    println(KokoEatingBananas().minEatingSpeed(intArrayOf(312884470), 312884469))
    println(KokoEatingBananas().minEatingSpeed(intArrayOf(1000000000, 1000000000), 3)) // 1000000000 ~ 1000000000
    println(KokoEatingBananas().minEatingSpeed(intArrayOf(1000000000, 1000000000), 4)) // 500000000 ~ 1000000000
    println(KokoEatingBananas().minEatingSpeed(intArrayOf(1000000000, 1000000000), 5)) // 500000000 ~ 1000000000
    println(KokoEatingBananas().minEatingSpeed(intArrayOf(1000000000, 1000000000), 6)) // 333333333 ~ 1000000000

    println(KokoEatingBananas().minEatingSpeed(intArrayOf(3,6,7,11), 4)) // 3 ~ 11
    println(KokoEatingBananas().minEatingSpeed(intArrayOf(3,6,7,11), 5)) // 3 ~ 11
    println(KokoEatingBananas().minEatingSpeed(intArrayOf(3,6,7,11), 8)) // 2 ~ 11
    println(KokoEatingBananas().minEatingSpeed(intArrayOf(3,6,7,11), 8)) // h - size + 1 = k, ceil(last / k)
    println(KokoEatingBananas().minEatingSpeed(intArrayOf(3,6,7,11), 5))
    println(KokoEatingBananas().minEatingSpeed(intArrayOf(3,6,7,11), 9))
}