package top150_2

/**
 * 15. 3Sum !!
 * 2h
 * 어거지로 해결했으나, 문제를 해결법을 떠오르지 못했다.
 * ====================
 * nums 값을 셋에 넣어둔다.
 * ikj 순으로 인덱스가 순회한다.
 * ik의 합은 -j여야한다.
 * ik의 합이 0보다 크면 계산하지 않아도된다.
 * 셋에 -ik합이 있다면 결과에 넣을수있다.
 */
class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val visited = mutableSetOf<Pair<Int, Int>>()
        nums.sort()

        // nums[i] + nums[k]는 -nusm[j] 여야한다.
        // nums[i] + nums[k]가 0보다 커지면 계산할 필요가 없다.
        val values = nums.toSet()
        for (i in 0 ..< nums.size - 2) {
            for (k in i + 1 ..< nums.size - 1) {
                if (visited.contains(Pair(nums[i], nums[k]))) { continue }
                val sum = nums[i] + nums[k]
                if (sum > 0) { break }
                if (values.contains(-sum)) {
                    visited.add(Pair(nums[i], nums[k]))
                    for (j in k + 1 ..< nums.size) {
                        if (nums[j] == -sum) {
                            result.add(listOf(nums[i], nums[k], nums[j]))
                            break
                        }
                    }
                }
            }
        }

        return result
    }
}