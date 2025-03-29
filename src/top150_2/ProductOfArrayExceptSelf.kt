package top150_2

/**
 * 238. Product of Array Except Self
 * 나눗셈을 써선안되고 O(n)으로 해결해야한다.
 * 자기 자신 이전 원소들의 곱셈 값을 기록한다.
 * 자기 자신 이후 원소들의 곱셈값을 위 값과 곱한다.
 */
class ProductOfArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        var result = IntArray(nums.size)
        var prev = 1
        for (i in 0 ..< nums.size) {
            result[i] = prev
            prev = prev * nums[i]
        }

        var next = 1
        for (i in nums.size - 1 downTo 0) {
            result[i] = result[i] * next
            next = next * nums[i]
        }

        return result
    }
}