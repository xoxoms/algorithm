package top150_2

import kotlin.math.max

/**
 * 198. House Robber
 * 25m
 * 해결 방식이 별로인듯하다.
 * ====================
 * 현재값을 이전 [ 2번쨰와 3번째 ] 중 큰 값과 더한 값으로 업데이트한다.
 */
class HouseRobber {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) { return nums[0] }
        for (i in 2 ..< nums.size) {
            nums[i] = if (i > 2 && nums[i - 2] < nums[i - 3]) {
                nums[i - 3] + nums[i]
            } else {
                nums[i - 2] + nums[i]
            }
        }

        return max(nums.last(), nums[nums.size - 2])
    }
}