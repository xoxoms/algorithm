package leetcode75

/**
 * 1431. Kids With the Greatest Number of Candies
 * 복잡도 신경써서 해결하면 더 낫다.
 */
class KidsWithTheGreatestNumberOfCandies {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val max = candies.maxBy { it }
        val result = mutableListOf<Boolean>()

        for (i in 0 ..< candies.size) {
            result.add(candies[i] + extraCandies >= max)
        }

        return result
    }
}

fun main() {
    println(KidsWithTheGreatestNumberOfCandies().kidsWithCandies(intArrayOf(2,3,5,1,3), 3))
}