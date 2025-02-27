package leetcode75

/**
 * 283. Move Zeroes !!
 * easy인데 한시간걸렸다.
 * nums를 순회하며 이전까지 0이었던 갯수를 기록한다.
 * 0이아닌 값이 나오면 zeroCount만큼 앞으로 시프트한다.
 */
class MoveZeroes {
    fun moveZeroes(nums: IntArray): Unit {
        var zeroCount = 0

        for (i in 0 ..< nums.size) {
            if (nums[i] == 0) {
                zeroCount++
            } else if (zeroCount > 0) {
                nums[i - zeroCount] = nums[i]
                nums[i] = 0
            }
        }
    }
}

fun main() {
    MoveZeroes().moveZeroes(intArrayOf(1,0,3,0,12))
}