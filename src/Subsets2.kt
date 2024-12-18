class Subsets2 {

    fun test(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        val current = mutableListOf<Int>()
        backTracking(nums.sortedArray(), result, current, 0)
        return result
    }

    private fun backTracking(nums: IntArray, result: MutableList<MutableList<Int>>, current: MutableList<Int>, idx: Int) {
        result.add(ArrayList(current))

        var prev = Int.MAX_VALUE
        for (i in idx until nums.size) {
            if (prev == nums[i]) {
                continue
            }
            current.add(nums[i])
            backTracking(nums, result, current, i + 1)
            current.removeLast()
            prev = nums[i]
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Subsets2().test(intArrayOf(1, 2, 2))
        }
    }
}