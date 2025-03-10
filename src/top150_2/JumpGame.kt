package top150_2

/**
 * 55. Jump Game
 * 마지막 인덱스부터 순회한다.
 * 해당 인덱스에 도달할수있는게 있다면 다음 인덱스, 없다면 false 응답.
 */
class JumpGame {
    fun canJump(nums: IntArray): Boolean {
        var target = nums.size - 1
        while (target > 0) {
            for (i in target - 1 downTo 0) {
                if (nums[i] + i >= target) {
                    target--
                    break
                }

                if (i == 0) {
                    return false
                }
            }
        }

        return true
    }
}