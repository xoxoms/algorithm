package top150

import kotlin.math.abs

/**
 * 219. Contains Duplicate II
 * nums를 순회아며 map<List<Int>>을 초기화한다.
 * map을 순회하며 abs(i, j)가 <= k인 것이 있으면 true 리턴한다.
 */
class ContainsDuplicateII {

    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = hashMapOf<Int, MutableList<Int>>()
        for (i in 0 .. nums.size - 1) {
            map.computeIfAbsent(nums[i]) { mutableListOf() }.add(i)
        }

        map
            .values
            .forEach {
                for (i in 0 until it.size - 1) {
                    if (abs(it[i] - it[i+1]) <= k) {
                        return true
                    }
                }
            }

        return false
    }
}

fun main() {
    println(
        ContainsDuplicateII().containsNearbyDuplicate(
            intArrayOf(1,2,3,1),
            3,
        )
    )
}