package top150_2

/**
 * 169. Majority Element
 * 0번 값을 value에 넣어두고 1로 count 초기화한다.
 * 다른값이면 --count
 * 같은값이면 count++한다.
 * 마지막 value 값을 반환한다.
 */
class MajorityElement {
    fun majorityElement(nums: IntArray): Int {
        var value = nums[0]
        var count = 1
        for (i in 1 ..< nums.size) {
            if (nums[i] == value) {
                count++
            } else {
                if (--count == 0) {
                    value = nums[i]
                    count = 1
                }
            }
        }

        return value
    }
}