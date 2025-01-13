package top150

/**
 * 128. Longest Consecutive Sequence
 * sort()한 후 처리하는게 나은 성능을 보여준다.
 */
class LongestConsecutiveSequence {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.map { it }.toSet()
        var result = 0

        val visited = HashSet<Int>()
        set.forEach {
            if (visited.contains(it)) { return@forEach }
            var i = 1
            var count = 1
            while (set.contains(it + i)) {
                if (set.contains(it + i)) {
                    visited.add(it + i)
                    count++
                }
                i++
            }

            i = 1
            while (set.contains(it - i)) {
                if (set.contains(it - i)) {
                    visited.add(it - i)
                    count++
                }
                i++
            }

            result = maxOf(result, count)
        }

        return result
    }
}

fun main() {
    println(LongestConsecutiveSequence().longestConsecutive(intArrayOf(9,1,4,7,3,-1,0,5,8,-1,6)))
    println(LongestConsecutiveSequence().longestConsecutive(intArrayOf(1,2,0,1)))
    println(LongestConsecutiveSequence().longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
}