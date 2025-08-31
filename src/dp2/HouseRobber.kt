package dp2

import kotlin.math.max

/**
 * 198. House Robber
 * 15m
 * =================
 * 사이즈가 2미만일때 방어코드가 필요하다.
 * 2부터 nums.size를 순회한다.
 * dp에 이전값 혹은 -2번째 + nums[i]번째 값을 합한 값의 큰 값을 할당한다.
 */
class HouseRobber {
    fun rob(nums: IntArray): Int {

        if (nums.isEmpty()) {
            return 0
        }

        if (nums.size == 1) {
            return nums[0]
        }

        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for(i in 2 ..< nums.size) {
            dp[i] = max(
                dp[i - 2] + nums[i],
                dp[i - 1],
            )
        }

        return dp[nums.size - 1]
    }
}